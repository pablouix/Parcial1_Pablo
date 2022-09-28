package edu.ucne.parcial1_pablo.ui.articulos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ArticulosScreen(
    onNavigateBack: () -> Unit,
    viewModel: ArticulosViewModel = hiltViewModel()
){

    var errorDescripcion by remember {
        mutableStateOf(false)
    }

    var errorMarca by remember {
        mutableStateOf(false)
    }

    var errorExistencia by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(8.dp)) {
        
        Text(
            text = "Registro de Articulos",
            fontSize = 18.sp,
            modifier = Modifier.padding(0.dp,5.dp)
        )
        
        Spacer(modifier = Modifier.padding(6.dp))

        TextField(
            value = viewModel.descripcion,
            onValueChange = {viewModel.descripcion = it
                            errorDescripcion = false},
            label = { Text(text = "Descripcion")},
            placeholder = { Text(text = "Digita la descripcion")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            isError = errorDescripcion
        )

        if(errorDescripcion)
        {
            Text(text = "Error en la descripcion")
        }

        Spacer(modifier = Modifier.padding(3.dp))

        TextField(
            value = viewModel.marca,
            onValueChange = {viewModel.marca = it
                errorMarca = false},
            label = { Text(text = "Marca")},
            placeholder = { Text(text = "Digita la marca")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth(),
            isError = errorMarca
        )

        if(errorMarca)
        {
            Text(text = "Error en la marca")
        }

        Spacer(modifier = Modifier.padding(3.dp))

        TextField(
            value = viewModel.existencia,
            onValueChange = {viewModel.existencia = it
                errorExistencia = false},
            label = { Text(text = "Existencia")},
            placeholder = { Text(text = "Digita la existenica")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            isError = errorExistencia
        )

        if(errorExistencia)
        {
            Text(text = "Error en la existencia")
        }

        Spacer(modifier = Modifier.padding(6.dp))


        Button(
            onClick = {
                if(viewModel.descripcion.isBlank())
                    errorDescripcion = viewModel.descripcion.isBlank()
                else if(viewModel.marca.isBlank())
                    errorMarca = viewModel.marca.isBlank()
                else if(viewModel.existencia.toDouble()>=0)
                    errorExistencia = viewModel.existencia.toDouble()>=0
                else if(viewModel.existencia.isDigitsOnly())
                    errorExistencia = viewModel.existencia.isDigitsOnly()
                else
                {
                    viewModel.Save()
                    onNavigateBack()
                }
               },
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Text(text = "Guardar")
        }
    }



}


@Composable
@Preview(showSystemUi = true)
fun Preview() {

    ArticulosScreen({ })

}
