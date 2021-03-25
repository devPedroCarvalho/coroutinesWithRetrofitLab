package app.devPedroCarvalho.coroutineswithretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.devPedroCarvalho.coroutineswithretrofit.R

class ListCountriesAdapter(val listCountries: List<String>): RecyclerView.Adapter<ListCountriesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_recycler_view, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCountries.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       holder.title.text = listCountries[position]
    }


    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title = itemView.findViewById<TextView>(R.id.titleTextView)
        val image = itemView.findViewById<ImageView>(R.id.imageImageView)

    }
}