package com.john.kebunku.model.kebun

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kebun(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "water_level")
    var waterLevel: Float,
    @ColumnInfo(name = "fertilizer_level")
    var fertilizerLevel: Float,
    @ColumnInfo(name = "humidity_level")
    var humidityLevel: Float,
    @ColumnInfo(name = "light_intensity")
    var lightIntensity: Float
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}
