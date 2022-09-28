package edu.ucne.parcial1_pablo.Repositorio

import edu.ucne.parcial1_pablo.data.AppDataBase
import edu.ucne.parcial1_pablo.data.entity.Articulo
import javax.inject.Inject

class ArticulosRepositorio @Inject constructor(
    val dataBase: AppDataBase
){

    suspend fun insert(articulo: Articulo){

    }



}