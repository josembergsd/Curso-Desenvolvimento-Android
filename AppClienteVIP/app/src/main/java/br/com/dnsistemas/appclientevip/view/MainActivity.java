package br.com.dnsistemas.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.dnsistemas.appclientevip.R;
import br.com.dnsistemas.appclientevip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}