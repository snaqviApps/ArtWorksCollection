package buildhomes.app.artworkscollection.ui.presentation.view.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import buildhomes.app.artworkscollection.remoteData.data.remote.response.ArtWorks
import buildhomes.app.artworkscollection.ui.presentation.view.ArtWorksViewModel
import buildhomes.app.artworkscollection.util.ArtWorksState

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ArtWorksScreen(modifier: Modifier) {
    val viewModel: ArtWorksViewModel = hiltViewModel()  //  ----------------> Causes Crash

    val artWorksStateFlowLatestValue: ArtWorksState by viewModel.artWorksStatesEmit.collectAsState()
//    val artWorksStateFlowLatestValue = viewModel.artWorksStatesEmit.collectAsState()

    val emits =  rememberSaveable { mutableStateOf(ArtWorks()) }
    val contextLocal = LocalContext.current
    ArtWorksList (
        artWorksStateFlowLatestValue,
        emits,
        {
            when(artWorksStateFlowLatestValue) {
                is ArtWorksState.Loading -> ArtWorksState.Loading(true)
                is ArtWorksState.Error -> {
                    ArtWorksState.Error((artWorksStateFlowLatestValue as ArtWorksState.Error).error)
                }
                is ArtWorksState.Success -> {
                    emits.value = (artWorksStateFlowLatestValue as ArtWorksState.Success).artworks!!
                }
                is ArtWorksState.Empty -> ArtWorksState.Empty("")
            }
            Toast.makeText(contextLocal, "Toasted: ${emits.value}", Toast.LENGTH_SHORT).show()
        },
        modifier
    )
}