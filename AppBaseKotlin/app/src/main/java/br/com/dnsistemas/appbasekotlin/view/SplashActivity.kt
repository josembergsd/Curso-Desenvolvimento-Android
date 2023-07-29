package br.com.dnsistemas.appbasekotlin.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import br.com.dnsistemas.appbasekotlin.R
import br.com.dnsistemas.appbasekotlin.databinding.ActivitySplashBinding
import br.com.dnsistemas.appbasekotlin.util.Constantes

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    //TODO: Verificar se existe o sharedpreferences caso não exista criar e direcionar para a tela de login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        if (isLogued()){
            comutarTela(Intent(this, HomeActivity::class.java))
        }else {
            comutarTela(Intent(this, MainActivity::class.java))
        }

    }

    private fun isLogued(): Boolean {
        return getPreferences(MODE_PRIVATE).getBoolean("logued", false)
    }


    fun comutarTela(intent: Intent){
       Handler(Looper.getMainLooper()).postDelayed({
           startActivity(intent)
           finish()
       }, 3000)
   }
}
