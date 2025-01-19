package com.mosalab.spacecraftisro.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mosalab.spacecraftisro.core.ui.SpacecraftAdapter
import com.mosalab.spacecraftisro.favorite.databinding.ActivityFavoriteBinding
import com.mosalab.spacecraftisro.detail.DetailSpacecraftActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

//class FavoriteActivity : AppCompatActivity() {
//
//    private val favoriteViewModel: FavoriteViewModel by viewModel()
//    private var _binding: ActivityFavoriteBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val spacecraftAdapter = SpacecraftAdapter()
//        spacecraftAdapter.onItemClick = { selectedData ->
//            val intent = Intent(this, DetailSpacecraftActivity::class.java)
//            intent.putExtra(DetailSpacecraftActivity.EXTRA_DATA, selectedData)
//            startActivity(intent)
//        }
//
//        favoriteViewModel.favoriteSpacecraft.observe(this) { dataSpacecraft ->
//            spacecraftAdapter.submitList(dataSpacecraft)
////            binding.viewEmpty.viewEmptyRoot.visibility =
////                if (dataSpacecraft.isNotEmpty()) View.GONE else View.VISIBLE
//        }
//
//        with(binding.rvSpacecraft) {
//            layoutManager = LinearLayoutManager(this@FavoriteActivity)
//            setHasFixedSize(true)
//            adapter = spacecraftAdapter
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//}

//
//class FavoriteActivity : AppCompatActivity() {
//
//    private val favoriteViewModel: FavoriteViewModel by viewModel()
//    private lateinit var binding: ActivityFavoriteBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityFavoriteBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        loadKoinModules(favoriteModule)
//
//        supportActionBar?.title = "Spacecraft App"
//
//        val spacecraftAdapter = SpacecraftAdapter()
//        spacecraftAdapter.onItemClick = { selectedData ->
//            val intent = Intent(this, DetailSpacecraftActivity::class.java)
//            intent.putExtra(DetailSpacecraftActivity.EXTRA_DATA, selectedData)
//            startActivity(intent)
//        }
//
//        favoriteViewModel.favoriteSpacecraft.observe(this) { dataSpacecraft ->
//            spacecraftAdapter.submitList(dataSpacecraft)
//
////            binding.viewEmpty.viewEmptyRoot.visibility =
////                if (dataSpacecraft.isNotEmpty()) View.GONE else View.VISIBLE
//        }
//
//        with(binding.rvSpacecraft) {
//            layoutManager = LinearLayoutManager(this@FavoriteActivity)
//            setHasFixedSize(true)
//            adapter = spacecraftAdapter
//        }
//    }
//
////    override fun onDestroy() {
////        super.onDestroy()
////        binding = null
////    }
//}

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Correctly inflate layout with ViewBinding
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load Koin modules
        loadKoinModules(favoriteModule)

//        supportActionBar?.title = "Favorite Spacecraft"


        // Setup RecyclerView
        val spacecraftAdapter = SpacecraftAdapter().apply {
            onItemClick = { selectedData ->
                val intent = Intent(this@FavoriteActivity, DetailSpacecraftActivity::class.java)
                intent.putExtra(DetailSpacecraftActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }
        }

        // Observe ViewModel
        favoriteViewModel.favoriteSpacecraft.observe(this) { dataSpacecraft ->
            spacecraftAdapter.submitList(dataSpacecraft)

//            binding.viewEmpty.root.visibility = if (dataSpacecraft.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvSpacecraft) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = spacecraftAdapter
        }
    }
}
