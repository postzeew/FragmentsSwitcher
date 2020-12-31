package com.postzeew.fragmentsswitcher.sample

import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    companion object {
        fun newInstance() = HomeFragment()
    }
}