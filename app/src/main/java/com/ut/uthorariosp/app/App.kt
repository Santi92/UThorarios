package com.ut.uthorariosp.app

import android.app.Application
import android.arch.persistence.room.Room
import com.ut.uthorariosp.respository.AppDatabase
import com.ut.uthorariosp.respository.SchedulesRepository

class App : Application() {

    //For the sake of simplicity, for now we use this instead of Dagger
    companion object {

        private lateinit var schedulesRepository: SchedulesRepository
        //private lateinit var userListViewModel: UserListViewModel
        private lateinit var appDatabase: AppDatabase

        //fun injectUserListViewModel() = userListViewModel

        fun injectSchedulesDap() = appDatabase.schedulesDao()
        fun injectSchedulesRepository() = schedulesRepository

    }

    override fun onCreate() {
        super.onCreate()


        appDatabase = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "mvvm-database").build()

        schedulesRepository = SchedulesRepository(appDatabase.schedulesDao())
        //userListViewModel = UserListViewModel(userRepository)
    }
}
