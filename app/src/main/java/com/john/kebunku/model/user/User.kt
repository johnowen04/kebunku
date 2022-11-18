package com.john.kebunku.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "password")
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}
