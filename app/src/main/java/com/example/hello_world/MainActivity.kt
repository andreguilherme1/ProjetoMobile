package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hello_world.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contactList = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddPerson.setOnClickListener {
            val name = binding.editTextPersonName.text.toString()
            val phone = binding.editTextPersonPhone.text.toString()
            var isToAdd = true
            if (name.isEmpty()) {
                binding.editTextPersonName.error =
                    getString(R.string.message_field_required, getString(R.string.name))
                isToAdd = false
            }
            if (phone.isEmpty()) {
                binding.editTextPersonPhone.error =
                    getString(R.string.message_field_required, getString(R.string.phone))
                isToAdd = false
            }
            if (isToAdd) {
                contactList.add(Person(name, phone))
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //binding.helloTxt.text = getString(R.string.hello, "André!")
    }

}