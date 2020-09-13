package com.nassdk.musand.global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract val resourceLayout: Int

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = layoutInflater.inflate(resourceLayout, container, false)

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