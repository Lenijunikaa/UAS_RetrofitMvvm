package com.stmiklombok.mvvmdanretrofit

import com.stmiklombok.mvvmdanretrofit.model.Book
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
    @GET("book.json")
    suspend fun getBooks() : Response<List<Book>>

}