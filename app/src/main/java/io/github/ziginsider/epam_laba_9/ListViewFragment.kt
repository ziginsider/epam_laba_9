package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import io.github.ziginsider.epam_laba_9.adapter.ListViewAdapter
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.model.MockCharacter
import kotlinx.android.synthetic.main.fragment_list.*

class ListViewFragment: BaseFragment() {
    override val logTag = ListViewFragment::class.java.simpleName

    private var listViewAdapter: ListViewAdapter? = null
    private lateinit var characters: List<Character>

    override fun getLayout(): Int {
        return R.layout.fragment_list
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characters = MockCharacter(resources).generateEmperorCharacters()
        setUpListView(characters)
    }

    override fun onDetach() {
        super.onDetach()
        listViewAdapter = null
    }

    private fun setUpListView(items: List<Character>) {
        listViewAdapter = ListViewAdapter(context, items)
        with(listView) {
            adapter = listViewAdapter
        }
    }


}