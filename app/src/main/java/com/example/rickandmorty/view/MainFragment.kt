package com.example.rickandmorty.view

import android.graphics.Path
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.RMViewModel
import com.example.rickandmorty.adapter.RMAdapter
import com.example.rickandmorty.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<RMViewModel>()
    private val RMAdapter by lazy { RMAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= FragmentMainBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getChars()
        viewModel.characters.observe(viewLifecycleOwner){
//            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment())
            viewModel.characters.value?.let { it1 -> RMAdapter.updateChars(it1.results) }
            Log.d("pausechamp", viewModel.characters.value?.results.toString())
        }
    }

}