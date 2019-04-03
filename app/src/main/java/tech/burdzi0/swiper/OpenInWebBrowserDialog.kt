package tech.burdzi0.swiper

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.widget.Toast

class OpenInWebBrowserDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            createAlertDialog(it)
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun createAlertDialog(activity: FragmentActivity): AlertDialog? {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(R.string.open_in_browser)
            .setPositiveButton(R.string.ok) { _, _ ->
                Toast.makeText(context, "Otwieram w przeglądarce", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton(R.string.cancel) { _, _ ->
                dialog.cancel()
            }
            .setTitle("Strona Sesji Linuksowej")
        return builder.create()
    }
}
