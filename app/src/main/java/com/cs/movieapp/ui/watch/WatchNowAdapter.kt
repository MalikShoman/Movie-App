package com.cs.movieapp.ui.watch

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cs.movieapp.databinding.ItemMovieBinding
import com.cs.movieapp.model.movie.Movie
import com.cs.movieapp.model.movie.MovieResponse
import com.squareup.picasso.Picasso
import javax.inject.Inject

class WatchNowAdapter @Inject constructor() :
    ListAdapter<Movie, WatchNowAdapter.WatchNowViewHolder>(MovieDiffUtil()) {

    inner class WatchNowViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchNowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return WatchNowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchNowViewHolder, position: Int) {

        holder.apply {
            bind(getItem(position))
        }
        holder.itemView.setPadding(20, 20, 20, 20)

    }

    class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return newItem == oldItem
        }

    }

    companion object {
        const val BASE_URL = "https://image.tmdb.org/t/p/w500"

        @JvmStatic
        @BindingAdapter("movieImage")
        fun setMovieImage(view: ImageView, movieImageUrl: String) {
            Picasso.get()
                .load("$BASE_URL$movieImageUrl?api_key=4813d2a45541f505da221eb5c8bb1020&language=en-US")
                .into(view)
        }

        @JvmStatic
        @BindingAdapter("rating")
        fun setRating(ratingStars: RatingBar, rating: Double) {
            val maxLevel = 10000
            val level = (rating * maxLevel / 10).toFloat()
            ratingStars.rating= level
        }


    }


}


