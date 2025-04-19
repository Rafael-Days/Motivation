package com.example.motivation.utils

data class Phrase(
    val idPhrases: Int,
    val phrases: String
)

object dataPhrases {
    val phrases = listOf(
        Phrase(1, "Motivação é isso ai Motivação é isso ai Motivação é isso ai Motivação é isso ai "),
        Phrase(2, "Eu tenho algo a dizer, explicar pra voce, porém garanto a voce, que engraçdo não serei dessa vez"),
        Phrase(3, "Apenas se motive porra, caralho, é só motivar caralhoo"),
        Phrase(4, "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!")
    )

    fun getPhrasesId(id: Int): Phrase? {
        return phrases.find { it.idPhrases == id }
    }
}