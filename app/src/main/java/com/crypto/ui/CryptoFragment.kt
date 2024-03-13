package com.crypto.ui

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.crypto.base.BaseFragment
import com.crypto.databinding.FragmentCryptoBinding
import com.crypto.model.crypto.Data
import com.crypto.utils.Constants.API_KEY
import com.crypto.utils.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoFragment : BaseFragment<FragmentCryptoBinding, CryptoViewModel>(FragmentCryptoBinding::inflate) {

    private var favoriteItemClickListener: ((Data) -> Unit)? = null
    private val favoriViewModel: FavoriViewModel by viewModels()

    override val viewModel: CryptoViewModel by viewModels()

    override fun onCreateFinished() {
        viewModel.getData(API_KEY, LIMIT)
    }

    override fun initializeListeners() {
    }

    override fun observeEvents() {
        with(viewModel) {
            cryptoResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.data?.let { data -> setRecycler(data) }
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleView(it)
            })
            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })
        }
    }

    private fun setRecycler(data: List<Data?>) {
        val mAdapter = CryptoRecyclerAdapter(object : ItemClickListener {
            override fun onItemClick(coin: Data) {
                coin.isFavorite = !coin.isFavorite
                favoriteItemClickListener?.invoke(coin)
                favoriViewModel.addToFavori(coin)
            }
        })
        binding.rvCrypto.adapter = mAdapter
        mAdapter.setCoinsList(data.filterNotNull())
    }

    fun setFavoriteItemClickListener(listener: (Data) -> Unit) {
        favoriteItemClickListener = listener
    }

    private fun handleView(isLoading: Boolean) {
        binding.rvCrypto.isVisible = !isLoading
        binding.pbCrypto.isVisible = isLoading
    }
}
