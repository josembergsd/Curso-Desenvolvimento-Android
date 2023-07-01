package br.com.dnsistemas.gaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.dnsistemas.gaseta.R;
import br.com.dnsistemas.gaseta.apoio.Util;
import br.com.dnsistemas.gaseta.controller.CombustivelController;
import br.com.dnsistemas.gaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    EditText editGasolina, editEtanol;
    TextView textResultado;
    Button buttonCalcular, buttonLimpar, buttonSalvar, buttonFinalizar;
    Combustivel combustivelGasolina, combustivelEtanol, combustivel;
    Double precoGasolina, precoEtanol;

    List<Combustivel> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        limparCampos();
        controller = new CombustivelController(GasEtaActivity.this);
        dados = controller.getListaDeDados();

        buttonCalcular.setOnClickListener(v -> {
            if(validaCampo()) {
                buttonSalvar.setEnabled(true);
                textResultado.setText(
                        Util.calcualrMelhorOpcao(
                                Double.parseDouble(editGasolina.getText().toString()),
                                Double.parseDouble(editEtanol.getText().toString())
                        ).getRecomendacao()
                );
            }else {
                buttonSalvar.setEnabled(false);
            }
        });

        buttonSalvar.setOnClickListener(v -> {

            combustivel = new Combustivel();
            precoGasolina = Double.parseDouble(editGasolina.getText().toString());
            precoEtanol= Double.parseDouble(editEtanol.getText().toString());
            combustivel = Util.calcualrMelhorOpcao(precoGasolina, precoEtanol);
            controller.salvar(combustivel);
            limparCampos();

            int parada = 0;
        });

        buttonLimpar.setOnClickListener(v -> {
            limparCampos();
            controller.limpar();
        });

        buttonFinalizar.setOnClickListener(v -> finish());

    }

    private void limparCampos() {
        editGasolina.setText("");
        editEtanol.setText("");
        textResultado.setText(R.string.textView_resultado);
        buttonSalvar.setEnabled(false);
    }

    private boolean validaCampo() {
        if(editGasolina.getText().toString().trim().equals("")){
            Toast.makeText(this, "Campo preço Gasolina obrigatório",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editEtanol.getText().toString().trim().equals("")){
            Toast.makeText(this, "Campo preço Etanol obrigatório",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initComponents() {
        editGasolina = findViewById(R.id.editText_gasolina);
        editEtanol = findViewById(R.id.editText_etanol);
        buttonCalcular =  findViewById(R.id.button_calcular);
        buttonLimpar = findViewById(R.id.button_limpar);
        buttonSalvar = findViewById(R.id.button_salvar);
        buttonFinalizar = findViewById(R.id.button_finalizar);

        textResultado = findViewById(R.id.textView_resultado);
    }
}