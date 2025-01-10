package com.mosalab.spacecraftsapp.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mosalab.spacecraftsapp.core.ViewModel.DetailViewModel


@Composable
fun DetailScreen(spacecraftId: Int, viewModel: DetailViewModel = hiltViewModel()) {
    val spacecraft by viewModel.getSpacecraftById(spacecraftId).collectAsState(initial = null)

    spacecraft?.let {
        Column(Modifier.padding(16.dp)) {
            Text("Name: ${it.name}")
            // Tambahkan informasi detail lainnya
        }
    }
}
