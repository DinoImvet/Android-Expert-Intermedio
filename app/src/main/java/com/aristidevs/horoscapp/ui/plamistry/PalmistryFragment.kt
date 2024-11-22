package com.aristidevs.horoscapp.ui.plamistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aristidevs.horoscapp.R
import com.aristidevs.horoscapp.databinding.FragmentPalmistryBinding


class PalmistryFragment : Fragment() {
    private lateinit var _binding: FragmentPalmistryBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}