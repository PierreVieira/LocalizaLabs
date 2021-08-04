package com.example.mymovieslist.ui.screens.bottomNavigation.more.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import com.example.mymovieslist.R
import com.example.mymovieslist.databinding.ChangeThemeDialogBinding
import com.example.mymovieslist.enums.ThemeType

class ColorThemeDialog : BaseDialog(TAG) {

    private lateinit var binding: ChangeThemeDialogBinding
    private lateinit var currentThemeType: ThemeType
    private var changeTheme: ((themeType: ThemeType) -> Unit)? = null

    companion object {
        private const val THEME_TYPE_KEY = "themeType"
        private val TAG = ColorThemeDialog::class.java.simpleName
        fun newInstance(
            currentThemeType: ThemeType,
            changeTheme: (themeType: ThemeType) -> Unit
        ): ColorThemeDialog {
            val dialog = ColorThemeDialog()
            val arguments = Bundle()
            arguments.putSerializable(THEME_TYPE_KEY, currentThemeType)
            dialog.arguments = arguments
            dialog.changeTheme = changeTheme
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            binding = ChangeThemeDialogBinding.inflate(LayoutInflater.from(it))
            arguments?.let { bundle ->
                currentThemeType = bundle.getSerializable(THEME_TYPE_KEY) as ThemeType
            } ?: throw IllegalStateException("Arguments cannot be null in $TAG")
            setupButtons()
            val builder = AlertDialog.Builder(it, R.style.DialogTheme)
            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null in $TAG")
    }

    override fun setupRadioButtonClicks() {
        binding.radioDark.setOnClickListener {
            currentThemeType = ThemeType.DARK
        }
        binding.radioLight.setOnClickListener {
            currentThemeType = ThemeType.LIGHT
        }
        binding.radioSystem.setOnClickListener {
            currentThemeType = ThemeType.SYSTEM
        }
    }

    override fun initializeCurrentRadioButton() {
        when (currentThemeType) {
            ThemeType.LIGHT -> binding.radioLight.isChecked = true
            ThemeType.DARK -> binding.radioDark.isChecked = true
            ThemeType.SYSTEM -> binding.radioSystem.isChecked = true
        }
    }

    override fun setupOkButton() {
        binding.yes.setOnClickListener {
            dismiss()
            changeTheme?.invoke(currentThemeType)
        }
    }

    override fun setupCancelButton() {
        binding.no.setOnClickListener {
            dismiss()
        }
    }

}