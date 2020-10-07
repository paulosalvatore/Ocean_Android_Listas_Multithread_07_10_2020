package com.oceanbrasil.ocean_android_listas_multithread_07_10_2020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter -> É uma classe do Android que serve como base para a nossa
        //            Cada lista precisa de um adapter customizado que sabe como criar os itens

        // LayoutManager -> É uma classe do Android que a gente só usa
        // Como a lista estará estruturada, Linear (Horizontal ou Vertical), Staggered, etc
    }
}
