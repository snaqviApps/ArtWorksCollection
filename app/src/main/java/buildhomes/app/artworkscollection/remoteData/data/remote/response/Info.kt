package buildhomes.app.artworkscollection.remoteData.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info (
  @SerializedName("license_text"  ) var licenseText  : String?           = null,
  @SerializedName("license_links" ) var licenseLinks : ArrayList<String> = arrayListOf(),
  @SerializedName("version"       ) var version      : String?           = null
) : Parcelable