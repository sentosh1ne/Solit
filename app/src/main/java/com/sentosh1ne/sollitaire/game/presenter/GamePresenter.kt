package com.sentosh1ne.sollitaire.game.presenter

import com.sentosh1ne.sollitaire.game.view.GameView

/**
 * Created by sentosh1ne on 04.02.2017.
 */
interface GamePresenter {
    fun onDeckTap()
    fun setGameView(gameView: GameView)
    fun onFoundationTap(foundationIndex: Int)
    fun onTableauTap(tableauIndex: Int, cardIndex: Int)
    fun onWasteTap()
}