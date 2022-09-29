package edu.ucne.parcial1_pablo.util

sealed class Screen(val route: String)
{
    object ArticulosScreenList: Screen("ArticuloList")
    object ArticulosScreen: Screen("Articulos")
}