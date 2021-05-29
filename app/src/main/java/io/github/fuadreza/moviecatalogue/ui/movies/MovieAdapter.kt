package io.github.fuadreza.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.databinding.ItemsMovieBinding
import io.github.fuadreza.moviecatalogue.ui.detail.movies.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: ArrayList<MovieEntity>?){
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsMovieBinding)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    class ViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(mMovie: MovieEntity){
            with(binding){
                movie = mMovie
                Glide.with(itemView)
                    .load("file:///android_asset/${mMovie.imagePath}")
                    .into(ivPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, mMovie.movieId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}