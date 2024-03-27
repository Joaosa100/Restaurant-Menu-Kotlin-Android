package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuBeerBinding

class MenuBeer : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBeerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBeerBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.itaipava.setOnClickListener {
            val produto = Produto(
                getString(R.string.beerItaipava),
                getString(R.string.beer2),
                getString(R.string.beerItaipavaPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.budweiser.setOnClickListener {
            val produto = Produto(
                getString(R.string.beerBudweiser),
                getString(R.string.beer2),
                getString(R.string.beerBudweiserPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.heineken.setOnClickListener {
            val produto = Produto(
                getString(R.string.beerHeineken),
                getString(R.string.beer2),
                getString(R.string.beerHeinekenPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.stellaArtois.setOnClickListener {
            val produto = Produto(
                getString(R.string.beerStellaArtois),
                getString(R.string.beer2),
                getString(R.string.beerStellaArtoisPrice)
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