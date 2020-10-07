package com.oceanbrasil.ocean_android_listas_multithread_07_10_2020

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter -> É uma classe do Android que serve como base para a nossa
        //            Cada lista precisa de um adapter customizado que sabe como criar os itens

        // LayoutManager -> É uma classe do Android que a gente só usa
        // Como a lista estará estruturada, Linear (Horizontal ou Vertical), Staggered, etc

        val kotlin = LinguagemProgramacao(
            "Kotlin",
            2011,
            "Kotlin é uma Linguagem de programação multiplataforma, orientada a objetos e funcional, concisa e estaticamente tipada, desenvolvida pela JetBrains em 2011, que compila para a Máquina virtual Java e que também pode ser traduzida para a linguagem JavaScript e compilada para código nativo."
        )

        val java = LinguagemProgramacao(
            "Java",
            1995,
            "Java é o ambiente computacional, ou plataforma, criada pela empresa estadunidense Sun Microsystems, e vendida para a Oracle depois de alguns anos. A plataforma permite desenvolver programas utilizando a linguagem de programação Java."
        )

        val items = listOf(kotlin, java, kotlin, java, kotlin, java, kotlin, java, kotlin)

        rvLinguagemProgramacao.layoutManager = LinearLayoutManager(this)
        rvLinguagemProgramacao.adapter = LinguagemProgramacaoAdapter(items) {
            Toast.makeText(this, "Item clicado: ${it.titulo}", Toast.LENGTH_LONG).show()
        }
    }
}
