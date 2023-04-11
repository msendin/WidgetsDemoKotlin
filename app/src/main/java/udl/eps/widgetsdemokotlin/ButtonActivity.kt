package udl.eps.widgetsdemokotlin


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import udl.eps.widgetsdemokotlin.databinding.ButtonsBinding


class ButtonActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    private var mPlantillaMensajeBoton: String? = null
    private var mPlantillaMensajeImageBoton: String? = null
    private var mPlantillaMensajeCheck: String? = null
    private var mPlantillaMensajeToggleBoton: String? = null

    private var mLastChecked: RadioButton? = null
    private var mPlantillaMensajeNuevaSeleccion: String? = null
    private var mPlantillaMensajeSeleccionCambiada: String? = null

    private lateinit var binding: ButtonsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ButtonsBinding.inflate(layoutInflater)
        val view = binding.getRoot()
        setContentView(view)

        mPlantillaMensajeBoton = getString(R.string.plantilla_mensaje_boton)
        mPlantillaMensajeCheck = getString(R.string.plantilla_mensaje_check)
        mPlantillaMensajeImageBoton = getString(R.string.plantilla_mensaje_imagebutton)
        mPlantillaMensajeToggleBoton = getString(R.string.plantilla_mensaje_togglebutton)
        mPlantillaMensajeNuevaSeleccion = getString(R.string.plantilla_mensaje_nuevaseleccion)
        mPlantillaMensajeSeleccionCambiada =
            getString(R.string.plantilla_mensaje_seleccioncambiada)
        binding.radioGroup.setOnCheckedChangeListener(this)
     }

    /** Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     * ImageButtons do not have text, and are not subclasses of Button, so you
     * cannot pass an ImageButton to this method.
     * You need the muestraInfoImageButton method.
     */
    fun muestraTextoBoton(clickedButton: View) {
        if (clickedButton.id == R.id.botonhola || clickedButton.id == R.id.botonadios || clickedButton.id == R.id.botonchao) {
            val button = clickedButton as Button
            textoBoton(button)
        } else if (clickedButton.id == R.id.checkhola || clickedButton.id == R.id.checkadios || clickedButton.id == R.id.checkchao) {
            val check = clickedButton as CheckBox
            textoCheck(check)
        }
    }

    fun textoBoton(b: Button) {
        val text = b.text
        val message = String.format(mPlantillaMensajeBoton!!, text)
        showToast(message)
    }

    fun textoCheck(check: CheckBox) {
        val text = check.text
        val status: String
        status = if (check.isChecked) "Habilitado" else "Deshabilitado"
        val message = String.format(mPlantillaMensajeCheck!!, text, status)
        showToast(message)
    }

    fun muestraInfoImageB(clickedImageButton: View) {
        var imageString = ""
        val imgb = clickedImageButton as ImageButton
        when (imgb.id) {
            R.id.imagebutton1 -> imageString = getString(R.string.info_imagebutton_1)
            R.id.imagebutton2 -> imageString = getString(R.string.info_imagebutton_2)
            R.id.imagebutton3 -> imageString = getString(R.string.info_imagebutton_3)
            R.id.imagebutton4 -> imageString = getString(R.string.info_imagebutton_4)
            R.id.imagebutton5 -> imageString = getString(R.string.info_imagebutton_5)
            R.id.imagebutton6 -> imageString = getString(R.string.info_imagebutton_6)
        }
        val message = String.format(mPlantillaMensajeImageBoton!!, imageString)
        showToast(message)
    }

    /** Makes a Toast showing whether you turned ToggleButton on or off. Also
     * shows the resultant text (label).
     */
    fun muestraInfoToggleBoton(clickedToggleButton: View) {
        val toggleButton = clickedToggleButton as ToggleButton
        val status: String
        status = if (toggleButton.isChecked) {
            "ON"
        } else {
            "OFF"
        }
        val label = toggleButton.text
        val message = String.format(mPlantillaMensajeToggleBoton!!, status, label)
        showToast(message)
    }


    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
            val newChecked: RadioButton = findViewById(checkedId)
            val message: String
            message = if (mLastChecked == null) {
                String.format(
                    mPlantillaMensajeNuevaSeleccion!!,
                    newChecked.text
                )
            } else {
                String.format(
                    mPlantillaMensajeSeleccionCambiada!!,
                    newChecked.text,
                    mLastChecked!!.text
                )
            }
            mLastChecked = newChecked
            showToast(message)
        }
}