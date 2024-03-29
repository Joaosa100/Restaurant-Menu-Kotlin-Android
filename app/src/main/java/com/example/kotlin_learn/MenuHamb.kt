package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuHambBinding

class MenuHamb : AppCompatActivity() {
    private lateinit var binding: ActivityMenuHambBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuHambBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.hambBasicao.setOnClickListener {
            //val precoString = getString(R.string.hambbasicaoprice)
            val produto = Produto(
                getString(R.string.hambbasicao),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambbasicaoprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }


        binding.bigPicanha.setOnClickListener {
            val produto = Produto(
                getString(R.string.hambBigPicanha),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambbigpicanhaprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.doublePicanha.setOnClickListener {
            val produto = Produto(
                getString(R.string.hambDoublePicanha),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambdoublepicanhaprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.smokedClassic.setOnClickListener {
            val produto = Produto(
                getString(R.string.hambSmokedClassic),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambsmokedclassicprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.baconito.setOnClickListener {
            val produto = Produto(
                getString(R.string.hambBaconito),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambBaconitoprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.chicko.setOnClickListener {
            val produto = Produto(
                getString(R.string.hambChicko),
                getString(R.string.hamb),
                getString(R.string.moderateTime),
                getString(R.string.hambChickoprice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }


        binding.backButton.setOnClickListener {
            val goBackToMenu = Intent(this, Menu::class.java)
            startActivity(goBackToMenu)
        }

        binding.cart.setOnClickListener {
            abrirCarrinho()
        }
    }
    private fun abrirCarrinho() {
        val goToCartMenu = Intent(this, CarrinhoActivity::class.java)
        startActivity(goToCartMenu)
    }

}