package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.utils.AppConstants
import com.example.motivation.R
import com.example.motivation.databinding.ActivityPhraseBinding
import com.example.motivation.utils.DataPhrases

class PhraseActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPhraseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPhraseBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonNewPhrase.setOnClickListener(this)
        getNameUser()
        phrasesRandom()
    }
    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            phrasesRandom()
        }
    }

    private fun getNameUser() {
        intent.extras?.let {
            val nameUser = it.getString(AppConstants.NAME_KEY)
            binding.textviewNomeUsuario.text = "Olá, $nameUser!"
        }
    }

    private fun phrasesRandom() {
        //val randonPhrase = DataPhrases.phrases.random()
        binding.textviewPhrases.text = DataPhrases.phrases.random().phrases
    }
}