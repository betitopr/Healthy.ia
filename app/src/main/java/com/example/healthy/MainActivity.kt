package com.example.healthy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthy.composables.*
import com.example.healthy.ui.theme.HealthyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavGraph(navController: androidx.navigation.NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioScreen(onContinueClick = {
                navController.navigate("objetivo")
            })
        }
        composable("objetivo") {
            ObjetivoScreen(onContinueClick = {
                navController.navigate("comoConseguirlo")
            })
        }
        composable("comoConseguirlo") {
            ComoConseguirloScreen(onContinueClick = {
                navController.navigate("edad")
            })
        }
        composable("edad") {
            EdadScreen(onContinueClick = {
                navController.navigate("genero")
            })
        }
        composable("genero") {
            GeneroScreen(onContinueClick = {
                navController.navigate("peso")
            })
        }
        composable("peso") {
            PesoScreen(onContinueClick = {
                navController.navigate("altura")
            })
        }
        composable("altura") {
            AlturaScreen(onContinueClick = {
                navController.navigate("nivelActividad")
            })
        }
        composable("nivelActividad") {
            NivelActividadScreen(onContinueClick = {
                navController.navigate("entrenamientoFuerza")
            })
        }
        composable("entrenamientoFuerza") {
            EntrenamientoFuerzaScreen(onContinueClick = {
                // Navegar a la siguiente pantalla que necesites
            })
        }
        // Aquí puedes añadir más pantallas si es necesario
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthyTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}
