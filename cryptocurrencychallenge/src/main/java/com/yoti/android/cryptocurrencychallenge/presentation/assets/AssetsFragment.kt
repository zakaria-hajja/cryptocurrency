package com.yoti.android.cryptocurrencychallenge.presentation.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yoti.android.cryptocurrencychallenge.R
import com.yoti.android.cryptocurrencychallenge.databinding.FragmentAssetsBinding
import com.yoti.android.cryptocurrencychallenge.presentation.Utils
import com.yoti.android.cryptocurrencychallenge.presentation.assets.viewmodel.AssetsViewModel
import com.yoti.android.cryptocurrencychallenge.presentation.market.MarketFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetsFragment : Fragment(), View.OnClickListener {

    val viewModel by viewModels<AssetsViewModel>()

    lateinit var adapter: AssetsAdapter
    lateinit var navController: NavController
    private lateinit var binding: FragmentAssetsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssetsBinding.inflate(layoutInflater)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {

        viewModel.let {
            it.assets.observe(viewLifecycleOwner, { assets ->
                adapter.set(assets)
                binding.recyclerViewAssets.visibility = View.VISIBLE
            })
            viewModel.showError.observe(viewLifecycleOwner, { cause ->
                cause?.let {
                    binding.errorView.errorViewMessage.text =
                        Utils.resolveErrorMessage(ctx = requireContext(), cause = it)
                    binding.recyclerViewAssets.visibility = View.GONE
                    binding.errorView.root.visibility = View.VISIBLE
                } ?: run {
                    binding.errorView.root.visibility = View.GONE
                }

            })

            it.isLoading.observe(viewLifecycleOwner, { isLoading ->
                binding.progressBarAssets.visibility = if (isLoading) View.VISIBLE else View.GONE
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initUi()
    }

    private fun initUi() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.load()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        adapter = AssetsAdapter(mutableListOf()) { asset ->
            val args = bundleOf(MarketFragment.BASE_ID to asset.id)
            navController.navigate(
                R.id.action_assetsFragment_to_marketFragment, args
            )
        }

        binding.recyclerViewAssets.adapter = this@AssetsFragment.adapter
        binding.errorView.errorViewButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.error_view_button -> {
                viewModel.load()
            }
        }
    }
}