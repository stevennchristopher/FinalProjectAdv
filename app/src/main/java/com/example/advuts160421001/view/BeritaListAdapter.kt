package com.example.advuts160421001.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advuts160421001.databinding.BeritaListItemBinding
import com.example.advuts160421001.model.Berita
import com.example.advuts160421001.model.BeritaWithUsername
import com.squareup.picasso.Picasso
import com.squareup.picasso.Callback

class BeritaListAdapter(val beritalist:ArrayList<BeritaWithUsername>)
    : RecyclerView.Adapter<BeritaListAdapter.BeritaViewHolder>(), ReadButtonClick
{
    class BeritaViewHolder(var databinding: BeritaListItemBinding)
        : RecyclerView.ViewHolder(databinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val binding = BeritaListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return BeritaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.databinding.berita = beritalist[position]
        holder.databinding.listener = this
        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(beritalist[position].urlFoto)
            .into(holder.databinding.imgBerita, object:Callback {
                override fun onSuccess() {
                    holder.databinding.progressImage.visibility = View.INVISIBLE
                    holder.databinding.imgBerita.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    Log.e("picasso_error", e.toString())
                }
            })
//
//        holder.binding.txtTitleBerita.text = beritalist[position].judul
//        holder.binding.txtUsernameBerita.text = "@" + beritalist[position].username_pembuat
//        holder.binding.txtDeskripsiBerita.text = beritalist[position].deskripsi
//
//        holder.binding.btnRead.setOnClickListener{
//            val action = HomeFragmentDirections.actionBeritaDetails(beritalist[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    override fun getItemCount(): Int {
        return beritalist.size
    }

    fun updateBeritaList(newBeritaList: List<BeritaWithUsername>) {
        beritalist.clear()
        beritalist.addAll(newBeritaList)
        notifyDataSetChanged()
    }

    override fun onReadButtonClick(v: View) {
        val id = v.tag.toString().toInt()
        val action = HomeFragmentDirections.actionBeritaDetails(id.toString())
        Navigation.findNavController(v).navigate(action)
    }
}