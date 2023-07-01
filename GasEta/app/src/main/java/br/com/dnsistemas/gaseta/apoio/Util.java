package br.com.dnsistemas.gaseta.apoio;

import br.com.dnsistemas.gaseta.model.Combustivel;

public class Util {

    public static Combustivel calcualrMelhorOpcao(double gasolina, double etanol){

        Combustivel combustivel = new Combustivel();

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if(etanol <= precoIdeal) {
            combustivel.setNomeDoCombustivel("Etanol");
            combustivel.setPrecoDoCombustivel(etanol);
            combustivel.setRecomendacao("Abastecer com Etanol");
            mensagemDeRetorno = "Abastecer com Etanol";
        }else {
            combustivel.setNomeDoCombustivel("Gasolina");
            combustivel.setPrecoDoCombustivel(gasolina);
            combustivel.setRecomendacao("Abastecer com Gasolina");
            mensagemDeRetorno = "Abastecer com Gasolina";
        }

        //return mensagemDeRetorno;
        return combustivel;
    }

}
