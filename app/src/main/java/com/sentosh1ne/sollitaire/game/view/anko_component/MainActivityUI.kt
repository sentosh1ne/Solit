package com.sentosh1ne.sollitaire.game.view.anko_component

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

class MainActivityUI : AnkoComponent<MainActivity>{
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        val cardHeight = cardWidth * 190 / 140
        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
                deckView{
                    id = R.id.todraw_deck
                }.lparams(cardWidth, cardHeight)
                wasteView {
                    id = R.id.waste_pile
                }.lparams(cardWidth, cardHeight)
                view().lparams (cardWidth, 0)
                for (i in 0..3) {
                    foundationViews[i] = foundationView(i).lparams(cardWidth, cardHeight)
                }
            }

            linearLayout {

            }
        }
    }


}



