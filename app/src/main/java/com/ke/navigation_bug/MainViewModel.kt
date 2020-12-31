package com.ke.navigation_bug

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _mainFragmentLifecycleMethodList = MutableLiveData<List<String>>()

    val mainFragmentLifecycleMethodList: LiveData<List<String>>
        get() = _mainFragmentLifecycleMethodList

    fun add(methodName: String) {
        _mainFragmentLifecycleMethodList.value =
            (_mainFragmentLifecycleMethodList.value ?: emptyList()) + methodName
    }
}