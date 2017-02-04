package com.sentosh1ne.sollitaire.game.model

/**
 * Created by sentosh1ne on 04.02.2017.
 */
interface GameModel {
    fun resetGame()
    fun onDeckTap()
    fun onWasteTap()
    fun onFoundationTap(foundation: Int)
    fun onTableauTap(tableau: Int, card: Int)
}