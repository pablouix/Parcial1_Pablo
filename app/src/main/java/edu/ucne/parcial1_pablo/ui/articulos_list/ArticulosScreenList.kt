package edu.ucne.parcial1_pablo.ui.articulos_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_pablo.data.entity.Articulo
import edu.ucne.parcial1_pablo.ui.articulos.ArticulosViewModel


@Composable
fun ArticulosScreenList(
    onClick: () -> Unit,
    viewModel: ArticulosListViewModel = hiltViewModel()
)
{
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = "Lista de Articulos",
            fontSize = 18.sp,
            modifier = Modifier.padding(0.dp,5.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 0.dp),
            color = Color.Blue
        )

        Spacer(modifier = Modifier.padding(6.dp))

        EntidadMentiraList(
            articulo = uiState.entidadmentira,
            modifier = Modifier.padding(0.dp)

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
fun EntidadDeMentiraRow(articulo: Articulo, viewModel: ArticulosViewModel = hiltViewModel()){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {


        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${articulo.articuloId}",
                    //style = MaterialTheme.typography.caption
                )
                Text(text = "Descripcion: ${articulo.descripcion}")


            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Marca: ${articulo.marca}")
                Text(text = "Existencia: ${articulo.existencia}")
            }

            Row() {
                Button(
                    onClick = {viewModel.Delete(articulo)}
                ) {
                    Text(text = "Eliminar")
                }
                Spacer(modifier = Modifier.padding(6.dp))

                Button(
                    onClick = {},
                ) {
                    Text(text = "Editar")
                }

            }



        }


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}