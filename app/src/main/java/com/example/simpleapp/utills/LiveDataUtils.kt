package com.example.simpleapp.utills

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.nonNull(): MediatorLiveData<T> {
    val mediator: MediatorLiveData<T> = MediatorLiveData()
    mediator.addSource(this) { it?.let { mediator.value = it } }
    return mediator
}

fun <T> Fragment.observeNonNullState(stateSource: LiveData<T>, onStateChanged: (T) -> Unit) {
    stateSource.nonNull()
        .observe(viewLifecycleOwner, { t -> onStateChanged(t) })
}
