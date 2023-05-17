package com.example.anotaciones3.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anotaciones3.R
import com.example.anotaciones3.databinding.ItemNotasBinding
import com.example.anotaciones3.models.Tareas


class TareasAdapter(private val dataSet: List<Tareas>?) :
    RecyclerView.Adapter<TareasAdapter.ViewHolder>() {



    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_notas, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element


        val item: Tareas? = dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemNotasBinding.bind(view)
        var contexto = view.context
        fun enlazarItem(t: Tareas) {
            binding.tvTarea.text = "${t.tarea}"
            binding.chkFinalizado.isChecked = false

            binding.root
        }

    }




}
