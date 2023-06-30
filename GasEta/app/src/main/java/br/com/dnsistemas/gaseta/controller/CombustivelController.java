package br.com.dnsistemas.gaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

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
        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco",(float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        //Banco de Dados
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("preco", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel", dados);

    }

    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
