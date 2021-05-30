package io.github.fuadreza.moviecatalogue.ui.tv_shows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.databinding.ItemsTvShowBinding
import io.github.fuadreza.moviecatalogue.ui.detail.tv_shows.DetailTvShowActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private val listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: ArrayList<TvShowEntity>?){
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsTvShowBinding)
    }

    override fun getItemCount(): Int = listTvShows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    class ViewHolder(private val binding: ItemsTvShowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(mTvShow: TvShowEntity){
            with(binding){
                tvShow = mTvShow
                Glide.with(itemView)
                    .load(BuildConfig.IMAGE_URL + mTvShow.posterPath)
                    .into(ivPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, mTvShow.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}