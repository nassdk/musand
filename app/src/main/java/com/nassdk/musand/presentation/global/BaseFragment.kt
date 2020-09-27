package com.nassdk.musand.presentation.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract val resourceLayout: Int

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = layoutInflater.inflate(resourceLayout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareUi()
    }

    open fun prepareUi() {}

//    protected fun setupToolbar(
//        title: String,
//        showNavIcon: Boolean = false,
//        @DrawableRes iconDrawable: Int = R.drawable.ic_action_navigation_arrow_back_inverted
//    )
//    {
//        val toolbar: Toolbar? = view?.findViewById(R.id.toolBar)
//        toolbar?.run {
//            if (showNavIcon) {
//                setNavigationIcon(iconDrawable)
//                setNavigationOnClickListener { onBackPressed() }
//            }
//            this.title = title
//        }
//    }

    abstract fun onBackPressed()
}