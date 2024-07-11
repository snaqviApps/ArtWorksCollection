package buildhomes.app.artworkscollection.remoteData.domain.usecases

import buildhomes.app.artworkscollection.util.ArtWorksState
import buildhomes.app.artworkscollection.remoteData.data.remote.ArtWorksApi
import buildhomes.app.artworkscollection.remoteData.data.repository.ArtWorksRepository
import javax.inject.Inject

class ArtWorksRepositoryImpl @Inject constructor(
    private val artWorksApi: ArtWorksApi
) : ArtWorksRepository
{
    override suspend fun getArtworks(): ArtWorksState {
        val remoteResultRepoState: ArtWorksState = try {
            ArtWorksState.Success( artWorksApi.getArtworks())
        }catch (e: retrofit2.HttpException){
            ArtWorksState.Error((e.message as String).plus(" page not found "))
        }
        return remoteResultRepoState
    }
}