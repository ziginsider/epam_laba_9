package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * Implements Second Fragment
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
class SecondFragment : BaseFragment() {
    override val logTag = SecondFragment::class.java.simpleName

    override fun getLayout(): Int {
        return R.layout.fragment_second
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(image_view_second.context)
                .load(resources.getString(R.string.url_three))
                .into(image_view_second)
        text_view_second.text = resources.getString(R.string.url_three_decr)
    }
}