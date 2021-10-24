package com.yoti.android.cryptocurrencychallenge.presentation.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yoti.android.cryptocurrencychallenge.R
import com.yoti.android.cryptocurrencychallenge.databinding.FragmentMarketBinding
import com.yoti.android.cryptocurrencychallenge.presentation.Utils
import com.yoti.android.cryptocurrencychallenge.presentation.market.viewmodel.MarketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarketFragment : Fragment(), View.OnClickListener {
    val viewModel by viewModels<MarketViewModel>()
    private lateinit var binding: FragmentMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initUI() {
        binding.errorView.errorViewButton.setOnClickListener(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(BASE_ID)?.let {
            viewModel.load(it)
        }
        initUI()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.market.observe(viewLifecycleOwner, { market ->

            binding.textViewExchangeId.text = market.exchangeId
            binding.textViewPrice.text = market.price
            binding.textViewRank.text = market.rank
            binding.textViewDate.text = market.date
            binding.marketGroup.visibility = View.VISIBLE

        })

        viewModel.showEmpty.observe(viewLifecycleOwner, { showEmpty ->
            binding.emptyView.emptyViewMessage.text = getString(R.string.empty_market)
            binding.emptyView.root.visibility = if (showEmpty) View.VISIBLE else View.GONE
        })
        viewModel.showError.observe(viewLifecycleOwner, { cause ->
            cause?.let {
                binding.errorView.errorViewMessage.text =
                    Utils.resolveErrorMessage(ctx = requireContext(), cause = it)
                binding.marketGroup.visibility = View.GONE
                binding.errorView.root.visibility = View.VISIBLE
            } ?: run {
                binding.errorView.root.visibility = View.GONE
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.error_view_button -> {
                arguments?.getString(BASE_ID)?.let {
                    viewModel.load(it)
                }
            }
        }
    }

    companion object {
        const val BASE_ID = "BASE_ID"
    }
}