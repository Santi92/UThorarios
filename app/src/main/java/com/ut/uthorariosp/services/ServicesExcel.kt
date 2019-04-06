package com.ut.uthorariosp.services

import android.content.res.AssetManager

import android.util.Log
import com.ut.uthorariosp.respository.Schedules
import com.ut.uthorariosp.respository.SchedulesRepository
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.IOException
import java.io.InputStream


class ServicesExcel(val repository: SchedulesRepository) {

    fun executeReadXls(assetManager: AssetManager):Int{

        val listSchedules : MutableList<Schedules> = arrayListOf()

        try {

            val myInput: InputStream = assetManager.open("horarios.xls")

            // Create a POI File System object
            val myFileSystem = POIFSFileSystem(myInput)
            // Create a workbook using the File System
            val myWorkBook = HSSFWorkbook(myFileSystem)
            val mySheet = myWorkBook.getSheetAt(0)
            val rowIter = mySheet.rowIterator()
            var rowno = 0

            while (rowIter.hasNext()) {

                val myRow = rowIter.next() as HSSFRow
                if (rowno != 0) {

                    val schedules = Schedules()

                    val cellIterator = myRow.cellIterator()
                    var colNumber = 0

                    while (cellIterator.hasNext()) {
                        val myCell = cellIterator.next() as HSSFCell
                        when (colNumber) {
                            0 -> schedules.cat = myCell.toString()
                            1 -> schedules.programa = myCell.toString()
                            2 -> schedules.nivel = myCell.toString()
                            3 -> schedules.grupo = myCell.toString()
                            4 -> schedules.codigoDelCurso = myCell.toString()
                            5 -> schedules.nombre_del_curso = myCell.toString()
                            6 -> schedules.profesor = myCell.toString()
                            7 -> schedules.aula = myCell.toString()
                            8 -> schedules.semana = myCell.toString()
                            9 -> schedules.dia = myCell.toString()
                            10 -> schedules.hora = myCell.toString()
                            11 -> schedules.ap = myCell.toString()
                            12 -> schedules.t1 = myCell.toString()
                            13 -> schedules.t2 = myCell.toString()
                            14 -> schedules.t3 = myCell.toString()
                            15 -> schedules.t4 = myCell.toString()
                            16 -> schedules.t5 = myCell.toString()
                            17 -> schedules.foro = myCell.toString()
                            18 -> schedules.c1 = myCell.toString()
                            19 -> schedules.c2 = myCell.toString()

                        }

                        colNumber++
                        Log.d("NAME",schedules.toString())

                    }

                    listSchedules.add(schedules)
                }
                rowno++
            }

        } catch (e: IOException) {
            Log.d("ERROR",e.localizedMessage)
            e.printStackTrace()
        }

        Log.d("size",""+listSchedules.size)
        repository.storeSchedulesInDb(listSchedules)


        return 0

    }



}
