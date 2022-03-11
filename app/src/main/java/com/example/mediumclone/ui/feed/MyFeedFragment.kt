package com.example.mediumclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediumclone.databinding.FragmentFeedBinding

class MyFeedFragment: Fragment() {

    private lateinit var viewModel: FeedViewModel
    private var _binding: FragmentFeedBinding? = null
    private var articleFeedAdapter = ArticleFeedAdapter()


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)


        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        _binding?.rvFeed?.layoutManager = LinearLayoutManager(requireContext())
        _binding?.rvFeed?.adapter = articleFeedAdapter
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMyFeed()
        viewModel.feed.observe(viewLifecycleOwner){
            articleFeedAdapter.submitList(it)
        }


    }

}