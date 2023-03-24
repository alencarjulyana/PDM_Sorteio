package com.example.sorteio

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etTexto: EditText
    private lateinit var btnCadastro: Button
    private lateinit var btnSortear: Button
    private lateinit var tvResultado: TextView
    private lateinit var jogo: Jogo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Jogo()

        this.etTexto = findViewById(R.id.etTexto)
        this.btnCadastro = findViewById(R.id.btnCadastro)
        this.btnSortear = findViewById(R.id.btnSortear)
        this.tvResultado = findViewById(R.id.tvResultado)

        this.btnCadastro.setOnClickListener({ cadastrar() })
        this.btnSortear.setOnClickListener({ sortear() })

    }

    fun cadastrar() {
        val texto = this.etTexto.text.toString()
        this.jogo.adicionar(texto)
        Log.i("APP_SORTEIO", this.jogo.lista.toString())
        this.etTexto.text.clear()
    }

    fun sortear() {
        val texto = this.jogo.sortear()
        if (texto == null) {
            Toast.makeText(this, "Escreva algo para poder jogar!", Toast.LENGTH_SHORT).show()
        } else {
            this.tvResultado.text = texto
        }
    }

}