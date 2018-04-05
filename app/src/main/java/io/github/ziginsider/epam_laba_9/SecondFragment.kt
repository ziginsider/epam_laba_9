package io.github.ziginsider.epam_laba_9

class SecondFragment: BaseFragment() {
    override val logTag = SecondFragment::class.java.simpleName

    override fun getLayout(): Int {
        return R.layout.fragment_second
    }
}