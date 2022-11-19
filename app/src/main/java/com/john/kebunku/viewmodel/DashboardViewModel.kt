package com.john.kebunku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.john.kebunku.model.kebun.Kebun
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class DashboardViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val kebunLiveData = MutableLiveData<Kebun>()

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}