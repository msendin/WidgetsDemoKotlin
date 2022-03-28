package udl.eps.widgetsdemokotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WidgetsInitialActivity : AppCompatActivity() {

    var `in`: Intent? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun muestraBotones(clickedButton: View?) {
        `in` = Intent(this, ButtonActivity::class.java)
        startActivity(`in`)
    }

    /** Switches to the SpinnerActivity when the associated button is clicked.  */
    fun muestraSpinners(clickedButton: View?) {
        `in` = Intent(this, SpinnerActivity::class.java)
        startActivity(`in`)
    }

    fun muestraListView(clickedButton: View?) {
        `in` = Intent(this, ListViewActivityBis::class.java)
        startActivity(`in`)
    }

    fun muestraGridView(clickedButton: View?) {
        `in` = Intent(this, GridViewActivity::class.java)
        `in`!!.putExtra("contador", 2)
        startActivity(`in`)
    }
}