package com.mr_17.mednex.ui.community.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mr_17.mednex.databinding.ItemPostBinding
import com.mr_17.mednex.ui.community.models.Post
import de.hdodenhof.circleimageview.CircleImageView

class PostsRecyclerViewAdapter(
    var list: List<Post>,
    var context: Context,
    var listener: OnClickListener,
) :
    RecyclerView.Adapter<PostsRecyclerViewAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
    false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list[position]
        holder.apply {
            tvUsername.text = post.username
            tvMessage.text = post.text
            tvTime.text = post.timeAgo
            tvLikeCount.text = post.likeCount.toString()
            tvReplyCount.text = post.childrenIdList.size.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(
        binding: ItemPostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        var civProfilePicture: CircleImageView
        var tvUsername: TextView
        var tvMessage: TextView
        var tvTime: TextView
        private var ibLike: ImageButton
        private var ibReply: ImageButton
        var tvLikeCount: TextView
        var tvReplyCount: TextView

        init {
            binding.apply {
                this@ViewHolder.civProfilePicture = civProfilePicture
                this@ViewHolder.tvUsername = tvUsername
                this@ViewHolder.tvMessage = tvMessage
                this@ViewHolder.tvTime = tvTime
                this@ViewHolder.ibLike = ibLike
                this@ViewHolder.ibReply = ibReply
                this@ViewHolder.tvLikeCount = tvLikeCount
                this@ViewHolder.tvReplyCount = tvReplyCount

                ibLike.setOnClickListener {
                    listener.onLikeButtonClick(binding.root, list[adapterPosition])
                }

                ibReply.setOnClickListener {
                    listener.onReplyButtonClick(binding.root, list[adapterPosition])
                }
            }
        }
    }

    interface OnClickListener {
        fun onLikeButtonClick(v: View?, post: Post)
        fun onReplyButtonClick(v: View?, post: Post)
    }
}