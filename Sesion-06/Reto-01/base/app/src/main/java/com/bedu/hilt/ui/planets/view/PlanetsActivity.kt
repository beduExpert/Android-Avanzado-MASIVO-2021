package com.bedu.hilt.ui.planets.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedu.hilt.R
import com.bedu.hilt.data.model.Planet
import com.bedu.hilt.databinding.ActivityRecyclerBinding
import com.bedu.hilt.ui.planets.adapter.PlanetsAdapter
import com.bedu.hilt.ui.planets.viewmodel.PlanetsViewModel
import com.bedu.hilt.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class PlanetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    private val planetsViewModel : PlanetsViewModel by viewModels()
    private lateinit var adapter: PlanetsAdapter

    @Inject
    @Named("provideImage")
    lateinit var provideImage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlanetsAdapter(arrayListOf(), provideImage)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            planetsViewModel.onRefresh()
        }
    }

    private fun setupObserver() {
        planetsViewModel.planet.observe(this, Observer {
            binding.swipeRefreshLayout.isRefreshing = false
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { planets -> renderList(planets) }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(list: List<Planet>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }
}
