package com.example.penjajahku

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.penjajahku.databinding.ItemRowColonizerBinding

class ListColonizerAdapter (private val listColonizer: ArrayList<Colonizer>) : RecyclerView.Adapter<ListColonizerAdapter.ListViewHolder>() {
      private lateinit var onItemClickCallback: OnItemClickCallback

      fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
      }

      override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
            val binding = ItemRowColonizerBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
            return ListViewHolder(binding)
      }

      override fun getItemCount(): Int {
            return listColonizer.size
      }

      override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val(name, description, photo) = listColonizer[position]
            Glide.with(holder.itemView.context).load(photo).transform(RoundedCorners(15)).into(holder.binding.imgItemPhoto)
            holder.binding.tvItemName.text = name
            holder.binding.tvItemDescription.text = description
            holder.itemView.setOnClickListener{
                  Toast.makeText(holder.itemView.context, "kamu memilih " + listColonizer[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            }

            holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listColonizer[holder.adapterPosition]) }
      } // revisi sebelumnya: onItemClickCallback.onItemClicked(listColonizer[holder.adapterPosition])

      interface OnItemClickCallback {
            fun onItemClicked(data: Colonizer)
      }

      class ListViewHolder(var binding: ItemRowColonizerBinding) : RecyclerView.ViewHolder(binding.root)
}
