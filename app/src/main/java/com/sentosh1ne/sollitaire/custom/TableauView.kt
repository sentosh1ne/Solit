package com.sentosh1ne.sollitaire.custom

import android.content.Context
import android.view.ViewManager
import com.sentosh1ne.sollitaire.game.model.GameModeLImpl
import com.sentosh1ne.sollitaire.game.presenter.GamePresenterImpl
import com.sentosh1ne.sollitaire.game.view.anko_component.cardBackDrawable
import com.sentosh1ne.sollitaire.game.view.anko_component.cardHeight
import com.sentosh1ne.sollitaire.game.view.anko_component.cardWidth
import com.sentosh1ne.sollitaire.game.view.getCardResource
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by sentosh1ne on 05.02.2017.
 */
class TableauView(context: Context,val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }


    fun update(){
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModeLImpl.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView{
                y = (i * dip(25)).toFloat()
                imageResource = if (card.faceUp) getCardResource(card) else cardBackDrawable
                onClick {
                    GamePresenterImpl.onTableauTap(index,i)
                }
            }.lparams(context.cardWidth,context.cardHeight)
        }
    }
}

fun ViewManager.tableauView(index : Int, init: TableauView.() -> Unit = {}) =
        ankoView( {TableauView(it,index) }, 0, init)