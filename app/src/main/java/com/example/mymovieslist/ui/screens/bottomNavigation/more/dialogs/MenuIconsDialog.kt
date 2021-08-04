package com.example.mymovieslist.ui.screens.bottomNavigation.more.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import com.example.mymovieslist.R
import com.example.mymovieslist.databinding.MenuIconsDialogBinding
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.ui.screens.bottomNavigation.more.MoreFragment

class MenuIconsDialog : BaseDialog(TAG) {

    private lateinit var binding: MenuIconsDialogBinding
    private lateinit var currentMenuOptionType: MenuOptionType

    companion object {

        private const val MENU_TYPE_KEY = "menuOptionType"
        private val TAG = MenuIconsDialog::class.java.simpleName

        fun newInstance(
            currentMenuOptionType: MenuOptionType,
        ): MenuIconsDialog {
            val dialog = MenuIconsDialog()
            val arguments = Bundle()
            arguments.putSerializable(MENU_TYPE_KEY, currentMenuOptionType)
            dialog.arguments = arguments
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            binding = MenuIconsDialogBinding.inflate(LayoutInflater.from(it))
            arguments?.let { bundle ->
                currentMenuOptionType = bundle.getSerializable(MENU_TYPE_KEY) as MenuOptionType
            } ?: throw IllegalStateException("Arguments cannot be null in $TAG")
            setupButtons()
            val builder = AlertDialog.Builder(it, R.style.DialogTheme)
            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null in $TAG")
    }

    override fun setupRadioButtonClicks() {
        binding.radioShowAlways.setOnClickListener {
            currentMenuOptionType = MenuOptionType.ALWAYS_SHOW
        }
        binding.radioShowNever.setOnClickListener {
            currentMenuOptionType = MenuOptionType.NEVER_SHOW
        }
        binding.radioShowOnlySelected.setOnClickListener {
            currentMenuOptionType = MenuOptionType.SHOW_ONLY_SELECTED
        }
    }

    override fun initializeCurrentRadioButton() {
        when (currentMenuOptionType) {
            MenuOptionType.ALWAYS_SHOW -> binding.radioShowAlways.isChecked = true
            MenuOptionType.NEVER_SHOW -> binding.radioShowNever.isChecked = true
            MenuOptionType.SHOW_ONLY_SELECTED -> binding.radioShowOnlySelected.isChecked = true
        }
    }

    override fun setupOkButton() {
        binding.yes.setOnClickListener {
            val parent = (parentFragment as MoreFragment)
            parent.viewModel.currentMenuOption.postValue(currentMenuOptionType)
            dismiss()
        }
    }

    override fun setupCancelButton() {
        binding.no.setOnClickListener {
            dismiss()
        }
    }

}