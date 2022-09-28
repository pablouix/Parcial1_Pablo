package edu.ucne.parcial1_pablo.Repositorio

import edu.ucne.parcial1_pablo.data.AppDataBase
import edu.ucne.parcial1_pablo.data.entity.Articulo
import javax.inject.Inject

class ArticulosRepositorio @Inject constructor(
    val dataBase: AppDataBase
){

    suspend fun insert(articulo: Articulo){
        dataBase.articulosDao.insert(articulo)
    }

    suspend fun delete(articulo: Articulo){
        dataBase.articulosDao.delete(articulo)
    }

    fun getAll() = dataBase.articulosDao.getAll()

    fun getFind(id: Int ) = dataBase.articulosDao.getFind(id)
}