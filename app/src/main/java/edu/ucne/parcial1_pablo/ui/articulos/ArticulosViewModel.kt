package edu.ucne.parcial1_pablo.ui.articulos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_pablo.Repositorio.ArticulosRepositorio
import edu.ucne.parcial1_pablo.data.entity.Articulo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticulosViewModel @Inject constructor(
    val repositorio: ArticulosRepositorio
) : ViewModel() {

    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var existencia by mutableStateOf("")



    fun Save()
    {
        viewModelScope.launch {
            repositorio.insert(
                Articulo(
                    descripcion = descripcion,
                    marca = marca,
                    existencia = existencia.toDouble()

                )
            )
        }
    }





}