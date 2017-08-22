/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cagece.controller;

import br.com.cagece.model.Conceito;
import br.com.cagece.model.Indicador;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author 211905
 */
@ManagedBean(name = "conceitoBean")
@SessionScoped
@ViewScoped
public class ConceitoController implements Serializable {
    
    private Conceito conceito = new Conceito();
    private Integer conceitoId;
    private Integer indicadorId;
    
    /* MÉTODOS */
    public List<Conceito> getConceitos(){
        return null;
    }
    
    public List<Indicador> getIndicadores(){
        return null;
    }
    
    public void gravarConceito(){
    }
    
    public void carregarConceito(){
    }
    
    public void excluirConceito(){
    }
    
    public void carregarConceitoPelaId(){
    }

    /* GETTERS AND SETTERS */
    public Conceito getConceito() {
        return conceito;
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