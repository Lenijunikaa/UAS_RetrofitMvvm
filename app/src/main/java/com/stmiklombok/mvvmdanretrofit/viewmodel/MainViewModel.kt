package com.stmiklombok.mvvmdanretrofit.viewmodel

import android.util.Log.e
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stmiklombok.mvvmdanretrofit.BookApi
import com.stmiklombok.mvvmdanretrofit.RetrofitHelper
import com.stmiklombok.mvvmdanretrofit.model.Book
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private var _book = MutableLiveData<List<Book>?>()
    val book : LiveData<List<Book>?>
        get() = _book

    fun getBooks(){
        viewModelScope.launch {
            val response = RetrofitHelper.getInstance().create(BookApi::class.java).getBooks()
            if (response.isSuccessful) {
                val books = response.body()
                _book.postValue(books)
            } else {
                // Handle error response
                e("Error", response.errorBody().toString())
            }
        }
    }
}