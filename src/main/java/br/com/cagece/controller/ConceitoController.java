/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cagece.controller;

import br.com.cagece.model.Conceito;
import br.com.cagece.model.Indicador;
import br.com.cagece.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
//import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@ManagedBean(name = "conceitoBean")
@SessionScoped
@ViewScoped
public class ConceitoController implements Serializable {
    
    private Conceito conceito = new Conceito();
    private Integer conceitoId;
    private Integer indicadorId;
        
    /* MÉTODOS */
    public List<Conceito> getConceitos(){
        System.out.println("----------------------------------- LISTANDO TODOS OS CONCEITOS");
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<Conceito> query = em.getCriteriaBuilder().createQuery(Conceito.class);
        query.select(query.from(Conceito.class));
        List<Conceito> conceitos = em.createQuery(query).getResultList();
        em.close();
        return conceitos;
    }
    
    public List<Indicador> getIndicadores(){
        System.out.println("----------------------------------- LISTANDO TODOS OS INDICADORES");
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<Indicador> query = em.getCriteriaBuilder().createQuery(Indicador.class);
        query.select(query.from(Indicador.class));
        List<Indicador> indicadores = em.createQuery(query).getResultList();
        em.close();
        return indicadores;
    }
    
    public List<Indicador> getIndicadoresDoConceito(){
        return this.conceito.getIndicadores();
    }
    
    // GRAVAR INDICADOR ASSOCIADO AO CONCEITO
    public void gravarIndicador(){
        EntityManager em = new JPAUtil().getEntityManager();
        Indicador indicador = em.find(Indicador.class, this.indicadorId);
        this.conceito.cadastrarIndicador(indicador);
        System.out.println("--- Indicador: " +indicador.getTitulo());
    }
    
    public String gravarConceito(){
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        if (conceito.getIndicadores().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("indicador", new FacesMessage("Conceito deve ter pelo menos um indicador."));
        }
        
        if (this.conceito.getId() == null) {
            System.out.println("----------------------------------- CADASTRANDO CONCEITO");
            em.persist(conceito);
            em.getTransaction().commit();
            em.close();
            this.conceito = new Conceito();
        }
        else{
            System.out.println("----------------------------------- EDITANDO CONCEITO");
            em.merge(conceito);
            em.getTransaction().commit();
            em.close();
        }
        
        return "detalhamento?faces-redirect=true";
        
    }
    
    public void carregarConceito(Conceito conceito){
        System.out.println("----------------------------------- CARREGANDO DADOS DO CONCEITO");
        this.conceito = conceito;
    }
    
    public String excluirConceito(Conceito conceito){
        System.out.println("----------------------------------- EXCLUINDO CONCEITO");
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conceito c = em.merge(conceito);
        em.remove(c);
        em.getTransaction().commit();
        em.close();
        return "detalhamento?faces-redirect=true";
    }
    
    public void excluirIndicadorDoConceito(Indicador indicador){
        System.out.println("\"----------------------------------- EXCLUINDO INDICADOR ASSOCIADO AO CONCEITO");
        this.conceito.excluirIndicador(indicador);
    }
    
    public void carregarConceitoPelaId(){
        EntityManager em = new JPAUtil().getEntityManager();
    }
    
    // FORMULÁRIO DE PESQUISA
    public String pesquisarConceito(){
        return "pesquisa";
    }

    /* GETTERS AND SETTERS */
    public Conceito getConceito() {
        return conceito;
    }
    
    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }

    public Integer getConceitoId() {
        return conceitoId;
    }

    public void setConceitoId(Integer conceitoId) {
        this.conceitoId = conceitoId;
    }

    public Integer getIndicadorId() {
        return indicadorId;
    }

    public void setIndicadorId(Integer indicadorId) {
        this.indicadorId = indicadorId;
    }
    
}