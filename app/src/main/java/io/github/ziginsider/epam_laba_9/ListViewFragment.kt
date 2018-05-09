package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import io.github.ziginsider.epam_laba_9.adapter.ListViewAdapter
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.model.MockCharacter
import io.github.ziginsider.epam_laba_9.utils.toast
import kotlinx.android.synthetic.main.fragment_list.*
import android.support.design.widget.FloatingActionButton
import android.widget.AbsListView

/**
 * Implements Fragment that contains a ListView which shows list of [Character]
 *
 * Contains an implementation for [AbsListView.OnScrollListener] to show/hide
 * Floating Action Button
 *
 * @author Alex Kisel
 * @since 2018-04-15
 */
class ListViewFragment : BaseFragment() {

    override val logTag = ListViewFragment::class.java.simpleName

    private lateinit var listViewAdapter: ListViewAdapter
    private lateinit var characters: List<Character>

    override val layout = R.layout.fragment_list

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characters = MockCharacter(resources).generateEmperorCharacters()
        setUpListView(characters)
        fabList.setOnClickListener {
            activity.toast("I'm FAB from ListView !")
        }
    }

    private fun setUpListView(items: List<Character>) {
        listViewAdapter = ListViewAdapter(
                context,
                items,
                { activity.toast("I'm  $name !!") })
        with(listView) {
            adapter = listViewAdapter
            setOnScrollListener(OnScrollListener(fabList))
        }
    }

    /**
     * Implements [AbsListView.OnScrollListener] with show/hide Floating Action Button
     */
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