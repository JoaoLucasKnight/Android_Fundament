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
import br.com.alura.orgs.databinding.ActivityFormProdutosBinding
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutosActivity : AppCompatActivity(R.layout.activity_form_produtos) {

    private val binding by lazy {
        ActivityFormProdutosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configBttSalvar()
    }

    private fun configBttSalvar() {
        // Passa a lista no click chama a criaProduto()
        // salva e volta

        val dao = ProdutoDAO()
         binding.bttSalvar.setOnClickListener{
            dao.adicionar(criaProduto())
            finish()
        }
    }
    private fun criaProduto(): Produto {
        // Busca
        val nome = binding.formNome.text.toString()
        val desc = binding.formDescricao.text.toString()
        val valorText = binding.formValor.text.toString()
        val valor = BigDecimal(valorText)
        // cria
        return Produto(
            nome = nome,
            descricao = desc,
            valor = valor,
        )

    }
}

