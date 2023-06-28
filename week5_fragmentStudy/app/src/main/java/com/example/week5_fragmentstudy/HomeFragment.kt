package com.example.week5_fragmentstudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.week5_fragmentstudy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        var view = binding.root

        val userName = (requireActivity() as MainActivity).getUserName()
        if(userName!=null){
            binding.userName.text = "신입 개발자 \n$userName 님"
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}