package buildhomes.app.artworkscollection.ui.presentation.view.screen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import buildhomes.app.artworks.ui.theme.ArtWorksTheme
import buildhomes.app.artworkscollection.remoteData.data.remote.response.ArtWorks
import buildhomes.app.artworkscollection.util.ArtWorksState

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ArtWorksList(
    artWorksState: ArtWorksState?,
    emits: MutableState<ArtWorks>?,
    onGetArtWorks: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewState = rememberLazyListState()
    Column(modifier = modifier.padding(8.dp), verticalArrangement = Arrangement.Center)
    {
        Button(
            onClick = onGetArtWorks,
            Modifier
                .height(70.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                bottomStart = 40.dp)
        ){
            Card(
                modifier = Modifier
                   .fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(12.dp),
                    contentAlignment = Alignment.Center,
                )
                {
                    Text(text = "Get Artworks afdasdfads: ${emits?.value?.pagination?.totalPages}",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        LazyColumn(
            state = viewState,
            modifier = modifier
                .fillMaxWidth()
                .height(600.dp)
        ) {
            emits?.value?.data?.size?.let {
                items(it) { index ->
                    Text(
                        text = "${emits.value.data[index].title}",
                        softWrap = true,
                        maxLines = 5,
                        modifier = Modifier
                            .border(
                                width = 5.dp,
                                color = MaterialTheme.colorScheme.background,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        MaterialTheme.colorScheme.onSecondary,
                                        Color.Blue.copy(alpha = 0.1f)
                                    )
                                ),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(12.dp),
                    )
                    Spacer(modifier = Modifier.height(1.dp))
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

