package com.platzi.platzistore

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemList : AnkoComponent<TestAdapter> {

    override fun createView(ui: AnkoContext<TestAdapter>): View =
            with(ui) {
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    cardView {
                        linearLayout {
                            orientation = LinearLayout.HORIZONTAL
                            lparams(width = matchParent)

                            imageView(R.mipmap.ic_launcher) {
                                id = R.id.imgItem
                                scaleType = ImageView.ScaleType.CENTER_CROP
                            }.lparams(width = dip(0), height = dip(100), weight = 1f)

                            linearLayout {
                                padding = dip(5)
                                orientation = LinearLayout.VERTICAL

                                textView("Title") {
                                    id = R.id.txt_title_item
                                    setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                                }

                                textView("Description") {
                                    id = R.id.txt_title_desc
                                    setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                                }

                                textView("Price") {
                                    id = R.id.txt_title_price
                                    setTextAppearance(ctx, android.R.style.TextAppearance_Material_Medium)
                                    textColor = resources.getColor(R.color.colorAccent)
                                }.lparams {
                                    topMargin = dip(5)
                                    gravity = Gravity.END
                                }
                            }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                        }
                    }
                }
            }

}