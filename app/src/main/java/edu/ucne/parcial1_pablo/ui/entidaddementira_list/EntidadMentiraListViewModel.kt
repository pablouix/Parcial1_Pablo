package edu.ucne.parcial1_pablo.ui.entidaddementira_list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_pablo.data.entity.Articulo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class EntidadMentiraUiState(
    val entidadmentira: List<Articulo> = emptyList(),
    val texto: String = "Meeting"
)


@HiltViewModel
class EntidadMentiraListViewModel @Inject constructor(
    //val repository :
) : ViewModel(){

    private val _uiState = MutableStateFlow(EntidadMentiraUiState())
    val uiState: StateFlow<EntidadMentiraUiState> = _uiState.asStateFlow()

    /*

    init {
        viewModelScope.launch {
            repository.getAll().collect {
                list ->
                _uiState.update {
                    it.copy(entidadmentira = list)
                }
            }
        }
    }
    */
}

