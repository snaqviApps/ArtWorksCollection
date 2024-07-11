package buildhomes.app.artworkscollection.di.module

import buildhomes.app.artworkscollection.remoteData.data.repository.ArtWorksRepository
import buildhomes.app.artworkscollection.remoteData.domain.usecases.ArtWorksRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ArtWorksRepositoryModule {

    @Binds
    @Singleton
    abstract fun providesArtsWorksRepository(artWorksRepositoryImpl : ArtWorksRepositoryImpl) : ArtWorksRepository
}