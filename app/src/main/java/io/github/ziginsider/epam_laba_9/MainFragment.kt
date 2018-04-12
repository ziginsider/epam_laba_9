package io.github.ziginsider.epam_laba_9

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Implements First Fragment
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
class MainFragment : BaseFragment() {
    override val logTag = MainFragment::class.java.simpleName

    private val ITEM_URI_KEY = "itemUriKey"
    private val ITEM_DECRIPTION_KEY = "itemDescriptionKey"

    val characterUri: String by lazy { arguments.getString(ITEM_URI_KEY) }
    val characterDescription: String by lazy { arguments.getString(ITEM_DECRIPTION_KEY) }

    override fun getLayout(): Int {
        return R.layout.fragment_main
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(main_image_view.context)
                .load(arguments.getString(ITEM_URI_KEY))
                .into(main_image_view)
        main_text_view.text = arguments.getString(ITEM_DECRIPTION_KEY)
    }

    companion object {
        fun newInstance(itemUri: String, itemDescription: String): MainFragment {
            return MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ITEM_URI_KEY, itemUri)
                    putString(ITEM_DECRIPTION_KEY, itemDescription)
                }
            }
        }
    }
}