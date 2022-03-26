package udl.eps.widgetsdemokotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ListViewActivity : AppCompatActivity(), OnItemClickListener {

    private var mPlantillaMensajeItemSelected: String? = null
    private var lv: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview)
        lv = findViewById(R.id.listview)

        val futureAndroidVendors: List<String?> = getFutureAndroidVendors()
        val listAdapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            android.R.layout.simple_list_item_single_choice,
            futureAndroidVendors
        )
        lv!!.setAdapter(listAdapter)
        lv!!.setOnItemClickListener(this)
    }

    private fun getFutureAndroidVendors(): List<String?> {
        val vendorArray = arrayOf("RIM", "Palm", "Nokia")
        val vendorList = Arrays.asList(*vendorArray)
        Collections.shuffle(vendorList)
        return vendorList
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(
        listv: AdapterView<*>, selectedView: View?,
        position: Int, id: Long
    ) {
        val selection = listv.getItemAtPosition(position).toString()
        val message = String.format(mPlantillaMensajeItemSelected!!, selection)
        showToast(message)
    }
}