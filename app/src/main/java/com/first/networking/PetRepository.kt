package com.first.networking

class PetRepository {
    private val api = RetrofitHelper.retrofit.create(PetApiService::class.java)

    suspend fun fetchPets(): List<Pet> {
        return api.getPets()
    }
}
