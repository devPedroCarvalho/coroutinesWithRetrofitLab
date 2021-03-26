package app.devPedroCarvalho.coroutineswithretrofit.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.devPedroCarvalho.coroutineswithretrofit.R
import app.devPedroCarvalho.coroutineswithretrofit.network.response.CountryResponse
import com.bumptech.glide.Glide

class ListCountriesAdapter(private val listCountries: List<CountryResponse>, private val context: Context): RecyclerView.Adapter<ListCountriesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_recycler_view, parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCountries.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       holder.title.text = listCountries[position].countryName
        Glide.with(context)
                .load(listCountries[position].flag)
                .into(holder.image)
    }


    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val image: ImageView = itemView.findViewById(R.id.imageImageView)

    }
}