package com.example.healthy.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EntrenamientoFuerzaScreen(onContinueClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿Realizas entrenamiento de fuerza?",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        RadioButtonGroup(
            options = listOf("Sí", "No"),
            onOptionSelected = { selectedOption ->
                // Aquí puedes manejar la opción seleccionada si es necesario
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onContinueClick) {
            Text(text = "Continuar")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EntrenamientoFuerzaScreenPreview() {
    EntrenamientoFuerzaScreen(onContinueClick = {})
}
