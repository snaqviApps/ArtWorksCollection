package buildhomes.app.artworkscollection.remoteData.data.remote.response

import com.google.gson.annotations.SerializedName


data class Color (

  @SerializedName("h"          ) var h          : Int?    = null,
  @SerializedName("l"          ) var l          : Int?    = null,
  @SerializedName("s"          ) var s          : Int?    = null,
  @SerializedName("percentage" ) var percentage : Double? = null,
  @SerializedName("population" ) var population : Int?    = null

)