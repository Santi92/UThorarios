package com.ut.uthorariosp.respository

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface SchedulesDao {

    @Query("SELECT * FROM schedules")
    fun getListSchedules(): LiveData<List<Schedules>>

    @Query("SELECT * FROM schedules LIMIT 1")
    fun getSchedules(): LiveData<List<Schedules>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Schedules>)

    @Query("SELECT * FROM schedules  WHERE programa != ''  GROUP BY programa")
    fun getNameProgramas():List<Schedules>

    @Query("SELECT * FROM schedules  WHERE programa LIKE '%' || :namePrograma || '%' AND cat != ''  GROUP BY cat ")
    fun getCatByNamePrograma(namePrograma:String):List<Schedules>

    @Query(  "SELECT * FROM schedules  WHERE programa LIKE '%' || :namePrograma || '%'  AND cat LIKE '%' || :nameCat || '%' AND nivel != ''  GROUP BY nivel")
    fun getNivel(namePrograma: String, nameCat:String)


    @Query(  "SELECT * FROM schedules  WHERE programa LIKE '%' || :namePrograma || '%'  AND cat LIKE '%' || :nameCat || '%'  AND nivel LIKE '%' || :numberNivel || '%' AND grupo != ''  GROUP BY grupo")
    fun getGrupo(namePrograma: String, nameCat:String,numberNivel: String)

}