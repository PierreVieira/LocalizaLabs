package com.example.mymovieslist.ui.screens.bottomNavigation.more

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymovieslist.R
import com.example.mymovieslist.databinding.FragmentMoreBinding
import com.example.mymovieslist.ui.dialog.ChangeColorThemeDialog
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.MoreAdapter

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var headerView: View
    private lateinit var requiredContext: Context
    private val viewModel: MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        headerView = inflater.inflate(R.layout.default_header_fragment, container, false)
        binding = FragmentMoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requiredContext = requireContext()
        headerView.findViewById<TextView>(R.id.title).text = resources.getText(R.string.more)
        binding.customHeaderView.setView(headerView)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = MoreAdapter(requiredContext, viewModel.dataList, createSettingsListener())
        }
    }

    private fun createSettingsListener() = object : SettingsListener {
        override fun showChangeThemeDialog() {
            ChangeColorThemeDialog {
                changeTheme()
            }.show(activity?.supportFragmentManager)
        }

        override fun showChangeMenuConfigsDialog() {
//            TODO("Not yet implemented")
        }
    }

    fun changeTheme() {
        when (requiredContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> setThemeColors(AppCompatDelegate.MODE_NIGHT_NO)
            Configuration.UI_MODE_NIGHT_NO -> setThemeColors(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun setThemeColors(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}