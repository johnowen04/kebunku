package com.john.kebunku.model.kebun

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kebun(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "water_level")
    var waterLevel: Float = 0.0f,
    @ColumnInfo(name = "fertilizer_level")
    var fertilizerLevel: Float = 0.0f,
    @ColumnInfo(name = "humidity_level")
    var humidityLevel: Float = 0.0f,
    @ColumnInfo(name = "light_intensity")
    var lightIntensity: Float = 0.0f,
    @ColumnInfo(name = "water_is_on")
    var waterIsOn: Int = 0,
    @ColumnInfo(name = "light_is_on")
    var lightIsOn: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}
