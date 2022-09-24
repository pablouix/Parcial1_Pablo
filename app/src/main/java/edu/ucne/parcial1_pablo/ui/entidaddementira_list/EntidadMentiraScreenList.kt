package edu.ucne.parcial1_pablo.ui.entidaddementira_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_pablo.data.entity.EntidadDeMentira


@Composable
fun EntidadMentiraScreenList(
    onClick: () -> Unit,
    viewModel: EntidadMentiraListViewModel = hiltViewModel()
)
{
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Lista")

        EntidadMentiraList(
            entidadDeMentira = uiState.entidadmentira,
            modifier = Modifier.padding(8.dp)

        )
        Button(
            onClick =  onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Registro")

        }
    }

}

@Composable
fun EntidadMentiraList(
    entidadDeMentira: List<EntidadDeMentira>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        items(entidadDeMentira){ entidadDeMentir ->
            EntidadDeMentiraRow(entidadDeMentir)
        }
    }
}

@Composable
fun EntidadDeMentiraRow(entidadDeMentira: EntidadDeMentira){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = ""+entidadDeMentira.id,
            style = MaterialTheme.typography.caption
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = ""+entidadDeMentira.string1)
            Text(text = "Valor ${entidadDeMentira.double1}")
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}