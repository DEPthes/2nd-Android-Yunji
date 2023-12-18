package com.example.indepthstudy_week4_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.indepthstudy_week4_navigation.databinding.FragmentExhibitionBinding

class ExhibitionFragment : Fragment() {

    private var _binding: FragmentExhibitionBinding? = null
    private val binding get() = _binding!!
    private val viewModel:MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExhibitionBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnGoPoster.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_exhibitionFragment_to_exhibitionPosterFragment)
        }
        binding.btnGoReview.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_exhibitionFragment_to_reviewFragment)
        }
        binding.btnGoWriting.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_exhibitionFragment_to_writingReviewFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}