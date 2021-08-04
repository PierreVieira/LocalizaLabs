package com.example.mymovieslist.ui.screens.bottomNavigation.more.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.mymovieslist.R

abstract class BaseDialog(private val dialogTag: String) : DialogFragment() {

    abstract fun setupOkButton()
    abstract fun setupCancelButton()
    abstract fun initializeCurrentRadioButton()
    abstract fun setupRadioButtonClicks()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.MyDialog)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateDialog(savedInstanceState)
    }

    protected fun setupButtons() {
        setupOkButton()
        setupCancelButton()
        setupRadioButton()
    }

    private fun setupRadioButton() {
        initializeCurrentRadioButton()
        setupRadioButtonClicks()
    }

    fun show(manager: FragmentManager?) {
        manager?.let {
            super.show(manager, dialogTag)
        } ?: throw IllegalStateException("Fragment manager cannot be null in $dialogTag")
    }

}