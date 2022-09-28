package edu.ucne.parcial1_pablo.ui.articulos_list

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
import edu.ucne.parcial1_pablo.data.entity.Articulo


@Composable
fun ArticulosScreenList(
    onClick: () -> Unit,
    viewModel: ArticulosListViewModel = hiltViewModel()
)
{
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Lista")

        EntidadMentiraList(
            articulo = uiState.entidadmentira,
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
    articulo: List<Articulo>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier){
        items(articulo){ entidadDeMentir ->
            EntidadDeMentiraRow(entidadDeMentir)
        }
    }
}

@Composable
fun EntidadDeMentiraRow(articulo: Articulo){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = ""+articulo.articuloId,
            style = MaterialTheme.typography.caption
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = ""+articulo.descripcion)
            Text(text = "Valor ${articulo.existencia}")
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}