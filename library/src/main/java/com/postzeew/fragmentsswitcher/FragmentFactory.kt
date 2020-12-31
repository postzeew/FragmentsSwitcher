package com.postzeew.fragmentsswitcher

import androidx.fragment.app.Fragment

interface FragmentsFactory {
    fun create(fragmentTag: String): Fragment
}