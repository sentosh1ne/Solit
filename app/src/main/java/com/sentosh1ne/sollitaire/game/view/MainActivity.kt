package com.sentosh1ne.sollitaire.game.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sentosh1ne.sollitaire.R
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.model.GameModel
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.MainActivityUI
import org.jetbrains.anko.setContentView



class MainActivity : AppCompatActivity(),GameView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        GamePresenterImpl.setGameView(this)
        GameModeLImpl.resetGame()
    }

    override fun update(gameModel: GameModel) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
