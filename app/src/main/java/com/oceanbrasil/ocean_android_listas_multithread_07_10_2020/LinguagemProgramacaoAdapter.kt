package com.oceanbrasil.ocean_android_listas_multithread_07_10_2020

import android.view.View
import androidx.recyclerview.widget.RecyclerView

data class LinguagemProgramacao(
    val titulo: String,
    val ano: Int,
    val descricao: String
)

class LinguagemProgramacaoAdapter(
    val items: List<LinguagemProgramacao>
) : RecyclerView.Adapter<LinguagemProgramacaoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
