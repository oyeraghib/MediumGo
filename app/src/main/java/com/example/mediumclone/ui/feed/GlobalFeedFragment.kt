package com.example.mediumclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediumclone.databinding.FragmentFeedBinding

class GlobalFeedFragment: Fragment() {


    private lateinit var viewModel: FeedViewModel
    private var _binding: FragmentFeedBinding? = null
    private lateinit var feedAdapter: ArticleFeedAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter()

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        _binding?.rvFeed?.layoutManager = LinearLayoutManager(context)
        _binding?.rvFeed?.adapter = feedAdapter

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchGlobalFeed()

        viewModel.feed.observe(viewLifecycleOwner){
            feedAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}