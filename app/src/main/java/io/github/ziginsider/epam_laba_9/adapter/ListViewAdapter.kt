package io.github.ziginsider.epam_laba_9.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import io.github.ziginsider.epam_laba_9.R
import io.github.ziginsider.epam_laba_9.model.Character

class ListViewAdapter(context: Context,
                      private val items: List<Character>,
                      private var itemClick: Character.() -> Unit = {})
    : BaseAdapter() {

    private val inflator: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val viewHolder: ListViewHolder
        if (convertView == null) {
            view = inflator.inflate(R.layout.item_view, parent, false)
            viewHolder = ListViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ListViewHolder
        }

        val item = items[position]
        with(viewHolder) {
            name.text = item.name
            date.text = item.date
            when (item.id) {
                0 -> image.setImageResource(R.drawable.caesar)
                1 -> this.image.setImageResource(R.drawable.augustus)
                2 -> this.image.setImageResource(R.drawable.tiberius)
                3 -> this.image.setImageResource(R.drawable.caligula)
                4 -> this.image.setImageResource(R.drawable.claudius)
                5 -> this.image.setImageResource(R.drawable.nero)
                6 -> this.image.setImageResource(R.drawable.galba)
                7 -> this.image.setImageResource(R.drawable.otho)
                8 -> this.image.setImageResource(R.drawable.vithelius)
                9 -> this.image.setImageResource(R.drawable.vespasian)
                10 -> this.image.setImageResource(R.drawable.titus)
                11 -> this.image.setImageResource(R.drawable.domitian)
            }
        }

        view?.setOnClickListener {
            onItemClick(position)
        }

        return view
    }

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = items[position].id.toLong()

    override fun getCount() = items.size

    private class ListViewHolder(view: View?) {
        val name: TextView = view?.findViewById(R.id.emperorName) as TextView
        val date: TextView = view?.findViewById(R.id.emperorDate) as TextView
        val image: ImageView = view?.findViewById(R.id.emperorImage) as ImageView
    }

    private fun onItemClick(position: Int) {
        items[position].itemClick()
    }
}
