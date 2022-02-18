package com.example.rickandmorty.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.RMViewModel
import com.example.rickandmorty.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<RMViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var charInfo = viewModel.characterDetail.value
        if (charInfo != null) {
            binding.CharName.text = charInfo.name
            Glide.with(binding.charImgView).load(charInfo.image).into(binding.charImgView)
            binding.location.text = "Located in: " +charInfo.location.name
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}