package br.com.dnsistemas.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.dnsistemas.appclientevip.R;
import br.com.dnsistemas.appclientevip.controller.CursoController;
import br.com.dnsistemas.appclientevip.controller.PessoaController;
import br.com.dnsistemas.appclientevip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    List<String> nomeDosCursos;
    CursoController cursoController;
    PessoaController controller;
    EditText editText_primeiroNome;
    EditText editText_sobrenome;
    EditText editText_nomeCurso;
    EditText editText_telefoneContato;
    Button button_limpar;
    Button button_salvar;
    Button button_finalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        cursoController = new CursoController();
        nomeDosCursos = cursoController.dadosParaSpinner();

        pessoa = new Pessoa();

        controller.buscar(pessoa);

        initComponents();
        enviaDadosParaTela();
        populaAdapter();

        button_limpar.setOnClickListener(v -> {
            editText_primeiroNome.setText("");
            editText_sobrenome.setText("");
            editText_nomeCurso.setText("");
            editText_telefoneContato.setText("");

            controller.limpar();

        });

        button_salvar.setOnClickListener(v -> {

            Pessoa pessoa = new Pessoa();

            pessoa.setPrimeiroNome(editText_primeiroNome.getText().toString());
            pessoa.setSobrenome(editText_sobrenome.getText().toString());
            pessoa.setCursoDesejado(editText_nomeCurso.getText().toString());
            pessoa.setTelefoneContato(editText_telefoneContato.getText().toString());

            Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_SHORT).show();

            controller.salvar(pessoa);
        });

        button_finalizar.setOnClickListener(v -> finish());
    }

    private void populaAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);
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

        spinner = findViewById(R.id.spinner_lista_cursos);
    }

}