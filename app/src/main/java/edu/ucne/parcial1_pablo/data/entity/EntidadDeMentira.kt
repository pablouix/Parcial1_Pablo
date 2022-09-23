package edu.ucne.parcial1_pablo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Entidades")
data class EntidadDeMentira (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val string1 : String = "",
    val string2 : String = "",
    val double1 : Double = 0.0
)