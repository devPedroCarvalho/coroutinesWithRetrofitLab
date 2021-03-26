package app.devPedroCarvalho.coroutineswithretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.devPedroCarvalho.coroutineswithretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var  viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getCountries()
        setupObserver()

    }

    private fun setupObserver(){
        viewModel.countriesListLiveData.observe(this, Observer {
            it?.let {
                binding.listItemsRecyclerView.layoutManager = LinearLayoutManager(this)
               binding.listItemsRecyclerView.adapter = ListCountriesAdapter(it, this)
            }
        })
    }

}