package br.com.cagece.controller;

import br.com.cagece.model.Indicador;
import br.com.cagece.util.JPAUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@ManagedBean(name = "indicadorBean")
@SessionScoped
@ViewScoped
public class IndicadorController {
    
    private Indicador indicador = new Indicador();
    private Integer indicadorId;
    
    /* MÉTODOS */
    public List<Indicador> getIndicadores(){
        System.out.println("----------------------------------- LISTANDO TODOS OS INDICADORES");
        EntityManager em = new JPAUtil().getEntityManager();
        CriteriaQuery<Indicador> query = em.getCriteriaBuilder().createQuery(Indicador.class);
        query.select(query.from(Indicador.class));
        List<Indicador> indicadores = em.createQuery(query).getResultList();
        em.close();
        return indicadores;
    }
    
    public String gravarIndicador(){
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        if (this.indicador.getId() == null) {
            System.out.println("----------------------------------- CADASTRANDO INDICADOR");
            em.persist(indicador);
            em.getTransaction().commit();
            em.close();

            this.indicador = new Indicador();
        }
        else {
            System.out.println("----------------------------------- EDITANDO INDICADOR");            
            em.merge(indicador);
            em.getTransaction().commit();
            em.close();
        }
        
        return "indicador?faces-redirect=true";
        
    }
        
    public void carregarIndicador(Indicador indicador){
        System.out.println("----------------------------------- CARREGANDO DADOS DO INDICADOR");
        this.indicador = indicador;
    }
        
    public void carregarIndicadorPelaId(){
        EntityManager em = new JPAUtil().getEntityManager();
    }
    
    public String excluirIndicador(Indicador indicador){
        System.out.println("----------------------------------- EXCLUINDO INDICADOR");
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Indicador i = em.merge(indicador);
        em.remove(i);
        em.getTransaction().commit();
        em.close();
        return "indicador?faces-redirect=true";
    }

    /* GETTERS AND SETTERS */
    public Indicador getIndicador() {
        return indicador;
    }

    public Integer getIndicadorId() {
        return indicadorId;
    }

    public void setIndicadorId(Integer indicadorId) {
        this.indicadorId = indicadorId;
    }
    
}