package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import br.com.alura.orgs.R

class FormProdutosActivity : AppCompatActivity(R.layout.activity_form_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val salvar = findViewById<Button>(R.id.bttSalvar)
        salvar.setOnClickListener {
                val nome = findViewById<EditText>(R.id.formNome).text.toString()
                Log.i("FormProdut", "OnCreate: $nome") }
    }
}

// linha 12 == val campoNome = findViewById<EditText>(R.id.formNome)
//             val nome = campoNome.text.toString()

// Toast() == Alert em desenvolvimento web
// LogVat: no filtro passsa tag:
// listener ele gerencia ação no casao de click