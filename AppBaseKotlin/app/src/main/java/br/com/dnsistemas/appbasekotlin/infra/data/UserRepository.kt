package br.com.dnsistemas.appbasekotlin.infra.data

class UserRepository {

    fun login (email: String, password: String): Boolean {
        return (email != "" && password != "")
    }
}