package io.github.fuadreza.moviecatalogue.ui.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.databinding.ItemsTvShowBinding

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class ViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mTvShow: TvShowEntity) {
            with(binding) {
                tvShow = mTvShow
                Glide.with(itemView)
                    .load(BuildConfig.IMAGE_URL + mTvShow.posterPath)
                    .into(ivPoster)
//                itemView.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
//                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, mTvShow.id)
//                    itemView.context.startActivity(intent)
//                }

                itemView.setOnClickListener { onItemClickCallback.onItemClicked(mTvShow.id) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: Int)
    }
}