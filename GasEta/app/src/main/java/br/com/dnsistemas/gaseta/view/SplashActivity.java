package br.com.dnsistemas.gaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.dnsistemas.gaseta.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(() -> {
            Intent telaPrincipal = new Intent(SplashActivity.this, GasEtaActivity.class);
            startActivity(telaPrincipal);
            finish();
        }, TIME_OUT_SPLASH);
    }
}