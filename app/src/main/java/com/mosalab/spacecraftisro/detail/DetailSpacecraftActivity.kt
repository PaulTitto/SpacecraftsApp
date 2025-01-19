package com.mosalab.spacecraftisro.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.mosalab.spacecraftisro.R
import com.mosalab.spacecraftisro.core.domain.model.Spacecraft
import com.mosalab.spacecraftisro.databinding.ActivityDetailSpaceraftBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSpacecraftActivity : AppCompatActivity() {
    private val detailSpacecraftViewModel: DetailSpacecraftViewModel by viewModel()
    private lateinit var binding: ActivityDetailSpaceraftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDetailSpaceraftBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailSpacecraft =  getParcelableExtra(intent, EXTRA_DATA, Spacecraft::class.java)
        showDetailSpacecraft(detailSpacecraft)
    }

    private fun showDetailSpacecraft(detailSpacecraft: Spacecraft?){
        detailSpacecraft?.let {
            supportActionBar?.title = detailSpacecraft.spacecraftId
            binding.contentDetailTourism.tvDetailDescription.text = detailSpacecraft.name

            var statusFavorite = detailSpacecraft.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener{
                statusFavorite = !statusFavorite
                detailSpacecraftViewModel.setFavoriteSpacecraft(detailSpacecraft, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean){
        if(statusFavorite){
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        }else{
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))

        }
    }
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}