package net.soy.variablerecyclerviewactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.soy.variablerecyclerviewactivity.model.BaseItem
import net.soy.variablerecyclerviewactivity.model.TextOneItem
import net.soy.variablerecyclerviewactivity.model.TextTwo
import net.soy.variablerecyclerviewactivity.model.TextTwoItem

class MyAdapter(context: Context) : BaseAdapter<BaseItem>(context) {

    companion object{
        const val VIEW_TYPE_TEXT_ONE: Int = 1000
        const val VIEW_TYPE_TEXT_TWO: Int = 1001
    }

    override fun onCreateCustomholder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>? {
        return when(viewType){
            VIEW_TYPE_TEXT_ONE -> TextOneViewHolder(this, LayoutInflater.from(parent.context).inflate(R.layout.item_text_one, parent, false))
            VIEW_TYPE_TEXT_TWO -> TextTwoViewHolder(this,LayoutInflater.from(parent.context).inflate(R.layout.item_text_two, parent, false))
            else -> null
        }
    }

    fun setItems(textTwos: ArrayList<TextTwo>?, title: String){
        clear()
        addItem(null, TextOneItem(VIEW_TYPE_TEXT_ONE, title))

        textTwos?.let {
            for(i in it.indices){
                addItem(null, TextTwoItem(VIEW_TYPE_TEXT_TWO, it[i]))
            }
        }

        notifyDataSetChanged()
    }

    fun addItems(textTwos: ArrayList<TextTwo>?){
        textTwos?.let {
            for(i in it.indices){
                addItem(null, TextTwoItem(VIEW_TYPE_TEXT_TWO, it[i]))
            }
        }
        notifyDataSetChanged()
    }


    class TextOneViewHolder(adapter: BaseAdapter<*>, itemView: View): BaseViewHolder<TextOneItem>(adapter, itemView){
        private var tvOne = itemView.findViewById<TextView>(R.id.tv_one)
        override fun onBindView(item: TextOneItem?, position: Int) {
            super.onBindView(item, position)
            tvOne.text = item?.title
        }
    }

    class TextTwoViewHolder(adapter: BaseAdapter<*>, itemView: View): BaseViewHolder<TextTwoItem>(adapter, itemView){
        private var tvOne = itemView.findViewById<TextView>(R.id.tv_one)
        private var tvTwo = itemView.findViewById<TextView>(R.id.tv_two)
        override fun onBindView(item: TextTwoItem?, position: Int) {
            super.onBindView(item, position)
            tvOne.text = item?.textTwo?.title
            tvTwo.text = item?.textTwo?.num.toString()
        }
    }
}
