package com.abhijeet.mvvmsample.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.mvvmsample.R
import com.abhijeet.mvvmsample.databinding.ListItemsNotesBinding
import com.abhijeet.mvvmsample.model.localDB.entity.Notes
import com.abhijeet.mvvmsample.view_model.HomeNotesListFragmentViewModel


open class HomeNotesListRVAdapter(var homeNotesListFragmentViewModel: HomeNotesListFragmentViewModel) : RecyclerView.Adapter<HomeNotesListRVAdapter.MyViewHolder>() {

    private var employees: List<Notes>? = null


    fun setNotesListList(employees: List<Notes>?) {
        this.employees = employees
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val employeeListItemBinding: ListItemsNotesBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.list_items_notes,viewGroup,false)
        return MyViewHolder(employeeListItemBinding,homeNotesListFragmentViewModel)
    }

    override fun getItemCount(): Int {
        return if (employees != null) employees!!.size else 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentStudent = employees!![position]
        holder.employeeListItemBinding.notes = currentStudent
    }

    class MyViewHolder(listItemBinding: ListItemsNotesBinding,homeNotesListFragmentViewModel: HomeNotesListFragmentViewModel) : RecyclerView.ViewHolder(listItemBinding.getRoot()) {
        val employeeListItemBinding: ListItemsNotesBinding
        init {
            listItemBinding.viewModel=homeNotesListFragmentViewModel
            employeeListItemBinding = listItemBinding
        }
    }
}