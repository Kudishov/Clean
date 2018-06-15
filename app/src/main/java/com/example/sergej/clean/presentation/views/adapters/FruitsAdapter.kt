package com.example.sergej.clean.presentation.views.adapters

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.sergej.clean.R
import com.example.sergej.clean.domain.Fruit

class FruitsAdapter(private val fruitsList: List<Fruit>, listener: OnFruitClickListener) : RecyclerView.Adapter<FruitsAdapter.ViewHolder>() {

    private var onClickListener = listener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_fruit, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val fruit = fruitsList[position]
        viewHolder.bind(fruit, onClickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id: TextView = itemView.findViewById(R.id.tvItemFruitId)
        val name: TextView = itemView.findViewById(R.id.tvItemFruitName)
        val color: TextView = itemView.findViewById(R.id.tvItemFruitColor)
        val weight: TextView = itemView.findViewById(R.id.tvItemFruitWeight)
        val delicious: TextView = itemView.findViewById(R.id.tvItemFruitDelicious)
        val createdAt: TextView = itemView.findViewById(R.id.tvItemFruitCreatedAt)
        val updatedAt: TextView = itemView.findViewById(R.id.tvItemFruitUpdatedAt)
        val fruitFrame: LinearLayout = itemView.findViewById(R.id.llFruitFrame)

        fun bind(fruit: Fruit, listener: OnFruitClickListener) {
            id.text = fruit.id.toString()
            name.text = fruit.name
            color.text = fruit.color
            weight.text = fruit.weight
            delicious.text = fruit.delicious
            createdAt.text = fruit.created_at
            updatedAt.text = fruit.updated_at
            fruitFrame.setOnClickListener { listener.onFruitClick(fruit) }
        }
    }

    interface OnFruitClickListener {
        fun onFruitClick(fruit: Fruit)
    }
}