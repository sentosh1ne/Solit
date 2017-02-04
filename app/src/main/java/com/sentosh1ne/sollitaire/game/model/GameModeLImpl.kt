package com.sentosh1ne.sollitaire.game.model

import com.sentosh1ne.sollitaire.pojos.Card
import com.sentosh1ne.sollitaire.pojos.Card.Companion.clubs
import com.sentosh1ne.sollitaire.pojos.Card.Companion.diamonds
import com.sentosh1ne.sollitaire.pojos.Card.Companion.hearts
import com.sentosh1ne.sollitaire.pojos.Card.Companion.spades
import com.sentosh1ne.sollitaire.pojos.Deck
import com.sentosh1ne.sollitaire.pojos.FoundationPile
import com.sentosh1ne.sollitaire.pojos.TableauPile

/**
 * Created by sentosh1ne on 04.02.2017.
 */
object GameModeLImpl : GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles = arrayOf(FoundationPile(clubs), FoundationPile(diamonds),
            FoundationPile(hearts), FoundationPile(spades))
    val tableauPiles = Array(7, { TableauPile() })

    override fun resetGame() {
        wastePile.clear()
        foundationPiles.forEach { it.clearPile() }
        deck.reset()

        tableauPiles.forEachIndexed { i, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(i + 1, { deck.draw() }).toMutableList()
            tableauPiles[i] = TableauPile(cardsInPile)
        }
    }

    override fun onDeckTap() {
        if (deck.currentCards.size > 0) {
            val card = deck.draw()
            card.faceUp = true
            wastePile.add(card)
        } else {
            deck.currentCards = wastePile
            wastePile.clear()
        }
    }

    override fun onWasteTap() {
        if (wastePile.size > 0) {
            val card = wastePile.last()
            if (playCard(card)) {
                wastePile.remove(card)
            }
        }
    }

    override fun onFoundationTap(foundationIndex: Int) {
        val foundationPile = foundationPiles[foundationIndex]
        if (foundationPile.cards.size > 0) {
            val card = foundationPile.cards.last()
            if (playCard(card)) {
                foundationPile.removeCard(card)
            }
        }
    }

    override fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.cards.size > 0) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        if (cards.size == 1) {
            return playCard(cards.first())
        } else {
            tableauPiles.forEach {
                if (it.addCards(cards)) {
                    return true
                }
            }
        }
        return false
    }

    private fun playCard(card: Card): Boolean {
        foundationPiles.forEach {
            if (it.add(card)) {
                return true
            }
        }

        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))) {
                return true
            }
        }
        return false
    }

    fun debugPrint() {
        var firstLine = if(wastePile.size > 0) "${wastePile.last()}" else "___"
        firstLine = firstLine.padEnd(18)
        foundationPiles.forEach {
            firstLine += if(it.cards.size > 0) "${it.cards.last()}" else "___"
            firstLine += "   "
        }
        println(firstLine)
        println()
        for (i in 0..12) {
            var row = ""
            tableauPiles.forEach {
                row += if (it.cards.size > i) "${it.cards[i]}" else "   "
                row += "   "
            }
            println(row)
        }
    }
}