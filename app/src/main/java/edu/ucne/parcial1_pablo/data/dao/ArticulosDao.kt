package edu.ucne.parcial1_pablo.data.dao

import androidx.room.*
import edu.ucne.parcial1_pablo.data.entity.Articulo
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticulosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articulo: Articulo)

    @Delete
    suspend fun delete(articulo: Articulo)

    @Query("Select * from articulos")
    fun getAll() : Flow<List<Articulo>>

    @Query("Select * from articulos where articuloId == :id")
    fun getFind(id: Int) : Flow<Articulo>
}