package com.mexiti.cronoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mexiti.cronoapp.model.Cronos
import kotlinx.coroutines.flow.Flow

@Dao
interface CronosDataBaseDao {
//CRUD
    @Query("SELECT * FROM cronos") // selecciono todos los elementos
    fun getCronos(): Flow<List<Cronos>>
    @Query("SELECT * FROM cronos WHERE id=:id")
    fun getCronosById(id:Long):Flow<Cronos>
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crono:Cronos)
    @Update (onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(crono:Cronos)
    @Delete
    suspend fun delete(crono:Cronos)
}