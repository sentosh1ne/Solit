package com.sentosh1ne.sollitaire.custom

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.emptyPileDrawable
import com.sentosh1ne.sollitaire.game.view.getCardResource
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by sentosh1ne on 05.02.2017.
 */
class FoundationView(context: Context, val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenterImpl.onFoundationTap(index)
        }
    }

    fun update(){
        val cards = GameModeLImpl.foundationPiles[index].cards
        imageResource = if (cards.size > 0) getCardResource(cards.last()) else emptyPileDrawable
    }

}

fun ViewManager.foundationView(index: Int, init : FoundationView.() -> Unit = {}) =
        ankoView({ FoundationView(it, index)}, 0, init)