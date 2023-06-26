package br.com.dnsistemas.gaseta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editGasolina, editEtanol;
    TextView textResultado;
    Button buttonCalcular, buttonLimpar, buttonSalvar, buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        limparCampos();

        buttonSalvar.setOnClickListener(v -> {

        });

        buttonCalcular.setOnClickListener(v -> {
            if(validaCampo()) {
                textResultado.setText(
                        Util.calcualrMelhorOpcao(
                                Double.parseDouble(editGasolina.getText().toString()),
                                Double.parseDouble(editEtanol.getText().toString())
                        )
                );
            }
        });

        buttonLimpar.setOnClickListener(v -> limparCampos());

        buttonFinalizar.setOnClickListener(v -> {finish();});

    }

    private void limparCampos() {
        editGasolina.setText("");
        editEtanol.setText("");
        textResultado.setText(R.string.textView_resultado);
    }

    private boolean validaCampo() {
        if(editGasolina.getText().toString().trim().equals("")){
            Toast.makeText(this, "Campo preço Gasolina obrigatório", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editEtanol.getText().toString().trim().equals("")){
            Toast.makeText(this, "Campo preço Etanol obrigatório", Toast.LENGTH_SHORT).show();
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