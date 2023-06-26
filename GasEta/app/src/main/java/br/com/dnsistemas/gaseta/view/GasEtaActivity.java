package br.com.dnsistemas.gaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.dnsistemas.gaseta.R;
import br.com.dnsistemas.gaseta.apoio.Util;
import br.com.dnsistemas.gaseta.controller.CombustivelController;
import br.com.dnsistemas.gaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    EditText editGasolina, editEtanol;
    TextView textResultado;
    Button buttonCalcular, buttonLimpar, buttonSalvar, buttonFinalizar;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;
    Double precoGasolina, precoEtanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        limparCampos();
        controller = new CombustivelController(GasEtaActivity.this);

        buttonCalcular.setOnClickListener(v -> {
            if(validaCampo()) {
                buttonSalvar.setEnabled(true);
                textResultado.setText(
                        Util.calcualrMelhorOpcao(
                                Double.parseDouble(editGasolina.getText().toString()),
                                Double.parseDouble(editEtanol.getText().toString())
                        )
                );
            }else {
                buttonSalvar.setEnabled(false);
            }
        });

        buttonSalvar.setOnClickListener(v -> {


            //TODO: EditText inputType
            combustivelGasolina = new Combustivel();
            combustivelEtanol = new Combustivel();

            combustivelGasolina.setNomeDoCombustivel("Gasolina");
            combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

            combustivelEtanol.setNomeDoCombustivel("Etanol");
            combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

            combustivelGasolina.setRecomendacao(Util.calcualrMelhorOpcao(precoGasolina, precoEtanol));
            combustivelEtanol.setRecomendacao(Util.calcualrMelhorOpcao(precoGasolina, precoEtanol));

            controller.salvar(combustivelGasolina);
            controller.salvar(combustivelEtanol);
            limparCampos();

            int parada = 0;
        });

        buttonLimpar.setOnClickListener(v -> limparCampos());

        buttonFinalizar.setOnClickListener(v -> {finish();});

    }

    private void limparCampos() {
        editGasolina.setText("");
        editEtanol.setText("");
        textResultado.setText(R.string.textView_resultado);
        buttonSalvar.setEnabled(false);
        controller.limpar();
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