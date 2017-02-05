package com.sentosh1ne.sollitaire.custom

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.sentosh1ne.sollitaire.R
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.presenter.GamePresenter
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.cardBackDrawable
import com.sentosh1ne.sollitaire.game.view.anko_component.emptyPileDrawable
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by sentosh1ne on 04.02.2017.
 */
class DeckView(context : Context): ImageView(context){
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenterImpl.onDeckTap()
        }
    }

    fun update(){
        val cards = GameModeLImpl.deck.currentCards
        imageResource = if (cards.size > 0) cardBackDrawable else emptyPileDrawable
    }
}

val DECKVIEW_FACTORY = { ctx: Context -> DeckView(ctx) }

fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView(DECKVIEW_FACTORY,0,init)