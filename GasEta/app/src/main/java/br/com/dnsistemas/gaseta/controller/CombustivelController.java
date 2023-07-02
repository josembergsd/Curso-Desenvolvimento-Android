package br.com.dnsistemas.gaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import br.com.dnsistemas.gaseta.database.GasEtaDb;
import br.com.dnsistemas.gaseta.model.Combustivel;
import br.com.dnsistemas.gaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDb{

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel) {

        ContentValues dados = new ContentValues();
        //SharedPreferences
        dadosPreferences.putString("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel",(float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        //Banco de Dados
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel", dados);

    }

    public List<Combustivel> getListaDeDados(){
        return listarDados();
    }

    public void alterarDados(Combustivel combustivel){
        ContentValues dados = new ContentValues();
        //Banco de Dados
        dados.put("id", combustivel.getId());
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel", dados);
    }

    public void excluirDados(int id){
        deletarObjeto("Combustivel", id);
    }
    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
