package io.github.ziginsider.epam_laba_9

class ListViewFragment: BaseFragment() {
    override val logTag = ListViewFragment::class.java.simpleName


    override fun getLayout(): Int {
        return R.layout.fragment_list
    }

}