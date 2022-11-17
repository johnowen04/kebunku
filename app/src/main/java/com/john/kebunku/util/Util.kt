package com.john.kebunku.util

import android.content.Context
import androidx.room.Room
import com.john.kebunku.model.KebunkuDatabase

val DB_NAME = "newkebunkudb"

fun buildDB(context: Context): KebunkuDatabase =
    Room.databaseBuilder(context.applicationContext,
        KebunkuDatabase::class.java,
        DB_NAME
    ).build()