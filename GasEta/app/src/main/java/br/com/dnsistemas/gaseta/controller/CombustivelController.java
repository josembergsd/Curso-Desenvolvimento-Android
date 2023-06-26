package br.com.dnsistemas.gaseta.controller;

import android.content.SharedPreferences;

import br.com.dnsistemas.gaseta.model.Combustivel;
import br.com.dnsistemas.gaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "oref_gaseta";

    public CombustivelController(GasEtaActivity activity) {
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();
    }

    public void salvar(Combustivel combustivel) {
        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco",(float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());

        dadosPreferences.apply();
    }

    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }
}
