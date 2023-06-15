package br.com.dnsistemas.appclientevip.model;

import java.util.Date;

public class Curso {

    private String nomeCurso;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private Integer cargaHorária;
    private String professor;

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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

    public Integer getCargaHorária() {
        return cargaHorária;
    }

    public void setCargaHorária(Integer cargaHorária) {
        this.cargaHorária = cargaHorária;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
