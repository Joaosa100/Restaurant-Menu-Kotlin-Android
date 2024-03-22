package com.example.kotlin_learn

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_learn.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener {
            val goToFirstView = Intent(this, MainActivity::class.java)
            startActivity(goToFirstView)
        }

        binding.hamburgueres.setOnClickListener{
            val goToMenuHamb = Intent(this, MenuHamb::class.java)
            startActivity(goToMenuHamb)
        }

        binding.cervejas.setOnClickListener{
            val goToMenuBeer = Intent(this, MenuBeer::class.java)
            startActivity(goToMenuBeer)
        }

        binding.soda.setOnClickListener{
            val goToMenuSoda = Intent(this, MenuSoda::class.java)
            startActivity(goToMenuSoda)
        }

        binding.ice.setOnClickListener{
            val goToMenuIce = Intent(this, MenuDessert::class.java)
            startActivity(goToMenuIce)
        }

        binding.organic.setOnClickListener{
            val goToMenuOrganic = Intent(this, MenuSaladas::class.java)
            startActivity(goToMenuOrganic)
        }

        binding.pizza.setOnClickListener{
            val goToMenuPizza = Intent(this, MenuPizza::class.java)
            startActivity(goToMenuPizza)
        }


    }
}