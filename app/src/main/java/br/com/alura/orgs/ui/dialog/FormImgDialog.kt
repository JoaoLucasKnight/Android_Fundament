package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.FormImagemBinding
import br.com.alura.orgs.extesions.carrega

class FormImgDialog (private val context: Context) {

    fun mostra(urlPadrao: String = "", quandoConfirma: (url: String) -> Unit) {
        FormImagemBinding.inflate(LayoutInflater.from(context)).apply {
            // this = FormImgBindind esta oculto
            if(urlPadrao.isBlank()) {
                FormImgImg.carrega(R.drawable.citricas)
            } else {
                FormImgImg.carrega(urlPadrao)
            }

            FormImgBtt.setOnClickListener {
                val url = FormImgUrl.text.toString()
                FormImgImg.carrega(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton(
                    "confirmar"
                ) { _, _ ->
                    val url = FormImgUrl.text.toString()
                    quandoConfirma(url)
                }
                .setNegativeButton("cancelar") { _, _ -> }
                .show()
        }
    }

}
