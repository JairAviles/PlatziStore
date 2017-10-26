package com.platzi.platzistore

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_landing.view.*


class AdapterLanding(val data: List<ItemLanding>) : RecyclerView.Adapter<AdapterLanding.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(parent?.inflate(R.layout.item_landing))

    override fun getItemCount(): Int =
        data.size //To change body of created functions use File | Settings | File Templates.

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    class Holder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        fun bindView(itemLanding: ItemLanding) {
            with(itemLanding) {
                itemView.text_title_item.text = title
                itemView.text_desc_item.text = desc
                itemView.text_price_item.text = "$ ${String.format("%.2f", price)}"

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("title", title)
                    intent.putExtra("desc", desc)
                    intent.putExtra("price", price)

                    val p1:Pair<View, String> = Pair.create(itemView.image_item_header, "transitionHeader")
                    val p2:Pair<View, String> = Pair.create(itemView.text_title_item, "transitionTitle")
                    val p3:Pair<View, String> = Pair.create(itemView.text_desc_item, "transitionDesc")
                    val p4:Pair<View, String> = Pair.create(itemView.text_price_item, "transitionPrice")
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)
                    itemView.context.startActivity(intent, options.toBundle())

                }
            }
        }
    }

}