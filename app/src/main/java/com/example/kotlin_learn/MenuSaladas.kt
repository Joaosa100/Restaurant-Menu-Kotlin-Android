package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuSaladasBinding

class MenuSaladas : AppCompatActivity() {
    private lateinit var binding: ActivityMenuSaladasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuSaladasBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.saladaAbacate.setOnClickListener {
            val produto = Produto(
                getString(R.string.organicSaladaAbacate),
                getString(R.string.organic),
                getString(R.string.moderateTime),
                getString(R.string.organicSaladaAbacatePrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.saladaOvo.setOnClickListener {
            val produto = Produto(
                getString(R.string.organicSaladaOvo),
                getString(R.string.organic),
                getString(R.string.longTime),
                getString(R.string.organicSaladaOvoPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.saladaRepolhoRoxo.setOnClickListener {
            val produto = Produto(
                getString(R.string.organicSaladaRepolhoRoxo),
                getString(R.string.organic),
                getString(R.string.moderateTime),
                getString(R.string.organicSaladaRepolhoRoxoPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.saladaGraoDeBico.setOnClickListener {
            val produto = Produto(
                getString(R.string.organicSaladaGraoDeBico),
                getString(R.string.organic),
                getString(R.string.moderateTime),
                getString(R.string.organicSaladaGraoDeBicoPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.backButton.setOnClickListener {
            val goBackToMenu = Intent(this, Menu::class.java)
            startActivity(goBackToMenu)
        }

        binding.cart.setOnClickListener {
            val goToCartMenu = Intent(this, CarrinhoActivity::class.java)
            startActivity(goToCartMenu)
        }

    }

    private fun abrirCarrinho() {
        val goToCartMenu = Intent(this, CarrinhoActivity::class.java)
        startActivity(goToCartMenu)
    }
}