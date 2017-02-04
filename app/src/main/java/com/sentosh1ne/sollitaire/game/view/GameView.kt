package com.sentosh1ne.sollitaire.game.view

import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.model.GameModel

/**
 * Created by sentosh1ne on 04.02.2017.
 */
interface GameView {
    fun update(gameModel: GameModel = GameModeLImpl)
}