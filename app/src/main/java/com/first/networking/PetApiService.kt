package com.first.networking

import retrofit2.http.GET

interface PetApiService {
    @GET("pets")
    suspend fun getPets(): List<Pet>
}
