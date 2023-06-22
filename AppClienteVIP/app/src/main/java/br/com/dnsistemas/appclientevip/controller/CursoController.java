package br.com.dnsistemas.appclientevip.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.dnsistemas.appclientevip.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos() {

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Html"));
        listCursos.add(new Curso("Kotlin"));
        listCursos.add(new Curso("Flutter"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("Spring Boot"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaDeCursos().size(); i++){
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeCurso());
        }
        return dados;
    }

}
