package io.github.ziginsider.epam_laba_9

class FirstFragment: BaseFragment() {
    override val logTag = FirstFragment::class.java.simpleName

    override fun getLayout(): Int {
        return R.layout.fragment_first
    }
}