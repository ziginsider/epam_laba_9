package io.github.ziginsider.epam_laba_9

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.ziginsider.epam_laba_9.adapter.ItemsAdapter
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.model.MockCharacter
import kotlinx.android.synthetic.main.fragment_recycler.*

/**
 * Implements First Fragment
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
class RecyclerViewFragment : BaseFragment() {
    override val logTag = RecyclerViewFragment::class.java.simpleName

    val scrollListener: OnScrollListener by lazy { OnScrollListener(fab) }

    interface ItemClickEventListener {
        fun onFragmentItemClick(item: Character)
    }

    private var listener: ItemClickEventListener? = null
    private var recyclerAdapter: ItemsAdapter? = null

    override fun getLayout(): Int {
        return R.layout.fragment_recycler
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ItemClickEventListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString()
                    + " must implement ItemClickEventListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val characters = MockCharacter(resources).generateStarWarsCharacters()
        setUpRecyclerView(characters)
    }

    private fun setUpRecyclerView(items: List<Character>) {
        recyclerAdapter = ItemsAdapter(items,
                R.layout.item_view,
                { listener?.onFragmentItemClick(this) })
        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = recyclerAdapter
            addOnScrollListener(scrollListener)
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        recyclerAdapter = null
    }

    class OnScrollListener(val fab: FloatingActionButton) : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0 && fab.visibility == View.VISIBLE) {
                fab.hide()
            } else if (dy < 0 && fab.visibility != View.VISIBLE) {
                fab.show()
            }
        }
    }




}