package com.example.android3_2.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_2.R
import com.example.android3_2.data.models.Character
import com.example.android3_2.databinding.FragmentAddCharacterBinding


class AddCharacterFragment : Fragment() {
    private var _binding: FragmentAddCharacterBinding? = null
    private val binding: FragmentAddCharacterBinding get() = _binding!!
    private val viewModel by activityViewModels<CharapterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCharacterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListenners()

    }

    private fun setupListenners() = with(binding) {
        addButton.setOnClickListener {
            progressBarTwo.isVisible = true
            Handler().postDelayed({
                progressBarTwo.isVisible = false
                viewModel.addCharapter(
                    Character(
                        image = R.drawable.img,
                        etName.text.toString().trim()
                    )
                )
                findNavController().navigateUp()

            }, 3000)
        }

    }
}