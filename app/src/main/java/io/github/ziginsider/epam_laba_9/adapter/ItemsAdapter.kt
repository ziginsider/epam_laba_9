package io.github.ziginsider.epam_laba_9.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.R
import io.github.ziginsider.epam_laba_9.utils.asDp
import io.github.ziginsider.epam_laba_9.utils.inflate
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Adapter for list of characters {@link model#Character}
 *
 * @author Alex Kisel
 * @since 2018-04-03
 */
class ItemsAdapter(val items: List<Character>,
                   val layoutResId: Int,
                   private var itemClick: Character.() -> Unit = {})
    : RecyclerView.Adapter<ItemsAdapter.Holder>() {
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent inflate layoutResId
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(adapterPosition)
            }
        }
        return viewHolder
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.itemView.bind(item)
    }

    private fun onItemClick(position: Int) {
        items[position].itemClick()
    }

    private fun View.bind(item: Character) {
        heroName.text = item.name
        when (item.id) {
            0 -> {
                heroImage.layoutParams.height = 30.asDp
                heroImage.setImageResource(R.drawable.yoda)
            }
            1 -> heroImage.setImageResource(R.drawable.luke_skywalker)
            2 -> heroImage.setImageResource(R.drawable.princess_leia)
            3 -> heroImage.setImageResource(R.drawable.han_solo)
            4 -> heroImage.setImageResource(R.drawable.chewbacca)
            5 -> heroImage.setImageResource(R.drawable.darth_vader)
            6 -> heroImage.setImageResource(R.drawable.r2_d2)
            7 -> heroImage.setImageResource(R.drawable.c_3po)
        }
    }
}