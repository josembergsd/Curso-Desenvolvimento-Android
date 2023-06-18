package br.com.dnsistemas.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.dnsistemas.appclientevip.R;
import br.com.dnsistemas.appclientevip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    EditText editText_primeiroNome;
    EditText editText_sobrenome;
    EditText editText_nomeCurso;
    EditText editText_telefoneContato;

    Button button_limpar;
    Button button_salvar;
    Button button_finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mock de Pessoa
        pessoa = new Pessoa("Josemberg", "Sousa Duarte", "Android", "86-99920-8114");
        initComponents();
        enviaDadosParaTela();

        button_limpar.setOnClickListener(v -> clearFields());


        button_salvar.setOnClickListener(v -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setPrimeiroNome(editText_primeiroNome.getText().toString());
            pessoa.setSobrenome(editText_sobrenome.getText().toString());
            pessoa.setCursoDesejado(editText_nomeCurso.getText().toString());
            pessoa.setTelefoneContato(editText_telefoneContato.getText().toString());

            Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();
        });
        button_finalizar.setOnClickListener(v -> finish());
    }

    private void clearFields() {
        editText_primeiroNome.setText("");
        editText_sobrenome.setText("");
        editText_nomeCurso.setText("");
        editText_telefoneContato.setText("");
    }

    private void enviaDadosParaTela() {
        editText_primeiroNome.setText(pessoa.getPrimeiroNome());
        editText_sobrenome.setText(pessoa.getSobrenome());
        editText_nomeCurso.setText(pessoa.getCursoDesejado());
        editText_telefoneContato.setText(pessoa.getTelefoneContato());
    }

    private void initComponents() {
        editText_primeiroNome = findViewById(R.id.editText_firstName);
        editText_sobrenome = findViewById(R.id.editText_secondName);
        editText_nomeCurso = findViewById(R.id.editText_nomeCurso);
        editText_telefoneContato = findViewById(R.id.editText_telefoneContato);

        button_limpar = findViewById(R.id.button_limpar);
        button_salvar = findViewById(R.id.button_salvar);
        button_finalizar = findViewById(R.id.button_finalizar);
    }

}