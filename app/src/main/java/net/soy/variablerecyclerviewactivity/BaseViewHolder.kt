package net.soy.variablerecyclerviewactivity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.NotNull

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    open fun onBindView(@NotNull item: T, position: Int){

    }
}