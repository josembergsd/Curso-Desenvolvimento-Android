package br.com.dnsistemas.appclientevip.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import br.com.dnsistemas.appclientevip.database.ListaVipDb;
import br.com.dnsistemas.appclientevip.model.Pessoa;
import br.com.dnsistemas.appclientevip.view.MainActivity;

public class PessoaController extends ListaVipDb {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {
        ContentValues dados = new ContentValues();
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobrenome", pessoa.getSobrenome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        salvarObjeto("Pessoa", dados);
    }

    public Pessoa buscarDadosSharedPreferences(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }
    public List<Pessoa> getListaDeDados(){
        return listarDados();
    }

    public void alterarDados(Pessoa pessoa){
        ContentValues dados = new ContentValues();
        //Banco de Dados
        dados.put("id", pessoa.getId());
        dados.put("primeiroNome", pessoa.getPrimeiroNome());
        dados.put("sobrenome", pessoa.getSobrenome());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());
        dados.put("telefoneContato", pessoa.getTelefoneContato());

        alterarObjeto("Pessoa", dados);
    }

    public void deletar(int id){
        deletarObjeto("Pessoa", id);
    }
    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
