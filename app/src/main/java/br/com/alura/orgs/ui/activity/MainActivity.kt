package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adpter.ListProdutosAdpater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list)
        // Pega o RecycleView e reescreve a função adapter
        list.adapter = ListProdutosAdpater(
            context = this,
            // Lista de produtos (preenchida manual)
            produtos = listOf(
            Produto(nome = "teste",
                descricao = "teste desc",
                valor = BigDecimal("19.99")
            ),
            Produto(nome = "teste 1",
                descricao = "teste desc 1",
                valor = BigDecimal("29.99")
            ),
            Produto(nome = "teste 2",
                descricao = "teste desc 2",
                valor = BigDecimal("39.99")
            ),
        ))
        // Edita o layout do RecycleView
        list.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProdutosActivity::class.java)
            startActivity(intent)
        }

    }


}


