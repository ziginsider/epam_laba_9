package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * Implements First Fragment
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
class FirstFragment : BaseFragment() {
    override val logTag = FirstFragment::class.java.simpleName

    override fun getLayout(): Int {
        return R.layout.fragment_first
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(image_view_first.context)
                .load(resources.getString(R.string.url_two))
                .into(image_view_first)
        text_view_first.text = resources.getString(R.string.url_two_decr)
    }
}