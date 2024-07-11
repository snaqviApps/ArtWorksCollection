package buildhomes.app.artworkscollection.ui.presentation.view

import android.net.http.NetworkException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import buildhomes.app.artworkscollection.util.ArtWorksState
import buildhomes.app.artworkscollection.remoteData.data.repository.ArtWorksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * next steps:
 * - provide stateFlow to the Observer (MainActivity in Compose based View) using its inherent state-handling mechanism
 * - observe it using remember - lambda(correct-term ?) as below:
 *   remember { mutableStateOf(stateFlow) }
 * -
 */

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class ArtWorksViewModel @Inject constructor(
    private val artWorksRepository: ArtWorksRepository
) : ViewModel() {
    private val _artWorksStatesEmit = MutableStateFlow<ArtWorksState>(ArtWorksState.Empty(""))
    val artWorksStatesEmit: StateFlow<ArtWorksState> = _artWorksStatesEmit.asStateFlow()

    init {
        getArtworks()
    }

    private fun getArtworks() = viewModelScope.launch(Dispatchers.IO)
    {
        try {
            when(val response = artWorksRepository.getArtworks()) {
                is ArtWorksState.Success -> {
                    _artWorksStatesEmit.update { ArtWorksState.Success( response.artworks ) }
                }
                is ArtWorksState.Error -> {
                    _artWorksStatesEmit.update { ArtWorksState.Error(response.error) }
                }
                is ArtWorksState.Empty -> {
                    _artWorksStatesEmit.update {  ArtWorksState.Empty("No artworks found") }
                }
                is ArtWorksState.Loading -> ArtWorksState.Loading()
            }
        } catch (e: NetworkException) {
            _artWorksStatesEmit.update { ArtWorksState.Error("Network error: ${e.message}") }
        }
    }

}
