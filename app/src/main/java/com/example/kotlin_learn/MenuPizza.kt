package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuPizzaBinding

class MenuPizza : AppCompatActivity() {
    private lateinit var binding: ActivityMenuPizzaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuPizzaBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.pizzaMista.setOnClickListener {
            val produto = Produto(
                getString(R.string.pizzaMista),
                getString(R.string.pizza),
                getString(R.string.pizzaMistaPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.pizzaQuatroQueijos.setOnClickListener {
            val produto = Produto(
                getString(R.string.pizzaQuatroQueijos),
                getString(R.string.pizza),
                getString(R.string.pizzaQuatroQueijosPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.pizzaCalabresa.setOnClickListener {
            val produto = Produto(
                getString(R.string.pizzaCalabresa),
                getString(R.string.pizza),
                getString(R.string.pizzaCalabresaPrice)
            )
            CarrinhoSingleton.adicionarProduto(produto)
            abrirCarrinho()
        }

        binding.pizzaCarneSol.setOnClickListener {
            val produto = Produto(
                getString(R.string.pizzaCarneSol),
                getString(R.string.pizza),
                getString(R.string.pizzaCarneSolPrice)
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