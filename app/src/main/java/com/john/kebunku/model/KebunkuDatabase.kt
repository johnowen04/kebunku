package com.john.kebunku.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.john.kebunku.model.kebun.Kebun
import com.john.kebunku.model.kebun.KebunDao
import com.john.kebunku.model.user.User
import com.john.kebunku.model.user.UserDao
import com.john.kebunku.util.buildDB

@Database(entities = arrayOf(User::class, Kebun::class), version = 1)
abstract class KebunkuDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun kebunDao(): KebunDao

    companion object {
        @Volatile private var instance: KebunkuDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            buildDB(context)

        operator fun invoke(context: Context) {
            if (instance != null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}