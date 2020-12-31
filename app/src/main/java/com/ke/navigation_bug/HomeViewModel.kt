package com.ke.navigation_bug

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val text = "header"

    override fun onCleared() {
        super.onCleared()
        "HomeViewModel onCleared".log()
    }
}