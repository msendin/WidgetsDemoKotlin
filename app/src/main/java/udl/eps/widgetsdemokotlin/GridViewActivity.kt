package udl.eps.widgetsdemokotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class GridViewActivity : AppCompatActivity(), OnItemClickListener {
    private var mPlantillaMensajeItemSelected: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gridview)
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_gridview)

        val gridv = findViewById<GridView>(R.id.gridview)
        val futureAndroidVendors: List<String?> = getFutureAndroidVendors()
        val gridAdapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, futureAndroidVendors)
        gridv.adapter = gridAdapter
        gridv.onItemClickListener = this
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }


    private fun getFutureAndroidVendors(): List<String?> {
        val vendorArray = arrayOf(
            "Acer",
            "Dell",
            "HTC",
            "Huawei",
            "Kyocera",
            "LG",
            "Motorola",
            "Nexus",
            "Samsung",
            "Sony Ericsson",
            "T-Mobile",
            "Neptune"
        )
        val vendorList = Arrays.asList(*vendorArray)
        Collections.shuffle(vendorList)
        return vendorList
    }


        override fun onItemClick(
            gridv: AdapterView<*>, selectedView: View,
            selectedIndex: Int, id: Long
        ) {
            val selection = gridv.getItemAtPosition(selectedIndex).toString()
            val message: String = kotlin.String.format(mPlantillaMensajeItemSelected!!, selection)
            showToast(message)
        }
}