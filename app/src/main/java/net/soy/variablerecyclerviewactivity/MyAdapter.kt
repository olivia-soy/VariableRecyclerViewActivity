package net.soy.variablerecyclerviewactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<BaseViewHolder<Any>>() {

    companion object{
        const val VIEW_TYPE_TEXT = 1000
        const val VIEW_TYPE_IMAGE = 1001
    }


    override fun getItemViewType(position: Int): Int {
        return if(position % 2 == 0) VIEW_TYPE_TEXT else VIEW_TYPE_IMAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return when(viewType){
            VIEW_TYPE_TEXT -> TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
            VIEW_TYPE_IMAGE -> ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
            else -> TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.onBindView("", position)
    }


    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class TextViewHolder(itemView: View) : BaseViewHolder<Any>(itemView) {

    }

    class ImageViewHolder(itemView: View) : BaseViewHolder<Any>(itemView) {

    }
}
