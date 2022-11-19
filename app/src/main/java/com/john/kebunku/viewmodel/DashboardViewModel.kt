package com.john.kebunku.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.john.kebunku.model.kebun.Kebun
import com.john.kebunku.model.user.User
import com.john.kebunku.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DashboardViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val userLiveData = MutableLiveData<User>()
    val kebunLiveData = MutableLiveData<Kebun>()

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun fetch(username: String, kebunUUID: Int) {
        launch {
            val db = buildDB(getApplication())

            userLiveData.value = db.userDao().selectUser(username)
            kebunLiveData.value = db.kebunDao().selectKebun(kebunUUID)
        }
    }

    fun waterPlant() {
        // Send signal to server to turn on water
    }

    fun turnLight() {
        kebunLiveData.value?.let {
            if (it.lightIsOn == 1) {
                // Send signal to server to turn off light
                it.lightIsOn = 0
            } else {
                // Send signal to server to turn on light
                it.lightIsOn = 1
            }
        }

        launch {
            val db = buildDB(getApplication())
            kebunLiveData.value?.let {
                db.kebunDao().updateLightIsOn(it.lightIsOn, it.uuid)
            }
        }
    }
}