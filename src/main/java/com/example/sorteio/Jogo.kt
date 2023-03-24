package com.example.sorteio

class Jogo {

    var lista: MutableList<String> = mutableListOf()

    fun adicionar (texto: String){
        this.lista.add(texto)
    }

    fun sortear(): String? {
        if (lista.size > 0)
            return this.lista.random()
        else return null
    }
}