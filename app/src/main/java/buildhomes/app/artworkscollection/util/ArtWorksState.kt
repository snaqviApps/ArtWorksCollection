package buildhomes.app.artworkscollection.util

import buildhomes.app.artworkscollection.remoteData.data.remote.response.ArtWorks

sealed interface ArtWorksState {
    val isLoading : Boolean
    data class Loading(override val isLoading: Boolean = true) : ArtWorksState
    data class Empty(val reason: String, override val isLoading: Boolean = false) : ArtWorksState
    data class Success(val artworks: ArtWorks?, override val isLoading: Boolean = false) : ArtWorksState
    data class Error(val error: String, override val isLoading: Boolean = false) : ArtWorksState
}
