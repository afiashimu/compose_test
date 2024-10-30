package com.app.anew.service

interface ProtectedService {
    @GET("user/product")
    suspend fun product(): ProductResponse

    @GET("user/category")
    suspend fun getCategory(): CategoryResponse

}