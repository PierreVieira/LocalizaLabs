package com.example.mymovieslist.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.mymovieslist.R

abstract class BaseDialog : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.MyDialog)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateDialog(savedInstanceState)
    }
}