package br.com.alura.orgs.ui.recyclerview.adpter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto

class ListProdutosAdpater(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListProdutosAdpater.ViewHolder>() {

    // Criar o proprio ViewHolder e implmenta
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun vincula(produto: Produto) {
            // itemView é o item da lista<Produto>
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    // função para criar o ViewHolder e prrenchida com as informações do layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    // vincula dados com o ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
}

// Criar ViewlHolder > preencha com informações do Layout > vincule os dados
// repete para cada elemento da lista ou os visiveis na tela
