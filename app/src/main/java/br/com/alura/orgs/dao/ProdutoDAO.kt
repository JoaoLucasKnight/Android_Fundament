package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutoDAO {

    fun adicionar (produto: Produto){
        produtos.add(produto)
    }

    fun listar(): List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf(
            Produto(
                nome = "Cesta De frutas",
                descricao = "Laranja, limão e Abacaxi",
                valor = BigDecimal("14.09"),
                img = "https://images.pexels.com/photos/1132047/pexels-photo-1132047.jpeg"
            )
        )
    }
}