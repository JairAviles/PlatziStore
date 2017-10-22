package com.platzi.platzistore

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
                itemView.text_dec_item.text = desc
                itemView.text_price_item.text = "$ ${String.format("%.2f", price)}"
            }
        }
    }

}