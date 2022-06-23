package ru.netology.nmediang.repository

import androidx.lifecycle.LiveData
import ru.netology.nmediang.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}