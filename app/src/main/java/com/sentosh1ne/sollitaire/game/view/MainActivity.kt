package com.sentosh1ne.sollitaire.game.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sentosh1ne.sollitaire.R
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.model.GameModel
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.MainActivityUI
import com.sentosh1ne.sollitaire.custom.DeckView
import com.sentosh1ne.sollitaire.custom.WasteView
import com.sentosh1ne.sollitaire.game.view.anko_component.foundationViews
import com.sentosh1ne.sollitaire.pojos.Card
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView




fun View.getCardResource(card: Card): Int {
    val resourceName = "card${card.suit}${Card.cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName,"drawable",context.packageName)
}

class MainActivity : AppCompatActivity(),GameView {

    var deckView: DeckView? = null
    var wasteView: WasteView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        GamePresenterImpl.setGameView(this)
        GameModeLImpl.resetGame()
        deckView = find<DeckView>(R.id.todraw_deck)
        wasteView = find<WasteView>(R.id.waste_pile)
    }

    override fun update(gameModel: GameModel) {
        deckView?.update()
        wasteView?.update()
        foundationViews.forEach {
            it!!.update()
        }
    }


}
