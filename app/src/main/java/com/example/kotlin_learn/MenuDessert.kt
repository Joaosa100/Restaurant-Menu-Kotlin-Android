package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuDessertBinding

class MenuDessert : AppCompatActivity() {
    private lateinit var binding: ActivityMenuDessertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuDessertBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.boloDeLimao.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertBoloLimao),
                getString(R.string.ice),
                getString(R.string.dessertBoloLimaoPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.boloDeMorango.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertBoloMorango),
                getString(R.string.ice),
                getString(R.string.dessertBoloMorangoPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.sobremesaMaracuja.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertMaracuja),
                getString(R.string.ice),
                getString(R.string.dessertMaracujaPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.boloBanana.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertBoloBanana),
                getString(R.string.ice),
                getString(R.string.dessertBoloBananaPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.doceDeChurros.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertDoceDeChurros),
                getString(R.string.ice),
                getString(R.string.dessertDoceDeChurrosPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.doceDeLeiteNinho.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertDoceDeLeiteNinho),
                getString(R.string.ice),
                getString(R.string.dessertDoceDeLeiteNinhoPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.paoDeMel.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertPaoDeMel),
                getString(R.string.ice),
                getString(R.string.dessertPaoDeMelPrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.paveDeAmendoim.setOnClickListener {
            val produto = Produto(
                getString(R.string.dessertPaveDeAmendoim),
                getString(R.string.ice),
                getString(R.string.dessertPaveDeAmendoimPrice),
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