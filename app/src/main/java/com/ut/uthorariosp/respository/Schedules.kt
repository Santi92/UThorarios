package com.ut.uthorariosp.respository

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "schedules")
data class Schedules(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                     @ColumnInfo(name = "cat") var cat: String? = "",
                     @ColumnInfo(name = "programa") var programa: String? = "",
                     @ColumnInfo(name = "nivel") var nivel: String? = "",
                     @ColumnInfo(name = "grupo") var grupo: String? = "",
                     @ColumnInfo(name = "codigo_del_curso") var codigoDelCurso: String? = "",
                     @ColumnInfo(name = "nombre_del curso") var nombre_del_curso: String? = "",
                     @ColumnInfo(name = "profesor") var profesor: String? = "",
                     @ColumnInfo(name = "aula") var aula: String? = "",
                     @ColumnInfo(name = "semana") var semana: String? = "",
                     @ColumnInfo(name = "dia") var dia: String? = "",
                     @ColumnInfo(name = "hora") var hora: String? = "",
                     @ColumnInfo(name = "ap") var ap: String? = "",
                     @ColumnInfo(name = "t1") var t1: String? = "",
                     @ColumnInfo(name = "t2") var t2: String? = "",
                     @ColumnInfo(name = "t3") var t3: String? = "",
                     @ColumnInfo(name = "t4") var t4: String? = "",
                     @ColumnInfo(name = "t5") var t5: String? = "",
                     @ColumnInfo(name = "foro") var foro: String? = "",
                     @ColumnInfo(name = "c1") var c1: String? = "",
                     @ColumnInfo(name = "c2") var c2: String? = "",
                     @ColumnInfo(name = "favorito") var favorito: Boolean? = false)


