package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import io.github.ziginsider.epam_laba_9.adapter.ListViewAdapter
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.model.MockCharacter
import io.github.ziginsider.epam_laba_9.utils.toast
import kotlinx.android.synthetic.main.fragment_list.*
import android.support.design.widget.FloatingActionButton
import android.widget.AbsListView

class ListViewFragment : BaseFragment() {
    override val logTag = ListViewFragment::class.java.simpleName

    private val scrollListener: OnScrollListener by lazy { OnScrollListener(fab_list) }
    private var listViewAdapter: ListViewAdapter? = null
    private lateinit var characters: List<Character>

    override fun getLayout(): Int {
        return R.layout.fragment_list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characters = MockCharacter(resources).generateEmperorCharacters()
        setUpListView(characters)
        fab_list.setOnClickListener {
            activity.toast("I'm FAB from ListView !")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listViewAdapter = null
    }

    private fun setUpListView(items: List<Character>) {
        listViewAdapter = ListViewAdapter(
                context,
                items,
                { activity.toast("I'm  $name !!") })
        with(listView) {
            adapter = listViewAdapter
            setOnScrollListener(scrollListener)
        }
    }

    class OnScrollListener(val fab: FloatingActionButton) : AbsListView.OnScrollListener {
        private var lastPosition = 1

        override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {}

        override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int,
                              totalItemCount: Int) {
            if (lastPosition < firstVisibleItem) {
                fab.hide()
            }
            if (lastPosition > firstVisibleItem) {
                fab.show()
            }
            lastPosition = firstVisibleItem
        }
    }

}