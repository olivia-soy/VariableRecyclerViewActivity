package net.soy.variablerecyclerviewactivity

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import net.soy.variablerecyclerviewactivity.model.BaseItem
import net.soy.variablerecyclerviewactivity.model.TextOneItem
import net.soy.variablerecyclerviewactivity.model.TextTwo
import net.soy.variablerecyclerviewactivity.model.TextTwoItem

class MyAdapter(private val activity: Activity, context: Context) : BaseAdapter<BaseItem>(context) {

    companion object{
        const val VIEW_TYPE_TEXT_ONE: Int = 1000
        const val VIEW_TYPE_TEXT_TWO: Int = 1001
        const val VIEW_TYPE_MORE: Int = 1002
    }

    private var itemSize = 0

    override fun onCreateCustomholder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>? {
        return when(viewType){
            VIEW_TYPE_TEXT_ONE -> TextOneViewHolder(this, LayoutInflater.from(parent.context).inflate(R.layout.item_text_one, parent, false))
            VIEW_TYPE_TEXT_TWO -> TextTwoViewHolder(this,LayoutInflater.from(parent.context).inflate(R.layout.item_text_two, parent, false))
            VIEW_TYPE_MORE -> MoreViewHolder(this,LayoutInflater.from(parent.context).inflate(R.layout.item_more, parent, false))
            else -> null
        }
    }

    fun setItems(textTwos: ArrayList<TextTwo>?, title: String){
        clear()
        addItem(TextOneItem(VIEW_TYPE_TEXT_ONE, title))

        textTwos?.let {
            for(i in it.indices){
                addItem(TextTwoItem(VIEW_TYPE_TEXT_TWO, it[i]))
            }
            itemSize = it.size
        }
        addItem(TextOneItem(VIEW_TYPE_MORE, ""))

        notifyDataSetChanged()
    }

    fun addItems(textTwos: ArrayList<TextTwo>?){

        val position = itemSize.plus(1) // 1은 VIEW_TYPE_TEXT_ONE 를 더해준 값

        if(getItemViewType(position) == VIEW_TYPE_MORE){
            removeItem(position)
        }
        textTwos?.let {
            for(i in it.indices){
                addItem(position + it.size, TextTwoItem(VIEW_TYPE_TEXT_TWO, it[i]))
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

    class MoreViewHolder(adapter: BaseAdapter<*>, itemView: View): BaseViewHolder<TextOneItem>(adapter, itemView){
        private var tvMore = itemView.findViewById<TextView>(R.id.tv_more)
        private var mActivity = (adapter is MyAdapter).run { (adapter as MyAdapter).activity }
        override fun onBindView(item: TextOneItem?, position: Int) {
            super.onBindView(item, position)
            tvMore?.setOnClickListener {
                if(mActivity is MainActivity){
                    (mActivity as MainActivity).addData()
                }
            }
        }
    }
}
