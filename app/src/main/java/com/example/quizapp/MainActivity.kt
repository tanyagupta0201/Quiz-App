package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.button.setOnClickListener {

            val name = binding.input.editText?.text.toString().trimEnd()

            if(name.isNotEmpty()) {

                val intent = Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putExtra("${SetData.name}", name)
                startActivity(intent)
                finish()

            } else {

                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

    }
}