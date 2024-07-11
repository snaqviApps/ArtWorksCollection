package buildhomes.app.artworkscollection.remoteData.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Config (

  @SerializedName("iiif_url"    ) var iiifUrl    : String? = null,
  @SerializedName("website_url" ) var websiteUrl : String? = null

) : Parcelable