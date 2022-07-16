# List-Adapter-DiffUtil

-> notifyDataSetChanged is costly.

-> Whenever invoked it updates each and every RecyclerView row. This is costly.

-> DiffUtil does not call each and every row. Instead, it updates only those rows that are different between the Lists of values.

1. DiffUtil  :
DiffUtil is a utility class that calculates the difference between two lists.

It can be used to calculate updates for a RecyclerView Adapter.

2. ListAdapter :
ListAdapter is a simple Adapter, in which by-default DiffUtil is implemented & executes difference between Lists on a background thread.

3.RecyclerView with DiffUtil is a way to improve the performance of your app.

4. List Adapter implements diffUtil for you and runs the diffutil algorithm on the background thread. 

5. DiffUtil compares two lists on the background thread and provides the differences between the two lists. 

6. List Adapter class inherits RecyclerView.Adapter class and includes diffutil implementation. 

7. RecyclerView Performance can be optimized using DiffUtil and List Adapter. 

8. Use submitlist method to provide the new list to your recycler view and it will only update the items that are changed, 
the rest of the items remain the same. 

Before:

class ProgrammingAdapter : ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>() 

//Inside the constructor we have to pass the DiffUtil implementation i.e how it will compare the 2 list

 { 
 
}


After:

class ProgrammingAdapter : ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(Diffutil()) 
{

    class Diffutil :  DiffUtil.ItemCallback<ProgrammingItem>() 
{

        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean
        
        {

            return oldItem.id == newItem.id
        }

        // It will check the content are same or not
        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {

           return oldItem == newItem
        }
    }
}
