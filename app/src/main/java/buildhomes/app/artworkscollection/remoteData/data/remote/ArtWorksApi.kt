package buildhomes.app.artworkscollection.remoteData.data.remote

import buildhomes.app.artworkscollection.remoteData.data.remote.response.ArtWorks
import retrofit2.http.GET

interface ArtWorksApi {

    @GET("v1/artworks")
//    @GET("v1/artwork")
    suspend fun getArtworks(): ArtWorks
}