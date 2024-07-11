package buildhomes.app.artworkscollection.remoteData.data.remote.response

import com.google.gson.annotations.SerializedName


data class Contexts (

  @SerializedName("groupings" ) var groupings : ArrayList<String> = arrayListOf()

)