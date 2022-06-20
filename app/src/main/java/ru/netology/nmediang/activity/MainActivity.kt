package ru.netology.nmediang.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmediang.databinding.ActivityMainBinding
import ru.netology.nmediang.R
import ru.netology.nmediang.viewmodel.PostViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this, { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                likesNumber.text = displayNumbers(post.likesSum)
                share.setImageResource(
                    if (post.sharedSum > 0) R.drawable.ic_baseline_shared_24 else R.drawable.ic_baseline_share_24
                )
                shareNumber.text = displayNumbers(post.sharedSum)

                viewNumber.text = displayNumbers(post.viewSum)
                view.setImageResource(R.drawable.ic_baseline_visibility_viewed_24)

            }
        })
        binding.like.setOnClickListener {
            viewModel.like()
        }

        binding.share.setOnClickListener {
            viewModel.share()
        }
    }

    fun displayNumbers(number: Long): String {
        val decimalFormat = DecimalFormat("#.#")
        decimalFormat.roundingMode = RoundingMode.DOWN
        return when (number) {
            in 0..999 -> "$number"
            in 1000..9_999 -> "${decimalFormat.format(number.toFloat() / 1_000)}K"
            in 10_000..999_999 -> "${number / 1_000}K"
            in 1_000_000..9_999_999 -> "${decimalFormat.format(number.toFloat() / 1_000_000)}M"
            else -> "${number / 1_000_000}M"
        }
    }

}

