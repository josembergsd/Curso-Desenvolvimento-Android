package br.com.dnsistemas.appbasekotlin.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dnsistemas.appbasekotlin.infra.data.UserRepository

/**
 * ViewModel são classes encaregadas das regras de negócios
 */
class MainViewModel: ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val userRepository = UserRepository()

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, password: String) {
        login.value = userRepository.login(email, password)
    }

}