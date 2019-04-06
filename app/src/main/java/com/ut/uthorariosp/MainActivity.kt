package com.ut.uthorariosp


import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ut.uthorariosp.app.App

import com.ut.uthorariosp.services.ServicesExcel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    internal var TAG = "main"

    private val schedulesRepository = App.injectSchedulesRepository()
    private lateinit var servicesExcel : ServicesExcel

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        servicesExcel = ServicesExcel(repository = schedulesRepository)


        schedulesRepository.getSchedules().observe(this, Observer {

            it?.run {
                if (isEmpty()){
                    readXls()
                }else{
                    Toast.makeText(baseContext,"Save ready data",Toast.LENGTH_SHORT).show()
                }
            }

        })


    }


    private fun readXls() {
        progressCircular.visibility = View.VISIBLE

        GlobalScope.launch(Dispatchers.Main) {

            val result = withContext(Dispatchers.IO) { servicesExcel.executeReadXls(assets) }

            if(result == 0){
                progressCircular.visibility = View.GONE
            }
        }

    }
}
