package io.github.ziginsider.epam_laba_9.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.R
import io.github.ziginsider.epam_laba_9.utils.inflate
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Adapter for list of characters {@link model#Character}
 *
 * @author Alex Kisel
 * @since 2018-04-03
 */
class RecyclerViewAdapter(val items: List<Character>,
                          val layoutResId: Int,
                          private var itemClick: Character.() -> Unit = {})
    : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
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
        emperorName.text = item.name
        emperorDate.text = item.date
        when (item.id) {
            0 -> emperorImage.setImageResource(R.drawable.caesar)
            1 -> emperorImage.setImageResource(R.drawable.augustus)
            2 -> emperorImage.setImageResource(R.drawable.tiberius)
            3 -> emperorImage.setImageResource(R.drawable.caligula)
            4 -> emperorImage.setImageResource(R.drawable.claudius)
            5 -> emperorImage.setImageResource(R.drawable.nero)
            6 -> emperorImage.setImageResource(R.drawable.galba)
            7 -> emperorImage.setImageResource(R.drawable.otho)
            8 -> emperorImage.setImageResource(R.drawable.vithelius)
            9 -> emperorImage.setImageResource(R.drawable.vespasian)
            10 -> emperorImage.setImageResource(R.drawable.titus)
            11 -> emperorImage.setImageResource(R.drawable.domitian)
        }
    }
}