package com.ut.uthorariosp.respository

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SchedulesRepository(private val schedulesDao: SchedulesDao){


    @SuppressLint("CheckResult")
    fun storeSchedulesInDb(schedules: List<Schedules>) {
        Observable.fromCallable { schedulesDao.insertAll(schedules) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    Timber.d("Inserted ${schedules.size} users from API in DB...")
                }
    }


    fun getListSchedules(): LiveData<List<Schedules>> {
        return schedulesDao.getSchedules()
    }

    fun getSchedules(): LiveData<List<Schedules>> {
        return schedulesDao.getSchedules()
    }

}