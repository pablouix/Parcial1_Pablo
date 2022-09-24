package edu.ucne.parcial1_pablo.ui.entidaddementira

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EntidadMentiraScreen(
    onNavigateBack: () -> Unit
){

    Column() {
        Button(
            onClick = { onNavigateBack() },
            modifier = Modifier.fillMaxWidth().padding(8.dp)

        ) {
            Text(text = "Guardar")
        }
    }



}


@Composable
@Preview(showSystemUi = true)
fun Preview() {

    EntidadMentiraScreen({ })

}
