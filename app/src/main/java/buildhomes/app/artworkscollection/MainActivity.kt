package buildhomes.app.artworkscollection

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import buildhomes.app.artworks.ui.theme.ArtWorksTheme
import buildhomes.app.artworkscollection.ui.presentation.view.screen.ArtWorksList
import buildhomes.app.artworkscollection.ui.presentation.view.screen.ArtWorksScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtWorksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtWorksScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                }
            }
        }
    }

}
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ArtWorksTheme {
            ArtWorksList(
                null,
                null,
                { },
                modifier = Modifier.padding(15.dp)
            )
        }
    }


