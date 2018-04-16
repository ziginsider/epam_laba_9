package io.github.ziginsider.epam_laba_9

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.view.View

class ScrollFABBehaviour : FloatingActionButton.Behavior() {
    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int,
                                dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, type)
        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
            child.hide()
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            child.show()
        }
    }
}