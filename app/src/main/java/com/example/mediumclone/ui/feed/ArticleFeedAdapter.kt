package com.example.mediumclone.ui.feed

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mediumclone.R
import com.example.mediumclone.databinding.ListItemArticleBinding
import io.realworld.api.models.entities.Article

class ArticleFeedAdapter : ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(

    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.toString() == newItem.toString()
        }

    }

)  {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleFeedAdapter.ArticleViewHolder {
            return ArticleViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                    R.layout.list_item_article,
                    parent,false
                )
            )
        }

        override fun onBindViewHolder(holder: ArticleFeedAdapter.ArticleViewHolder, position: Int) {
            ListItemArticleBinding.bind(holder.itemView).apply {
                val article = getItem(position)

                tvUsername.text = article.author.username
                tvTitle.text = article.title
                tvDescription.text = article.body
            }
        }




}