package com.sentosh1ne.sollitaire.pojos

/**
 * Created by sentosh1ne on 04.02.2017.
 */
class FoundationPile(val suit: String){
    val cards : MutableList<Card> = mutableListOf()

    fun clearPile(){
        cards.clear()
    }

    fun removeCard(card : Card){
        cards.remove(card)
    }

    fun add(card: Card): Boolean{
        var next = 0
        if (cards.size > 0)
            next = cards.last().value + 1

        if (card.suit == suit && card.value == next) {
            cards.add(card)
            return true
        }
        return false
    }
}