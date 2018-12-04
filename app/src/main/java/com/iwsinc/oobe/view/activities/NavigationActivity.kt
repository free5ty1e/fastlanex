package com.example.fastlanex.view.activities

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.fastlanex.R
import com.example.fastlanex.view.fragments.PlaceholderFragment
import com.example.fastlanex.view.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private var userId: String? = null

    val mOnNavigationItemSelectedListener = createOnNavigationItemSelectedListener()

    private fun createOnNavigationItemSelectedListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                //TODO: Only change if not already showing this view
                //TODO: ...but reload if have navigated into subviews, so the tab button always brings user back to the "home" view of the selected tab
                R.id.navigation_home -> {
                    showFragment(PlaceholderFragment.newInstance(getString(R.string.title_home)), R.string.title_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    showFragment(PlaceholderFragment.newInstance(getString(R.string.title_dashboard)), R.string.title_dashboard)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    showFragment(PlaceholderFragment.newInstance(getString(R.string.title_notifications)), R.string.title_notifications)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_settings -> {
                    showFragment(SettingsFragment.newInstance(userId!!), R.string.title_settings)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun showFragment(
        fragment: Fragment?,
        @StringRes fragmentTagStringResId: Int = 0,
        @Suppress("SpellCheckingInspection") addToBackstack: Boolean = true,
        @IdRes fragmentFrameResId: Int = R.id.content
    ) {
        val fragmentManager = supportFragmentManager
        if (fragment == null) {
            for (existingFragment in supportFragmentManager.fragments) {
/*                if (existingFragment is NavigationDrawerFragment) {
                    continue
                } else */ if (existingFragment != null) {
                    fragmentManager.beginTransaction().remove(existingFragment).commit()
                }
            }
        } else {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(fragmentFrameResId, fragment)
            val fragmentTag = if (fragmentTagStringResId == 0) fragment.javaClass.simpleName else getString(fragmentTagStringResId)
            if (addToBackstack) {
                fragmentTransaction.addToBackStack(fragmentTag)
            }
            fragmentTransaction.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home

    }
}
