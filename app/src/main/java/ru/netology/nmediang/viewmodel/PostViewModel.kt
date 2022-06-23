package ru.netology.nmediang.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmediang.repository.PostRepository
import ru.netology.nmediang.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
}