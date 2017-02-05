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
class WasteView(context: Context) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenterImpl.onWasteTap()
        }
    }

    fun update(){
        val cards = GameModeLImpl.wastePile
        imageResource = if (cards.size > 0) getCardResource(cards.last()) else emptyPileDrawable
    }

}

fun ViewManager.wasteView(init: WasteView.() -> Unit = {}) =
        ankoView({ WasteView(it) },0,init)

