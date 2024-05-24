package com.example.marvel_app.domain.usecases

import com.example.marvel_app.data.repository.Repository
import javax.inject.Inject

class UseCaseCharacter @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(characterId: String) =
        repository.getCharacterById(characterId = characterId)
}