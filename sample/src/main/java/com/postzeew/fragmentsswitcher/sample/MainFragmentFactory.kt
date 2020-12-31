package com.postzeew.fragmentsswitcher.sample

import androidx.fragment.app.Fragment
import com.postzeew.fragmentsswitcher.FragmentsFactory

class MainFragmentFactory : FragmentsFactory {

    override fun create(fragmentTag: String): Fragment {
        return when (fragmentTag) {
            HomeFragment::class.java.name -> HomeFragment()
            MapFragment::class.java.name -> MapFragment()
            SettingsFragment::class.java.name -> SettingsFragment()
            else -> error("Can't create fragment with tag $fragmentTag")
        }
    }
}