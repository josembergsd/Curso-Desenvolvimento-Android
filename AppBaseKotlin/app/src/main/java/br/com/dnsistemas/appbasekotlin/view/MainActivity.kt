package br.com.dnsistemas.appbasekotlin.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.dnsistemas.appbasekotlin.R
import br.com.dnsistemas.appbasekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) //Instaciamenta da viewmodel
        setObserver()

        binding.buttonLogin.setOnClickListener(this)

    }

    fun setObserver(){
        viewModel.welcome().observe(this, Observer {
            binding.textViewTituloLogin.text = it
        })

        viewModel.login().observe(this) {
            if(it){
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Digite usuário e senha", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //------------------------------- AÇÃO DOS BOTÕES --------------------------------------
    override fun onClick(v: View?) {

        if (v?.id == R.id.button_login){

            val email = binding.editEmailAddress.text.toString()
            val password = binding.editNumberPassword.text.toString()

            viewModel.doLogin(email, password)
        }
    }
    
}