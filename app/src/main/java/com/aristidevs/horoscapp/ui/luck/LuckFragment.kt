package com.aristidevs.horoscapp.ui.luck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aristidevs.horoscapp.R
import com.aristidevs.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private lateinit var _binding: FragmentLuckBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}