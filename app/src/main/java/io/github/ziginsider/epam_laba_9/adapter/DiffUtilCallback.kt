package io.github.ziginsider.epam_laba_9.adapter

import android.support.v7.util.DiffUtil
import io.github.ziginsider.epam_laba_9.model.Character

/**
 * Implements class that can calculate the difference between two lists and output a list of
 * update operations that converts the first list into the second one. It can be used to calculate
 * updates for a [RecyclerViewAdapter].
 *
 * @author Alex Kisel
 * @since 2018-04-15
 */
class DiffUtilCallback(private val oldItems: List<Character>,
                       private val newItems: List<Character>) : DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition] == newItems[newItemPosition]
}