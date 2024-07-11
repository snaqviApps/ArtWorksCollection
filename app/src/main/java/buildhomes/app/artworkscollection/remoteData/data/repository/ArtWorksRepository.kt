package buildhomes.app.artworkscollection.remoteData.data.repository

import buildhomes.app.artworkscollection.util.ArtWorksState

interface ArtWorksRepository {
    suspend fun getArtworks(): ArtWorksState // Replace with actual data type
}