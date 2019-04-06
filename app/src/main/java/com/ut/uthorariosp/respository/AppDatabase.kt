package com.ut.uthorariosp.respository

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Schedules::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun schedulesDao(): SchedulesDao
}