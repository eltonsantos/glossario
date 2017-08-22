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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author 211905
 */
@ManagedBean(name = "conceitoBean")
@SessionScoped
public class ConceitoController implements Serializable {

    //private EntityManager manager = JPAUtil().getEntityManager();
    private Conceito conceito;
    private Indicador indicador;
    private List<Indicador> indicadores;

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }
    
    public ConceitoController(){
        this.conceito = new Conceito();
    }
    
    public Conceito getConceito() {
        return conceito;
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
    }
    /*
    public List<Conceito> getListarConceitos() {
        EntityManager manager = JPAUtil().getEntityManager();
        CriteriaQuery<Conceito> query = manager.getCriteriaBuilder().createQuery(Conceito.class);
        query.select(query.from(Conceito.class));
        return manager.createQuery(query).getResultList();
    }
    
    public String cadastrarConceito(){
        manager.getTransaction().begin();
        manager.persist(conceito);
        manager.getTransaction().commit();
        manager.close();
        return "index";
    }
    */    
    public String detalharIndicador(){
        return null;
    }
    
    public String editarConceito(Conceito indicador){
        return null;

    }
        
    public String excluirConceito(Conceito indicador){
        return null;
    }

}