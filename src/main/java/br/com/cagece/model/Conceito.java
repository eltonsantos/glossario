/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cagece.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CONCEITO")
public class Conceito implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    private String linkCognos;

    private String linkPentaho;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Indicador> indicadores = new ArrayList<Indicador>();

    /* CONSTRUTORES */
    public Conceito(){
    }
    
    /* MÉTODOS */
    public void cadastrarIndicador(Indicador indicador){
        this.indicadores.add(indicador);
    }
    
    public void excluirIndicador(Indicador indicador){
        this.indicadores.remove(indicador);
    }
    
    /* GETTERS AND SETTERS */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getLinkCognos() {
        return linkCognos;
    }

    public void setLinkCognos(String linkCognos) {
        this.linkCognos = linkCognos;
    }

    public String getLinkPentaho() {
        return linkPentaho;
    }

    public void setLinkPentaho(String linkPentaho) {
        this.linkPentaho = linkPentaho;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }
    
}