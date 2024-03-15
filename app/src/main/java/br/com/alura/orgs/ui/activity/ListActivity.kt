package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.ui.recyclerview.adpter.ListProdutosAdpater
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(R.layout.activity_main) {
    
    private val dao = ProdutoDAO()
    private val adpater = ListProdutosAdpater(this, produtos = dao.listar())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // configura o recicler com nosso adpter
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adpater.atualiza(dao.listar())
        
    }

    private fun configRecyclerView() {
        val list = findViewById<RecyclerView>(R.id.list)
        list.adapter  = adpater
        list.layoutManager =  LinearLayoutManager(this)
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener { goForm() }
    }

    private fun goForm() {
        val intent = Intent(this, FormProdutosActivity::class.java)
        startActivity(intent)
    }


}


