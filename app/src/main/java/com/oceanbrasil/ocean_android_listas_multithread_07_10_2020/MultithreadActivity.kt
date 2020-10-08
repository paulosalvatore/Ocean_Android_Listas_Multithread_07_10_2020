package com.oceanbrasil.ocean_android_listas_multithread_07_10_2020

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_multithread.*
import java.net.URL

class MultithreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithread)

        btWorkerThread.setOnClickListener {
            iniciarWorkerThread()
        }
    }

    private fun iniciarWorkerThread() {
        // Estou na main thread

        tvPrincipal.text = "Texto inicial"

        Thread(Runnable {
            // Estou em uma nova Worker Thread

//            Thread.sleep(3000)

            val imagem =
                carregarImagem("https://img.global.news.samsung.com/br/wp-content/uploads/2017/08/20170814_195142.jpg")

            runOnUiThread {
                ivPrincipal.setImageBitmap(imagem)

                tvPrincipal.text = "Imagem carregada."
            }

            /*
            tvPrincipal.post {
                // Voltei para a Main Thread

                tvPrincipal.text = "Texto alterado"
            }
            */
        }).start()

//        Thread.sleep(500)

        tvPrincipal.text = "Texto inicial 2"

        /*
        Processamento paralelo ou operações longas (outras abordagens):

        RxJava, RxAndroid, RxKotlin

        Services -> Android

        AsyncTask -> Quando eu quero controlar um pouco melhor o antes e depois das minhas operações, por exemplo, quero mostrar uma barra de progresso e preparar o app antes da operação. TEM UM CONTROLE MELHOR DO PROCESSO ACONTECENDO

         */
    }

    private fun carregarImagem(urlImagem: String) = try {
        val url = URL(urlImagem)

        val conteudoUrl = url.openConnection().getInputStream()

        BitmapFactory.decodeStream(conteudoUrl)
    } catch (e: Exception) {
        Log.e("CARREGAR_IMAGEM", "Erro ao carregar a imagem a partir da URL: '$urlImagem'.", e)

        null
    }
}
