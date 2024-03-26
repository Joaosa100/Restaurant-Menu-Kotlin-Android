package com.example.kotlin_learn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityCarrinhoBinding

class CarrinhoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarrinhoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCarrinhoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener {
            val goBackToMenu = Intent(this, Menu::class.java)
            startActivity(goBackToMenu)
        }

        exibirProdutosNoCarrinho()
        exibirTotalDoCarrinho()

    }

    @SuppressLint("SetTextI18n")
    private fun exibirProdutosNoCarrinho() {
        val produtos = CarrinhoSingleton.getProdutos()

        for (produto in produtos) {
            val nomeTextView = TextView(this)
            nomeTextView.text = "Nome: ${produto.nome}"
            binding.productContainer.addView(nomeTextView)

            val tipoTextView = TextView(this)
            tipoTextView.text = "Tipo: ${produto.tipo}"
            binding.productContainer.addView(tipoTextView)

            val precoTextView = TextView(this)
            precoTextView.text = "Preço: ${produto.preco}"
            binding.productContainer.addView(precoTextView)
        }
    }

//    @SuppressLint("SetTextI18n")
//    private fun exibirTotalDoCarrinho() {
//        val totalTextView = TextView(this)
//        totalTextView.text = "Total: R$ ${CarrinhoSingleton.getTotal()}"
//        binding.productContainer.addView(totalTextView)
//    }
    @SuppressLint("SetTextI18n")
    private fun exibirTotalDoCarrinho() {
        val total = CarrinhoSingleton.getTotal()
        val totalFormatado = String.format("%.2f", total) // Formata o total para duas casas decimais
        val totalTextView = TextView(this)
        totalTextView.text = "Total: R$ $totalFormatado"
        binding.productContainer.addView(totalTextView)
    }


}