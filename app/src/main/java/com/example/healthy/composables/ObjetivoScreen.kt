package com.example.healthy.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ObjetivoScreen(onContinueClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pregunta principal
        Text(
            text = "¿Qué objetivo tienes en mente?",
            style = MaterialTheme.typography.headlineSmall // Usando Material 3 style
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los elementos

        // Grupo de RadioButtons
        RadioButtonGroup(options = listOf("Perder peso", "Mantener el peso", "Aumentar peso"))

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los elementos

        // Botón para continuar
        Button(onClick = onContinueClick) {
            Text(text = "Continuar")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ObjetivoScreenPreview() {
    ObjetivoScreen(onContinueClick = {})
}
