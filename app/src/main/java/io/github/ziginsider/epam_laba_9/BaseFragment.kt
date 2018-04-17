package io.github.ziginsider.epam_laba_9

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_9.utils.logi

/**
 * **Abstract** Base Fragment that contains the base implementation for Fragment
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
abstract class BaseFragment : Fragment() {
    /**
     * TAG for [logi]
     */
    protected abstract val logTag: String

    /**
     * Gets resource id of layout for Fragment inflater
     *
     * @return Int resource id of layout for Fragment inflater
     */
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        logi(logTag, "[ ON CREATE ]")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        logi(logTag, "[ ON CREATE VIEW ]")
        return inflater?.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        logi(logTag, "[ ON VIEW CREATED ]")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        logi(logTag, "[ ON ATTACH ]")
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        logi(logTag, "[ ON ACTIVITY CREATED ]")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        logi(logTag, "[ ON START ]")
        super.onStart()
    }

    override fun onResume() {
        logi(logTag, "[ ON RESUME ]")
        super.onResume()
    }

    override fun onPause() {
        logi(logTag, "[ ON PAUSE ]")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        logi(logTag, "[ ON SAVE INSTANCE STATE ]")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        logi(logTag, "[ ON STOP ]")
        super.onStop()
    }

    override fun onDestroyView() {
        logi(logTag, "[ ON DESTROY VIEW ]")
        super.onDestroyView()
    }

    override fun onDestroy() {
        logi(logTag, "[ ON DESTROY ]")
        super.onDestroy()
    }

    override fun onDetach() {
        logi(logTag, "[ ON DETACH ]")
        super.onDetach()
    }
}