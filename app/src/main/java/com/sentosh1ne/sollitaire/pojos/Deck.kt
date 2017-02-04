package com.sentosh1ne.sollitaire.pojos

import com.sentosh1ne.sollitaire.pojos.Card.Companion.clubs
import com.sentosh1ne.sollitaire.pojos.Card.Companion.diamonds
import com.sentosh1ne.sollitaire.pojos.Card.Companion.hearts
import com.sentosh1ne.sollitaire.pojos.Card.Companion.spades
import java.util.*

/**
 * Created by sentosh1ne on 04.02.2017.
 */
class Deck{
    val cards = Array(52,{ Card(it % 13, getSuit(it)) })
    var currentCards = cards.toMutableList()

    private fun getSuit(i: Int) = when(i){
        0 -> clubs
        1 -> diamonds
        2 -> hearts
        3 -> spades
        else -> {
            throw IllegalArgumentException("Wrong suit id")
        }
    }

    fun draw(): Card = currentCards.removeAt(0);

    fun reset() = {
        currentCards.forEach { card -> card.faceUp = false }
        Collections.shuffle(currentCards)
    }


}