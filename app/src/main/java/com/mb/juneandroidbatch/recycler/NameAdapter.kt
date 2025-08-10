package com.mb.juneandroidbatch.recycler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mb.juneandroidbatch.R

class NameAdapter(private  val nameList : List<NameItem>) : RecyclerView.Adapter<NameAdapter.MyViewHolder>() {




    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val nameText = item.findViewById<TextView>(R.id.text)
        val rollno =  item.findViewById<TextView>(R.id.roll_no_tv)
    }

    /** * Create new views (invoked by the layout manager)
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate((R.layout.name_item), parent, false)
        return MyViewHolder(view)
    }

    // return count of items in the list
    override fun getItemCount(): Int = nameList.size


    /** * Replace the contents of a view (invoked by the layout manager)
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val nameItem = nameList[position]
        holder.nameText.text = nameItem.name ?: "No Name"
        holder.rollno.text = (position + 1).toString()
    }


}