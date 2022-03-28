package udl.eps.widgetsdemokotlin

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class ListViewActivityBis : ListActivity() {

    private var mPlantillaMensajeItemSelected: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview)

        val futureAndroidVendors: List<String?> = getFutureAndroidVendors()
        val listAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_single_choice,
            futureAndroidVendors
        )

        setListAdapter(listAdapter)
        registerForContextMenu(listView)
    }


    private fun getFutureAndroidVendors(): List<String?> {
        val vendorArray = arrayOf("RIM", "Palm", "Nokia")
        val vendorList = Arrays.asList(*vendorArray)
        vendorList.shuffle()
        return vendorList
    }


    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }


    override fun onListItemClick(
        listv: ListView, selectedView: View?,
        position: Int, id: Long
    ) {
        //val selection = getListAdapter().getItem(position).toString()
        val selection = listv.getItemAtPosition(position).toString()
        val message = String.format(mPlantillaMensajeItemSelected!!, selection)
        showToast(message)
    }
}