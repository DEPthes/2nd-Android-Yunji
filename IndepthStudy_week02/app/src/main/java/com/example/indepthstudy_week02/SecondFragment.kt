package com.example.indepthstudy_week02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indepthstudy_week02.databinding.FragmentSecondBinding

class SecondFragment(val layout:ViewGroup) : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSecondBinding.inflate(inflater, layout, false)
        val view = binding.root

        binding.btnSave.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            binding.user = User(firstName, lastName)
        }
        return view
    }

}