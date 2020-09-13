package com.nassdk.musand

import android.content.Context
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.nassdk.musand.global.BaseActivity
import com.nassdk.musand.global.BaseFragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class AppActivity : BaseActivity() {

    override val resourceLayout = R.layout.activity_main

    private val router: Router by inject()
    private val navigatorHolder: NavigatorHolder by inject()

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, supportFragmentManager, R.id.container)
    }

    private val currentFragment
        get() = supportFragmentManager.findFragmentById(R.id.container) as BaseFragment?


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun handleLaunch() {
        router.newRootChain()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: router.exit()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v: View? = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}