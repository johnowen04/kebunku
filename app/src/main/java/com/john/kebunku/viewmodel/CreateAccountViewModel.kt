package com.john.kebunku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.john.kebunku.model.user.User
import com.john.kebunku.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CreateAccountViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun register(username: String, name: String, password: String) {
        launch {
            val db = buildDB(getApplication())

            db.userDao().insert(User(username, name, password))
        }
    }
}