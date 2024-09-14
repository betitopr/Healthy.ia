package com.example.healthy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthy.composables.*
import com.example.healthy.presentation.viewmodels.UserSelectionsViewModel
import com.example.healthy.ui.theme.HealthyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userSelectionsViewModel = UserSelectionsViewModel()
        setContent {
            HealthyTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        userSelectionsViewModel = userSelectionsViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable

fun AppNavGraph(
    navController: androidx.navigation.NavHostController,
    userSelectionsViewModel: UserSelectionsViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("objetivo")
                }
            )
        }
        composable("objetivo") {
            ObjetivoScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("comoConseguirlo")
                }
            )
        }
        composable("comoConseguirlo") {
            ComoConseguirloScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("edad")
                }
            )
        }
        composable("edad") {
            EdadScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("genero")
                }
            )
        }
        composable("genero") {
            GeneroScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("peso")
                }
            )
        }
        composable("peso") {
            PesoScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("altura")
                }
            )
        }
        composable("pesoObjetivo") {
            PesoObjetivoScreen(userSelectionsViewModel, onContinueClick = {
                navController.navigate("altura")
            })
        }
        composable("altura") {
            AlturaScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("nivelActividad")
                }
            )
        }
        composable("nivelActividad") {
            NivelActividadScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("entrenamientoFuerza")
                }
            )
        }
        composable("entrenamientoFuerza") {
            EntrenamientoFuerzaScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                onContinueClick = {
                    navController.navigate("summary")
                }
            )
        }
        composable("summary") {
            SummaryScreen(
                userSelectionsViewModel = userSelectionsViewModel,
                navController = navController, // Asegúrate de pasar el navController
                onEditClick = {
                    navController.popBackStack() // Opcional, vuelve a la pantalla anterior
                },
                onCalcularDatosClick = {
                    navController.navigate("calcularDatosSalud") // Reemplaza con la ruta correcta
                }
            )
        }
        composable("calcularDatosSalud") {
            CalcularDatosSaludScreen(
                userSelectionsViewModel = userSelectionsViewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthyTheme {
        val navController = rememberNavController()
        val userSelectionsViewModel = UserSelectionsViewModel()
        AppNavGraph(
            navController = navController,
            userSelectionsViewModel = userSelectionsViewModel
        )
    }
}
//Nadia estubo aqui
