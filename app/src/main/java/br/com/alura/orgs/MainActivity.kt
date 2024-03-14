package br.com.alura.orgs

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nome = findViewById<TextView>(R.id.nome)
        nome.text = "cesta de frutas"
    }

}

// pegar a TexView pelo ID e slava em nome
// seta um texto na textView
// Quando estamos fazendo o alyout usamos apenas o tools,
//  para ter como referencia de como vai ficar. e no layout passamos desta forma

