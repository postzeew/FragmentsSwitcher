package com.postzeew.fragmentsswitcher

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentSwitcher(
    private val fragmentsFactory: FragmentsFactory,
    @IdRes private val fragmentsContainer: Int
) {

    fun switchTo(targetFragmentTag: String, fragmentManager: FragmentManager) {
        val activeFragment = fragmentManager.findActiveFragment()
        if (activeFragment?.tag == targetFragmentTag) return

        val targetFragment = fragmentManager.findTargetFragment(targetFragmentTag)
        val transaction = fragmentManager.beginTransaction()

        activeFragment?.let(transaction::hide)

        if (targetFragment != null) {
            transaction.show(targetFragment)
        } else {
            transaction.addAndShow(fragmentsFactory.create(targetFragmentTag), targetFragmentTag)
        }

        transaction.commit()
    }

    private fun FragmentManager.findActiveFragment(): Fragment? {
        return fragments.find(Fragment::isVisible)
    }

    private fun FragmentManager.findTargetFragment(targetFragmentTag: String): Fragment? {
        return fragments.find { it.tag == targetFragmentTag }
    }

    private fun FragmentTransaction.addAndShow(targetFragment: Fragment, targetFragmentTag: String) {
        add(fragmentsContainer, targetFragment, targetFragmentTag)
        show(targetFragment)
    }
}