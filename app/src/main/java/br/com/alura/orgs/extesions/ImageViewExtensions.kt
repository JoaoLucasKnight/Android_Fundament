package br.com.alura.orgs.extesions

import android.widget.ImageView
import br.com.alura.orgs.R
import coil.load

fun ImageView.carrega(url: String) {
    load(url) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.erro)
    }
}

fun ImageView.carrega(drawableIdRes: Int) {
    load(drawable) {
        placeholder(R.drawable.placeholder)
        error(R.drawable.erro)
    }
}