package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.databinding.ActivityFormProdutosBinding
import br.com.alura.orgs.databinding.FormImagemBinding
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutosActivity : AppCompatActivity(R.layout.activity_form_produtos) {

    private val binding by lazy {
        ActivityFormProdutosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgProduto.setOnClickListener{
            val binding = FormImagemBinding.inflate(layoutInflater)

            AlertDialog.Builder(this)
                .setView(binding.root)
                .setPositiveButton("Confirmar"){_,_ -> }
                .setNegativeButton("Cancelar"){_,_ -> }
                .show()
        }
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
        val nome = binding.InputTextName.text.toString()
        val desc = binding.InputTextDescricao.text.toString()
        val valorText = binding.InputTextValor.text.toString()
        val valor = BigDecimal(valorText)
        // cria
        return Produto(
            nome = nome,
            descricao = desc,
            valor = valor,
        )

    }
}

