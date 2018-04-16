package io.github.ziginsider.epam_laba_9.adapter

import android.support.v7.util.DiffUtil
import io.github.ziginsider.epam_laba_9.model.Character

class DiffUtilCallback(private val oldItems: List<Character>,
                       private val newItems: List<Character>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition].id == newItems[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldItems[oldItemPosition] == newItems[newItemPosition]
}