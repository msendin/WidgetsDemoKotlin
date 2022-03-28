package udl.eps.widgetsdemokotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import udl.eps.widgetsdemokotlin.databinding.SpinnersBinding
import java.util.*

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var mPlantillaMensajeItemSelected: String? = null
    private var isFirst = true
    private lateinit var binding:SpinnersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SpinnersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_spinner)

        binding.spinner1.onItemSelectedListener = this

        val futureAndroidVendors: List<String?> = getFutureAndroidVendors()
        val spinner2Adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            futureAndroidVendors
        )
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = spinner2Adapter
        binding.spinner2.onItemSelectedListener = this
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    /** Returns a slightly randomized List of names.
     * You can pass either a String[] or a List<String> to the ArrayAdapter<String> constructor.
     * Here I convert an array to a List so that I can randomize the order of the elements, in
     * order to demonstrate that Java can dynamically compute the elements to display in a Spinner.
     * If you have fixed elements, use XML instead of Java, as in the first Spinner example.
    </String></String> */
    private fun getFutureAndroidVendors(): List<String?> {
        val vendorArray = arrayOf("RIM", "Palm", "Nokia")
        val vendorList = Arrays.asList(*vendorArray)
        Collections.shuffle(vendorList)
        return vendorList
    }

        /** Shows a Toast for the selected item. Ignored the very first time,
         * which is when the item is selected on initial display, rather than
         * by user interaction.
         */
        override fun onItemSelected(
            spinner: AdapterView<*>, selectedView: View,
            selectedIndex: Int, id: Long
        ) {
            if (isFirst) {
                isFirst = false
            } else {
                val selection = spinner.getItemAtPosition(selectedIndex).toString()
                val message: String = String.format(mPlantillaMensajeItemSelected!!, selection)
                showToast(message)
            }
        }

        override fun onNothingSelected(spinner: AdapterView<*>?) {
            // Won't be invoked for a Spinner unless you programmatically remove items from the view
        }
}