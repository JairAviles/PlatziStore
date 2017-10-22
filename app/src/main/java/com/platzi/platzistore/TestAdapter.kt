package com.platzi.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class TestAdapter(val data: List<ItemListPojo>) : RecyclerView.Adapter<TestAdapter.Holder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
        Holder(ItemList().createView(AnkoContext.create(parent!!.context, this, false)))

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindView(data[position])
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val txtViewTitle by lazy {
            itemView.find<TextView>(R.id.txt_title_item)
        }

        val txtViewDesc by lazy {
            itemView.find<TextView>(R.id.txt_title_desc)
        }

        val txtViewPrice by lazy {
            itemView.find<TextView>(R.id.txt_title_price)
        }

        fun bindView(item: ItemListPojo) {

            with(item) {
                txtViewTitle.text = title
                txtViewDesc.text = desc
                txtViewPrice.text = price
            }
        }
    }

}
