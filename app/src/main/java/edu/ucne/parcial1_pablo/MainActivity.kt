package edu.ucne.parcial1_pablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_pablo.ui.articulos.ArticulosScreen
import edu.ucne.parcial1_pablo.ui.articulos_list.ArticulosScreenList
import edu.ucne.parcial1_pablo.ui.theme.Parcial1_PabloTheme
import edu.ucne.parcial1_pablo.util.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_PabloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.ArticulosScreenList.route
                    ){
                        composable(Screen.ArticulosScreenList.route){
                            ArticulosScreenList(onClick = { navController.navigate(Screen.ArticulosScreen.route) })
                        }

                        composable(Screen.ArticulosScreen.route){
                            ArticulosScreen({navController.navigateUp()})
                        }

                    }

                }
            }
        }
    }
}

