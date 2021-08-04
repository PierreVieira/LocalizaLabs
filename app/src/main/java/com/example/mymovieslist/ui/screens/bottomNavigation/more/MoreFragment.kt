package com.example.mymovieslist.ui.screens.bottomNavigation.more

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.viewModels
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.FragmentMoreBinding
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.ui.screens.bottomNavigation.more.dialogs.ColorThemeDialog
import com.example.mymovieslist.ui.main.MainActivity
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseNavigationFragment
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.MoreAdapter
import com.example.mymovieslist.ui.screens.bottomNavigation.more.dialogs.MenuIconsDialog
import com.example.mymovieslist.utils.Mapper

class MoreFragment : BaseNavigationFragment(FragmentNavigationType.MORE) {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var requiredContext: Context
    val viewModel: MoreViewModel by viewModels()
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requiredContext = requireContext()
        mainActivity = requireActivity() as MainActivity
        setupRecyclerView()
        setupCurrentMenuOptionObserver()
    }

    private fun setupCurrentMenuOptionObserver() {
        viewModel.currentMenuOption.observe(viewLifecycleOwner, { newMenuOptionType ->
            updateBottomNavigationLabel(newMenuOptionType)
            updateAdapterMenuDescription(newMenuOptionType)
        })
    }

    private fun updateAdapterMenuDescription(newMenuOptionType: MenuOptionType) {
        (binding.recyclerView.adapter as MoreAdapter)
            .setMenuNavigationOptionType(newMenuOptionType)
    }

    private fun updateBottomNavigationLabel(newMenuOptionType: MenuOptionType) {
        mainActivity.updateVisibilityIconsOnBottomNavigation(
            Mapper.mapMenuOptionTypeToNavigationLabel(
                newMenuOptionType
            )
        )
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
            ColorThemeDialog.newInstance(viewModel.getCurrentTheme()) { themeType ->
                changeThemeListener(themeType)
                setupRecyclerView()
            }.show(mainActivity.supportFragmentManager)
        }

        override fun showChangeMenuConfigsDialog() {
            //TODO: Exibir dialog aqui, essa lógica do option é só para teste interno
            MenuIconsDialog.newInstance(
                MySharedPreferences.getLastMenuVisibilityMode()
            ).show(childFragmentManager)
        }
    }
}