package com.example.appsepatu.view.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appsepatu.R
import com.example.appsepatu.model.ModelDatabase
import com.example.appsepatu.utils.FunctionHelper.rupiahFormat
import kotlinx.android.synthetic.main.list_item_riwayat.view.*



class RiwayatAdapter(
    var mContext: Context,
    modelInputList: MutableList<ModelDatabase>,
    adapterCallback: RiwayatAdapterCallback
) : RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {

    var modelDatabase: MutableList<ModelDatabase>
    var mAdapterCallback: RiwayatAdapterCallback

    fun setDataAdapter(items: List<ModelDatabase>) {
        modelDatabase.clear()
        modelDatabase.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_riwayat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: ModelDatabase = modelDatabase[position]

        holder.tvNama.setText(data.namaPengguna)
        holder.tvDate.setText(data.tanggal)
        holder.tvKategori.text = "Sepatu " + data.jenisSepatu
        holder.tvJumlah.text = "Jumlah : " + data.jumlah.toString() + " Pcs"
        holder.tvSaldo.text = "Pendapatan : " + rupiahFormat(data.harga)

        if (data.jumlah < 5) {
            holder.tvStatus.setTextColor(ContextCompat.getColor(mContext, R.color.red))
            holder.tvStatus.text = "Masih dalam proses"
        } else {
            holder.tvStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary))
            holder.tvStatus.text = "Sudah di konfirmasi"
        }
    }

    override fun getItemCount(): Int {
        return modelDatabase.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.tvNama
        var tvDate: TextView = itemView.tvDate
        var tvKategori: TextView = itemView.tvKategori
        var tvJumlah: TextView = itemView.tvJumlah
        var tvSaldo: TextView = itemView.tvSaldo
        var tvStatus: TextView = itemView.tvStatus
        var imageDelete: ImageView = itemView.imageDelete

        init {
            imageDelete.setOnClickListener { view: View? ->
                val modelLaundry: ModelDatabase = modelDatabase[adapterPosition]
                mAdapterCallback.onDelete(modelLaundry)
            }
        }
    }

    interface RiwayatAdapterCallback {
        fun onDelete(modelDatabase: ModelDatabase?)
    }

    init {
        modelDatabase = modelInputList
        mAdapterCallback = adapterCallback
    }

}