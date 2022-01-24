package com.arbaelbarca.grawgames.ui.view.fragment.home

import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.arbaelbarca.grawgames.R
import com.arbaelbarca.grawgames.data.base.BaseFragmentBinding
import com.arbaelbarca.grawgames.databinding.FragmentHomeBinding
import com.arbaelbarca.grawgames.presentation.model.response.ResponseLatesGames
import com.arbaelbarca.grawgames.presentation.viewmodel.ViewModelHome
import com.arbaelbarca.grawgames.ui.adapter.AdapterLatesGames
import com.arbaelbarca.grawgames.utils.*
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragmentBinding<FragmentHomeBinding>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var homeBinding: FragmentHomeBinding
    val viewModelHome: ViewModelHome by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setupView(binding: FragmentHomeBinding) {
        homeBinding = binding
        initial()
    }

    private fun initial() {
        initSearchLatesgames()
        initCallApi()
        initObserver()

    }

    private fun initSearchLatesgames() {
        homeBinding.edSearchGames.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                callSearchGames(textView.text.toString());
            }
            true
        }
    }

    private fun callSearchGames(textSearch: String) {
        val mutableMap = mutableMapOf(
            "key" to ConsVar.API_KEY,
            "page_size" to "10",
            "search" to textSearch,
            "platforms" to "4",
            "page" to "1"
        )
        viewModelHome.callApiSearchLatesGames(mutableMap)
    }

    private fun initObserver() {
        viewModelHome.observerGetLatesGames()
            .observe(viewLifecycleOwner, {
                when (it) {
                    is UiState.Loading -> {
                        hideView(homeBinding.rvListLatesGames)
                        showView(homeBinding.pbList)
                    }
                    is UiState.Success -> {
                        showView(homeBinding.rvListLatesGames)
                        hideView(homeBinding.pbList)
                        val dataItem = it.data
                        initAdapter(dataItem)
                    }
                    is UiState.Failure -> {
                        hideView(homeBinding.rvListLatesGames)
                        hideView(homeBinding.pbList)
                        it.throwable.printStackTrace()
                        showToast("Error", requireContext())
                    }
                }

            })
    }

    private fun initAdapter(dataItem: ResponseLatesGames?) {
        val adapterLatesGames =
            AdapterLatesGames(dataItem?.results as MutableList<ResponseLatesGames.ResultGames>)
        setRvAdapterVertikalDefault(homeBinding.rvListLatesGames, adapterLatesGames)
    }

    private fun initCallApi() {
        val mutableMap = mutableMapOf(
            "key" to ConsVar.API_KEY,
            "page_size" to "10",
            "ordering" to "-released",
            "platforms" to "4",
            "page" to "1",
            "dates" to "2021-12-01,2021-12-31",
        )
        viewModelHome.callApiLatesGames(mutableMap)

    }
}