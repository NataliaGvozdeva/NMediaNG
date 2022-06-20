package ru.netology.nmediang.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean,
    var likesSum: Long,
    var sharedSum: Long,
    var viewSum: Long

)