package br.com.dnsistemas.appbasekotlin.model

import java.util.UUID


class UserModel {

    lateinit var id: UUID
    var nome: String = ""
    var password: String = ""
}