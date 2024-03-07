package com.example.networkconection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hello_world.R
import com.example.hello_world.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.helloTxt.text = getString(R.string.hello, "Daivid!")
    }

}