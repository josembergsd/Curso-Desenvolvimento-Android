package br.com.dnsistemas.appclientevip.model;

import java.util.Objects;

public class Pessoa {

    private int id;
    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefoneContato;

    public Pessoa(String primeiroNome, String sobrenome, String cursoDesejado, String telefoneContato) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cursoDesejado = cursoDesejado;
        this.telefoneContato = telefoneContato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa() { }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(primeiroNome, pessoa.primeiroNome) && Objects.equals(sobrenome, pessoa.sobrenome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiroNome, sobrenome);
    }
}
