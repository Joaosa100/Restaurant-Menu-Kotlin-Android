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
            val nomeProduto = getString(R.string.hambbasicao)
            val tipoProduto =  getString(R.string.hamb)
            val precoProduto = getString(R.string.hambbasicaoprice)
            abrirCarrinho(nomeProduto, tipoProduto, precoProduto)
        }

        binding.bigPicanha.setOnClickListener {
            val nomeProduto = getString(R.string.hambBigPicanha)
            val tipoProduto =  getString(R.string.hamb)
            val precoProduto = getString(R.string.hambbigpicanhaprice)
            abrirCarrinho(nomeProduto, tipoProduto, precoProduto)
        }

        binding.doublePicanha.setOnClickListener {
            val nomeProduto = getString(R.string.hambDoublePicanha)
            val tipoProduto =  getString(R.string.hamb)
            val precoProduto = getString(R.string.hambdoublepicanhaprice)
            abrirCarrinho(nomeProduto, tipoProduto, precoProduto)
        }

        binding.smokedClassic.setOnClickListener {
            val nomeProduto = getString(R.string.hambSmokedClassic)
            val tipoProduto =  getString(R.string.hamb)
            val precoProduto = getString(R.string.hambsmokedclassicprice)
            abrirCarrinho(nomeProduto, tipoProduto, precoProduto)
        }


        binding.backButton.setOnClickListener {
            val goBackToMenu = Intent(this, Menu::class.java)
            startActivity(goBackToMenu)
        }
    }
    private fun abrirCarrinho(nomeProduto: String, tipoProduto: String, precoProduto: String) {
        // Abre a atividade do carrinho e envia o nome e o preço do produto selecionado
        val intent = Intent(this, CarrinhoActivity::class.java)
        intent.putExtra("nome_produto", nomeProduto)
        intent.putExtra("tipo_produto", tipoProduto)
        intent.putExtra("preco_produto", precoProduto)
        startActivity(intent)
    }

}