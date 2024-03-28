package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuSodaBinding

class MenuSoda : AppCompatActivity() {
    private lateinit var binding: ActivityMenuSodaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuSodaBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.cocaCola.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaCocaCola),
                getString(R.string.soda),
                getString(R.string.sodaCocaColaPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.pepsi.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaPepsi),
                getString(R.string.soda),
                getString(R.string.sodaPepsiPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.guaranaJesus.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaGuaranaJesus),
                getString(R.string.soda),
                getString(R.string.sodaGuaranaJesusPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.saoGeraldo.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaSaoGeraldo),
                getString(R.string.soda),
                getString(R.string.sodaSaoGeraldoPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.itaipava.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaItaipava),
                getString(R.string.soda),
                getString(R.string.sodaItaipavaPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.heineken.setOnClickListener {
            val produto = Produto(
                getString(R.string.sodaHeineken),
                getString(R.string.soda),
                getString(R.string.sodaHeinekenPrice)
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