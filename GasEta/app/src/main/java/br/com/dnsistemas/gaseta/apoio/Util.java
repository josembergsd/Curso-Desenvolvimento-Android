package br.com.dnsistemas.gaseta.apoio;

import android.widget.Toast;

public class Util {

    public static String calcualrMelhorOpcao(double gasolina, double etanol){
        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if(etanol <= precoIdeal) {
            mensagemDeRetorno = "Abastecer com Etanol";
        }else {
            mensagemDeRetorno = "Abastecer com Gasolina";
        }

        return mensagemDeRetorno;
    }

}
