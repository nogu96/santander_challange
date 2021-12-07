package com.example.falonzo.santander_challenge.ui.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.falonzo.santander_challenge.databinding.CharactersFragmentBinding
import com.example.falonzo.santander_challenge.model.Status
import org.koin.android.ext.android.inject

class CharactersFragment : Fragment() {

    private val viewModel: CharactersViewModel by inject()
    private lateinit var binding: CharactersFragmentBinding
    private lateinit var characterAdapter: CharactersAdapter
    private val COLUMN_NUMBER = 3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharactersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterAdapter = CharactersAdapter()
        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = GridLayoutManager(context, COLUMN_NUMBER)
        }

        viewModel.getCharacterList().observe(viewLifecycleOwner) { response ->
            when(response.status) {
                Status.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    response.data?.let {
                        characterAdapter.upload(it)
                    }
                }
                Status.ERROR -> {
                    binding.progressBar.isVisible = false

                }
                Status.LOADING -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

}