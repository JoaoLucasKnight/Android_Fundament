package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutoDAO {

    fun adicionar (produto: Produto){
        produtos.add(produto)
    }

    fun listar(): List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}