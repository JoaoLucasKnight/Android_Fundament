package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.databinding.ActivityFormProdutosBinding
import br.com.alura.orgs.databinding.FormImagemBinding
import br.com.alura.orgs.ui.dialog.FormImgDialog
import br.com.alura.orgs.extesions.carrega
import br.com.alura.orgs.model.Produto
import coil.load
import java.math.BigDecimal

class FormProdutosActivity : AppCompatActivity(R.layout.activity_form_produtos) {

    private val binding by lazy {
        ActivityFormProdutosBinding.inflate(layoutInflater)
    }

    private var url: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title= "Cadastro de Produto"

        binding.imgProduto.setOnClickListener{

            FormImgDialog(this).mostra(url) {
                url = it
                binding.imgProduto.carrega(it)
            }
        }
        configBttSalvar()
    }

    private fun configBttSalvar() {
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
        val valor = if (valorText.isBlank()){
            BigDecimal.ZERO
        }else{
            BigDecimal(valorText)
        }

        // cria
        return Produto(
            nome = nome,
            descricao = desc,
            valor = valor,
            img = url
        )

    }
}

