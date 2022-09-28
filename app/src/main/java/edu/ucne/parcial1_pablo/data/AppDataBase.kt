package edu.ucne.parcial1_pablo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_pablo.data.entity.Articulo

@Database(
    entities = [Articulo::class],
    version = 2
)

abstract class AppDataBase : RoomDatabase(){

}