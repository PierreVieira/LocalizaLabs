package com.example.mymovieslist.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.mymovieslist.R

class ChangeColorThemeDialog(private val changeThemeAction: () -> Unit) : BaseDialog() {

    companion object {
        private val TAG = ChangeColorThemeDialog::class.java.simpleName
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val view = it.layoutInflater.inflate(R.layout.change_theme_dialog, null)
            setupClickButtons(view)
            val builder = AlertDialog.Builder(it, R.style.DialogTheme)
            builder.setView(view)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null in $TAG")
    }

    private fun setupClickButtons(view: View?) {
        view?.let {
            val okButton = it.findViewById<TextView>(R.id.yes)
            val noButton = it.findViewById<TextView>(R.id.no)
            okButton.setOnClickListener {
                dismiss()
                changeThemeAction.invoke()
            }
            noButton.setOnClickListener {
                dismiss()
            }
        }
    }

    fun show(manager: FragmentManager?) {
        manager?.let {
            super.show(manager, TAG)
        } ?: throw IllegalStateException("Fragment manager cannot be null in $TAG")
    }
}