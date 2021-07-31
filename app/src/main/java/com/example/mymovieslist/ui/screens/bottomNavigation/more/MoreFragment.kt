package com.example.mymovieslist.ui.screens.bottomNavigation.more

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.FragmentMoreBinding
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.ui.dialogs.ChangeColorThemeDialog
import com.example.mymovieslist.ui.main.MainActivity
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseNavigationFragment
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.MoreAdapter

class MoreFragment : BaseNavigationFragment(FragmentNavigationType.MORE) {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var headerView: View
    private lateinit var requiredContext: Context
    private val viewModel: MoreViewModel by viewModels()
    private var changeThemeSubtitleTextView: AppCompatTextView? = null

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
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = this@MoreFragment.getAdapter()
        }
    }

    private fun getAdapter() =
        MoreAdapter(requiredContext, viewModel.dataList, createSettingsListener())

    fun changeThemeListener(themeType: ThemeType) {
        val activity = requireActivity() as MainActivity
        activity.setTheme(themeType)
        viewModel.saveCurrentTheme(themeType)
    }

    private fun createSettingsListener() = object : SettingsListener {
        override fun showChangeThemeDialog(changeThemeSubtitleTextView: AppCompatTextView) {
            ChangeColorThemeDialog.newInstance(viewModel.getCurrentTheme()) { themeType ->
                changeThemeListener(themeType)
                setupRecyclerView()
            }.show(activity?.supportFragmentManager)
            this@MoreFragment.changeThemeSubtitleTextView = changeThemeSubtitleTextView
        }

        override fun showChangeMenuConfigsDialog() {
//            TODO("Not yet implemented")
        }
    }

}