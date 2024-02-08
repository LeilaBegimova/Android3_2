package com.example.android3_2.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android3_2.R
import com.example.android3_2.data.repositories.CharacterRepositories
import com.example.android3_2.databinding.FragmentCharaterBinding
import com.example.android3_2.ui.adapter.CharacterAdapter

class CharaterFragment : Fragment() {
    private var _binding: FragmentCharaterBinding? = null
    private val binding: FragmentCharaterBinding get() = _binding!!
    private val characterAdapter = CharacterAdapter()
    private val viewModel by activityViewModels<CharapterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        toGoSecondFragment()
        subscribeToBoxes()
    }

    private fun initialize() = with(binding) {
        val repository = CharacterRepositories()
        rvCharapter.adapter = characterAdapter
        characterAdapter.setCharapter(repository.heroes)
    }

    private fun toGoSecondFragment() = with(binding) {
        addButton.setOnClickListener {
            progressBar.isVisible = true
            Handler().postDelayed(
                {
                    progressBar.isVisible = false
                    findNavController().navigate(R.id.action_charaterFragment_to_addCharacterFragment2)
                },
                3000
            )
        }
    }

    private fun subscribeToBoxes() {
        viewModel.charapterLiveData.observe(viewLifecycleOwner) { UiState ->
            UiState?.let {
                binding.progressBar.isVisible = it.isLoading

                if (it.success != null) {
                    characterAdapter.setCharapter(it.success)
                } else {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}