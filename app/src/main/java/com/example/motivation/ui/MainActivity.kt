package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.utils.AppConstants
import com.example.motivation.R
import com.example.motivation.UserBusiness
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val userBusiness = UserBusiness()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSalvar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_salvar) {
            getNameUser()
        } else {

        }
    }

    private fun getNameUser(){
        val nameUser = binding.edittextQualNome.text.toString()

        if (userBusiness.checkCredentials(nameUser)) {
            val bundle = Bundle()
            bundle.putString(AppConstants.NAME_KEY, nameUser)

            val intent: Intent = Intent(this, PhraseActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.name_information, Toast.LENGTH_SHORT).show()
        }
    }
}