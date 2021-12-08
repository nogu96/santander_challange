package com.example.falonzo.santander_challenge.ui.characterDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.falonzo.santander_challenge.R
import com.example.falonzo.santander_challenge.databinding.CharacterDetailFragmentBinding
import com.example.falonzo.santander_challenge.extension.load
import com.example.falonzo.santander_challenge.model.Status
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment : Fragment() {

    private val args by navArgs<CharacterDetailFragmentArgs>()
    private val viewModel: CharacterDetailViewModel by viewModel { parametersOf(args.character) }
    private lateinit var binding: CharacterDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.character.let {
            binding.backgroundImage.load(it.thumbnail.getUrl())
            binding.txtName.text = it.name
            binding.txtDescription.text = it.description
        }

        viewModel.getComics().observe(viewLifecycleOwner) { response ->
            when(response.status) {
                Status.SUCCESS -> {
                    response.data?.let {
                        binding.comicStripe.apply {
                            setTitle(getString(R.string.comics))
                            setList(it)
                        }
                    }
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        }

        viewModel.getSeries().observe(viewLifecycleOwner) { response ->
            when(response.status) {
                Status.SUCCESS -> {
                    response.data?.let {
                        binding.serieStripe.apply {
                            setTitle(getString(R.string.series))
                            setList(it)
                        }
                    }
                }
                Status.ERROR -> {
                }
                Status.LOADING -> {

                }
            }
        }
    }

}