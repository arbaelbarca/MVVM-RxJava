package com.arbaelbarca.grawgames.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arbaelbarca.grawgames.R
import com.arbaelbarca.grawgames.presentation.model.response.ResponseLatesGames
import com.arbaelbarca.grawgames.utils.BaseGenericAdapter
import com.arbaelbarca.grawgames.utils.loadImageUrl
import kotlinx.android.synthetic.main.layout_item_latesgames.view.*

class AdapterLatesGames(
    val listLatesGames: MutableList<ResponseLatesGames.ResultGames>
) : BaseGenericAdapter(
    listLatesGames.toMutableList(),
    R.layout.layout_item_latesgames
) {
    override fun getView(view: View?): View? {
        return view
    }

    override fun onBindViewHold(position: Int, viewHolder: RecyclerView.ViewHolder, any: Any?) {
        val getResultGames = listLatesGames[position]
        viewHolder.apply {
            itemView.apply {
                imgItemLatesGames.loadImageUrl(getResultGames.background_image.toString(), context)
                tvTitleItemLateGames.text = getResultGames.name
            }
        }

    }
}