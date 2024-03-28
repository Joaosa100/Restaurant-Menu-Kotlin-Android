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

        binding.paoDeAlho.setOnClickListener {
            val produto = Produto(
                getString(R.string.entPaoDeAlho),
                getString(R.string.ent),
                getString(R.string.entPaoDeAlhoPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.arancine.setOnClickListener {
            val produto = Produto(
                getString(R.string.entArancine),
                getString(R.string.ent),
                getString(R.string.entArancinePrice),
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.rosbife.setOnClickListener {
            val produto = Produto(
                getString(R.string.entRosbife),
                getString(R.string.ent),
                getString(R.string.entRosbifePrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.brusqueta.setOnClickListener {
            val produto = Produto(
                getString(R.string.entBrusqueta),
                getString(R.string.ent),
                getString(R.string.entBrusquetaPrice)
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