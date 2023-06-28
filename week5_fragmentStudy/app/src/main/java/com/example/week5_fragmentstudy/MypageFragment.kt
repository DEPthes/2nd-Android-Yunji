package com.example.week5_fragmentstudy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.week5_fragmentstudy.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    lateinit var launcher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater,container,false)
        var view = binding.root

        val userName = (requireActivity() as MainActivity).getUserName()
        if(userName!=null){
            binding.userName.text = userName
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == Activity.RESULT_OK) {
                var bundle = Bundle()
                var newUserName = result.data?.getStringExtra("afterName")
                bundle.putString("userName",newUserName)
                (requireActivity() as MainActivity).setUserName(newUserName)
                binding.userName.text = newUserName
            }
        }
        binding.buttonEditIdCard.setOnClickListener{
            val intent = Intent(requireActivity(), EditidcardActivity::class.java)
            val userName = binding.userName.text.toString()
            intent.putExtra("beforeName", userName)
            launcher.launch(intent)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}