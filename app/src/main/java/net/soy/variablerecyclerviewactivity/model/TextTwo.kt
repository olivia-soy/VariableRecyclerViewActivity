package net.soy.variablerecyclerviewactivity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TextTwo(
    /**
     * Description : title
     */
    @SerializedName("title") @Expose var title: String?,

    /**
     * Description: num
     */
    @SerializedName("num") @Expose var num: Int?

)