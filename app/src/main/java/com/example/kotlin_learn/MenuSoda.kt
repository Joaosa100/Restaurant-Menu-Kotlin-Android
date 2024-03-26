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

        binding.backButton.setOnClickListener {
            val goBackToMenu = Intent(this, Menu::class.java)
            startActivity(goBackToMenu)
        }

        binding.cart.setOnClickListener {
            val goToCartMenu = Intent(this, CarrinhoActivity::class.java)
            startActivity(goToCartMenu)
        }

    }
}