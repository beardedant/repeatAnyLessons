package com.example.repeatanylessons.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.repeatanylessons.R
import com.example.repeatanylessons.databinding.FragmentMainBinding
import com.example.repeatanylessons.vewModel.MainFragmentViewModel

class FragmentMain : Fragment() {
    companion object {
        fun newInstance() = FragmentMain()
    }

//    private var _binding: FragmentMainBinding? = null
//    private val binding: FragmentMainBinding
//        get() = _binding!!

    private lateinit var inf: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inf = inflater.inflate(R.layout.fragment_main, container, false)
        return inf
//        _binding = FragmentMainBinding.inflate(inflater, container, false)
//        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainFragmentViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mainFragmentViewModel.getDataFromModel().observe(viewLifecycleOwner, Observer {
//            binding.nutsCountTextView.text =
//                mainFragmentViewModel.getDataFromModel().value?.nutsCount.toString()
//            binding.nutsNameTextVew.text = mainFragmentViewModel.getDataFromModel().value?.nutsName

            inf.findViewById<TextView>(R.id.nutsCount_text_view).text =
                mainFragmentViewModel.getDataFromModel().value?.nutsCount.toString()
            inf.findViewById<TextView>(R.id.nutsName_text_vew).text =
                mainFragmentViewModel.getDataFromModel().value?.nutsName
        })

//кривой способ обновления модели
        val btn = inf.findViewById<Button>(R.id.updateModel_button)
        btn.setOnClickListener {
            mainFragmentViewModel.modelUpdate()
        }
//        binding.updateModelButton.setOnClickListener {
//            mainFragmentViewModel.modelUpdate()
//        }

    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}