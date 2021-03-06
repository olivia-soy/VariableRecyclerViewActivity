package net.soy.variablerecyclerviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.soy.variablerecyclerviewactivity.model.TextTwo

class MainActivity : AppCompatActivity() {

    private var mMyAdapter: MyAdapter? = null
    private var mLinearLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMyAdapter = MyAdapter(this, applicationContext)
        mLinearLayoutManager = LinearLayoutManager(this)

        rv_main.adapter = mMyAdapter
        rv_main.layoutManager = mLinearLayoutManager

        setData()
    }

    private fun setData(){
        val textTwos = ArrayList<TextTwo>()
        textTwos.add(TextTwo("하나", 1))
        textTwos.add(TextTwo("둘", 2))
        textTwos.add(TextTwo("셋", 3))
        textTwos.add(TextTwo("넷", 4))

        mMyAdapter?.setItems(textTwos, "Variable ViewType RecyclerView")
    }

    fun addData(){
        val textTwos = ArrayList<TextTwo>()
        textTwos.add(TextTwo("다섯", 5))
        textTwos.add(TextTwo("여섯", 6))
        textTwos.add(TextTwo("일곱", 7))
        textTwos.add(TextTwo("여덟", 8))

        mMyAdapter?.addItems(textTwos)
    }



}
