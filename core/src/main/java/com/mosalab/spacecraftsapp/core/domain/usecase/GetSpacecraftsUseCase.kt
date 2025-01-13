package com.mosalab.spacecraftsapp.core.domain.usecase

import com.mosalab.spacecraftsapp.core.data.repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.domain.model.Spacecraft
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSpacecraftsUseCase @Inject constructor(
    private val repository: SpacecraftRepository
) {
    fun execute(): Flow<List<Spacecraft>> = repository.getSpacecrafts()
}