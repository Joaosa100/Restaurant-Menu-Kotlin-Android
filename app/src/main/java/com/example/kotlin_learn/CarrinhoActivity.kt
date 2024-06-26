package com.example.kotlin_learn

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        binding.payButton.setOnClickListener{
            processarPagamento()
        }

        exibirProdutosNoCarrinho()
        exibirTotalDoCarrinho()

    }

    @SuppressLint("SetTextI18n")
    private fun exibirProdutosNoCarrinho() {
        val produtos = CarrinhoSingleton.getProdutos()

        for (produto in produtos) {
            val nomeTextView = TextView(this)
            val tipoTextView = TextView(this)
            val precoTextView = TextView(this)


            nomeTextView.text = "  ${produto.nome}"
            nomeTextView.textSize = 24f
            nomeTextView.setTypeface(null, Typeface.BOLD)
            nomeTextView.setTextColor(ContextCompat.getColor(this, R.color.white))

            when(produto.tempo) {
                getString(R.string.fastTime) -> {
                    tipoTextView.text = "     Type: ${produto.tipo}\n     Wait time: ${produto.tempo} (up to 5min)"
                    tipoTextView.textSize = 22f
                    tipoTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
                }

                getString(R.string.moderateTime) -> {
                    tipoTextView.text = "     Type: ${produto.tipo}\n     Wait time: ${produto.tempo} (up to 10min)"
                    tipoTextView.textSize = 22f
                    tipoTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
                }

                getString(R.string.longTime) -> {
                    tipoTextView.text = "     Type: ${produto.tipo}\n     Wait time: ${produto.tempo} (up to 20min)"
                    tipoTextView.textSize = 22f
                    tipoTextView.setTextColor(ContextCompat.getColor(this, R.color.white))
                }
            }


            precoTextView.text = "     Price: ${produto.preco}"
            precoTextView.textSize = 22f
            precoTextView.setTextColor(ContextCompat.getColor(this, R.color.white))

            nomeTextView.setShadowLayer(
                10f,
                0f,
                0f,
                Color.BLACK
            )
            tipoTextView.setShadowLayer(
                10f, // Raio do contorno
                0f, // Deslocamento horizontal do contorno
                0f, // Deslocamento vertical do contorno
                Color.BLACK // Cor do contorno
            )
            precoTextView.setShadowLayer(
                10f,
                0f,
                0f,
                Color.BLACK
            )


            when (produto.tipo) {
                getString(R.string.hamb) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.red_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.red_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.red_card))
                }
                getString(R.string.ent) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow_card))
                }
                getString(R.string.soda) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_card))
                }
                getString(R.string.ice) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_card))
                }
                getString(R.string.organic) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.green_card))
                }
                getString(R.string.pizza) -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_card))
                    tipoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_card))
                    precoTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_card))
                }
                else -> {
                    nomeTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }

            binding.productContainer.addView(nomeTextView)
            binding.productContainer.addView(tipoTextView)
            binding.productContainer.addView(precoTextView)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun exibirTotalDoCarrinho() {
        val total = CarrinhoSingleton.getTotal()
        val totalFormatado = String.format("%.2f", total)
        val totalTextView = TextView(this)
        totalTextView.text = "Total: $ $totalFormatado"
        totalTextView.textSize = 30f
        binding.productContainer.addView(totalTextView)
    }

    private fun processarPagamento(){
        val total = CarrinhoSingleton.getTotal()
        if (total == 0.0) {
            Toast.makeText(this, "The cart is empty.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Your order has been sent to the restaurant counter!", Toast.LENGTH_LONG).show()
            CarrinhoSingleton.limparCarrinho()
            binding.productContainer.removeAllViews()
            exibirTotalDoCarrinho()
        }
    }

}