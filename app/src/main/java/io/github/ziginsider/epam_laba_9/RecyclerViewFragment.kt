package io.github.ziginsider.epam_laba_9

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import io.github.ziginsider.epam_laba_9.adapter.RecyclerViewAdapter
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.model.MockCharacter
import kotlinx.android.synthetic.main.fragment_recycler.*

/**
 * Implements Fragment that contains a RecyclerView which shows list of [Character]
 *
 * Declares interface [ItemClickEventListener] for getting
 * touch to Activity
 *
 * Contains an implementation for [RecyclerView.OnScrollListener] to show/hide
 * Floating Action Button
 *
 * @author Alex Kisel
 * @since 2018-04-15
 */
class RecyclerViewFragment : BaseFragment() {
    override val logTag = RecyclerViewFragment::class.java.simpleName

    interface ItemClickEventListener {
        fun onFragmentItemClick(item: Character)
    }

    private val scrollListener: OnScrollListener by lazy { OnScrollListener(fab) }
    private var listener: ItemClickEventListener? = null
    private var recyclerAdapter: RecyclerViewAdapter? = null
    private lateinit var characters: List<Character>

    override val layout = R.layout.fragment_recycler

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
        characters = MockCharacter(resources).generateEmperorCharacters()
        setUpRecyclerView(characters)
        fab.setOnClickListener {
            characters = characters.shuffled()
            updateAdapter(characters)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        recyclerAdapter = null
    }

    private fun setUpRecyclerView(items: List<Character>) {
        recyclerAdapter = RecyclerViewAdapter(items,
                R.layout.item_view,
                { listener?.onFragmentItemClick(this) })
        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = recyclerAdapter
            addOnScrollListener(scrollListener)
        }
    }

    private fun updateAdapter(list: List<Character>) {
        recyclerAdapter?.update(list) ?: setUpRecyclerView(list)
    }

    /**
     * Implements [RecyclerView.OnScrollListener] with show/hide Floating Action Button
     */
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
