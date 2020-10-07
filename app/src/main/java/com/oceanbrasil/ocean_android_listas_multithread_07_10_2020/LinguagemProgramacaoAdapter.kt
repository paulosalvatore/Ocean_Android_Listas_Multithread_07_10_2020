package com.oceanbrasil.ocean_android_listas_multithread_07_10_2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.linguagem_programacao_item.view.*

data class LinguagemProgramacao(
    val titulo: String,
    val ano: Int,
    val descricao: String
)

class LinguagemProgramacaoAdapter(
    val items: List<LinguagemProgramacao>,
    val listener: (LinguagemProgramacao) -> Unit
) : RecyclerView.Adapter<LinguagemProgramacaoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(
            item: LinguagemProgramacao
        ) = with(itemView) {
            tvTitulo.text = item.titulo
            tvAno.text = item.ano.toString()
            tvDescricao.text = item.descricao

            setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.linguagem_programacao_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }
}
