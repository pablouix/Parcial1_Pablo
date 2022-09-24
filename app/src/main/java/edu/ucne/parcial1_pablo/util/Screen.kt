package edu.ucne.parcial1_pablo.util

sealed class Screen(val route: String)
{
    object EntidadMentiraScreenList: Screen("EntidadList")
    object EntidadMentiraScreen: Screen("Entidad")
}