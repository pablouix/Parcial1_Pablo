package edu.ucne.parcial1_pablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.parcial1_pablo.ui.entidaddementira.EntidadMentiraScreen
import edu.ucne.parcial1_pablo.ui.entidaddementira_list.EntidadMentiraScreenList
import edu.ucne.parcial1_pablo.ui.theme.Parcial1_PabloTheme
import edu.ucne.parcial1_pablo.util.Screen

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
                        startDestination = Screen.EntidadMentiraScreenList.route
                    ){
                        composable(Screen.EntidadMentiraScreenList.route){
                            EntidadMentiraScreenList(onClick = { navController.navigate(Screen.EntidadMentiraScreen.route) })
                        }

                        composable(Screen.EntidadMentiraScreen.route){
                            EntidadMentiraScreen({navController.navigateUp()})
                        }

                    }

                }
            }
        }
    }
}

