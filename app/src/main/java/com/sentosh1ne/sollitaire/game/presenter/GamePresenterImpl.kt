package com.sentosh1ne.sollitaire.game.presenter

import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.model.GameModel
import com.sentosh1ne.sollitaire.game.view.GameView

/**
 * Created by sentosh1ne on 04.02.2017.
 */
object GamePresenterImpl : GamePresenter {
    var view: GameView? = null
    var gameModel = GameModeLImpl

    override fun setGameView(gameView: GameView) {
        view = gameView //To change body of created functions use File | Settings | File Templates.
    }
    override fun onDeckTap() {
        gameModel.onDeckTap()
        view?.update()
    }

    override fun onWasteTap() {
        gameModel.onWasteTap()
        view?.update()
    }

    override fun onFoundationTap(foundationIndex: Int) {
        gameModel.onFoundationTap(foundationIndex)
        view?.update()
    }

    override fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        gameModel.onTableauTap(tableauIndex, cardIndex)
        view?.update()
    }
}