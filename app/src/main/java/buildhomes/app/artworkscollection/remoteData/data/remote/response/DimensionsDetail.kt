package buildhomes.app.artworkscollection.remoteData.data.remote.response

import com.google.gson.annotations.SerializedName


data class DimensionsDetail (

  @SerializedName("depth"         ) var depth         : Int?    = null,
  @SerializedName("width"         ) var width         : Int?    = null,
  @SerializedName("height"        ) var height        : Int?    = null,
  @SerializedName("diameter"      ) var diameter      : String? = null,
  @SerializedName("clarification" ) var clarification : String? = null

)