package syahputro.bimo.kade.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueModel(
    val id: String?,
    val name: String?,
    val image: Int?,
    val deskripsi: String?,
    val kode: String?
) : Parcelable
