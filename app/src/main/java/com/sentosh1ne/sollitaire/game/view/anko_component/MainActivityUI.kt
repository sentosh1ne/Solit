package com.sentosh1ne.sollitaire.game.view.anko_component

import android.content.Context
import android.view.View
import com.sentosh1ne.sollitaire.R
import com.sentosh1ne.sollitaire.custom.*
import com.sentosh1ne.sollitaire.game.view.MainActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.*
/**
 * Created by sentosh1ne on 04.02.2017.
 */
val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1
val foundationViews: Array<FoundationView?> = kotlin.arrayOfNulls(4)
val tableauViews: Array<TableauView?> = arrayOfNulls(7)
val Context.cardWidth : Int
        get() = (displayMetrics.widthPixels - dip(8)) / 7
val Context.cardHeight: Int
        get() = cardWidth * 190 / 140

class MainActivityUI : AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)
            linearLayout {
                deckView{
                    id = R.id.todraw_deck
                }.lparams(context.cardWidth, context.cardHeight)
                wasteView {
                    id = R.id.waste_pile
                }.lparams(context.cardWidth, context.cardHeight)
                view().lparams (context.cardWidth, 0)
                for (i in 0..3) {
                    foundationViews[i] = foundationView(i).lparams(context.cardWidth, context.cardHeight)
                }
            }

            linearLayout {
                for (i  in 0..6){
                    tableauViews[i] = tableauView(i).lparams(context.cardWidth, matchParent)
                }
            }.lparams(height = matchParent){
                topMargin = context.cardHeight / 2
            }
        }
    }


}



