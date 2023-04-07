package com.example.nutriscore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Fragment 1 : Liste des produits
class ListFragment : Fragment() {

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_list,
            container, false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = List(100) {
            "Position ${it + 1}"
        }

        view.findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter(list, object : OnProductClickListener {
                override fun onProductClicked(position: String) {
                    // TODO Ouvrir l'écran
                    findNavController().navigate(
                        ListFragmentDirections.actionListFragmentToDetailsFragment()
                    )

                }
            })
        }
    }
}

//Contenu
class ListAdapter(private val listOfPositions: List<String>,
                  val listener: OnProductClickListener,
) : RecyclerView.Adapter<PositionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.details_list, parent, false),
            listener,
        )
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.updateCell(listOfPositions[position])
    }

    override fun getItemCount(): Int {
        return listOfPositions.size
    }

}


//Capture la position sur laquelle on a cliqué
class PositionViewHolder(v: View, val listener: OnProductClickListener) : RecyclerView.ViewHolder(v) {

    private val text : TextView = v.findViewById(R.id.item_text)

    fun updateCell(position: String) {
        itemView.setOnClickListener {
            listener.onProductClicked(position)
        }

        text.text = position
    }

}

interface OnProductClickListener {
    fun onProductClicked(position: String)
}