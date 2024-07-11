package buildhomes.app.artworkscollection.remoteData.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ArtWorks (
  @SerializedName("pagination" ) var pagination : Pagination?     = Pagination(),
//  @SerializedName("data"       ) var data       : @RawValue ArrayList<Data> = arrayListOf(),
  @SerializedName("data"       ) var data       : List<Data> = emptyList(),
  @SerializedName("info"       ) var info       : Info?           = Info(),
  @SerializedName("config"     ) var config     : Config?         = Config()
) : Parcelable