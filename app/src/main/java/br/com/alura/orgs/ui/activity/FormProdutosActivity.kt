package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutosActivity : AppCompatActivity(R.layout.activity_form_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBttSalvar()
    }

    private fun configBttSalvar() {
        // Passa a lista no click chama a criaProduto()
        // salva e volta
        val dao = ProdutoDAO()
         findViewById<Button>(R.id.bttSalvar)
            .setOnClickListener{
            dao.adicionar(criaProduto())
            finish()
        }
    }
    private fun criaProduto(): Produto {
        // Busca
        val nome = findViewById<EditText>(R.id.formNome).text.toString()
        val desc = findViewById<EditText>(R.id.formDescricao).text.toString()
        val valorText = findViewById<EditText>(R.id.formValor).text.toString()
        val valor = BigDecimal(valorText)
        // cria
        return Produto(
            nome = nome,
            descricao = desc,
            valor = valor,
        )

    }
}

