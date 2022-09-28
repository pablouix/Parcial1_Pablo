package edu.ucne.parcial1_pablo.ui.articulos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_pablo.Repositorio.ArticulosRepositorio
import edu.ucne.parcial1_pablo.data.entity.Articulo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class EntidadMentiraUiState(
    val entidadmentira: List<Articulo> = emptyList(),
    val texto: String = "Meeting"
)


@HiltViewModel
class ArticulosListViewModel @Inject constructor(
    val repositorio: ArticulosRepositorio
) : ViewModel(){

    private val _uiState = MutableStateFlow(EntidadMentiraUiState())
    val uiState: StateFlow<EntidadMentiraUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            repositorio.getAll().collect {
                list ->
                _uiState.update {
                    it.copy(entidadmentira = list)
                }
            }
        }
    }

}

