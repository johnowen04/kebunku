package com.john.kebunku.model.kebun

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KebunDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(kebun: Kebun)

    @Query("SELECT * FROM kebun WHERE uuid= :uuid")
    suspend fun selectKebun(uuid: Int): Kebun

    @Query("UPDATE kebun SET water_level= :waterLevel WHERE uuid= :uuid")
    suspend fun updateWaterLevel(waterLevel: Float, uuid: Int)

    @Query("UPDATE kebun SET fertilizer_level= :fertilizerLevel WHERE uuid= :uuid")
    suspend fun updateFertilizerLevel(fertilizerLevel: Float, uuid: Int)

    @Query("UPDATE kebun SET humidity_level= :humidityLevel WHERE uuid= :uuid")
    suspend fun updateHumidityLevel(humidityLevel: Float, uuid: Int)

    @Query("UPDATE kebun SET light_intensity= :lightIntensity WHERE uuid= :uuid")
    suspend fun updateLightIntensity(lightIntensity: Float, uuid: Int)
}