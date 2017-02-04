package com.sentosh1ne.sollitaire.game.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sentosh1ne.sollitaire.R
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.model.GameModel
import com.sentosh1ne.sollitaire.game.presenter.GamePresenter
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.MainActivityUI
import com.sentosh1ne.sollitaire.custom.DeckView
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView



class MainActivity : AppCompatActivity(),GameView {

    var deckView: DeckView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        GamePresenterImpl.setGameView(this)
        GameModeLImpl.resetGame()
        deckView = find<DeckView>(R.id.todraw_deck)
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()
    }


}
