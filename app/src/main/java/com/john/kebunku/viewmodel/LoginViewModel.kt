package com.john.kebunku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.john.kebunku.model.user.User
import com.john.kebunku.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val userLiveData = MutableLiveData<User>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun login(username: String, password: String) {
        launch {
            val db = buildDB(getApplication())

            userLiveData.value = db.userDao().selectUser(username, password)
        }
    }
}