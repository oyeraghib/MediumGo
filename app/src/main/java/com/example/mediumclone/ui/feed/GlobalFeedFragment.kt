package com.example.mediumclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediumclone.databinding.FragmentFeedBinding

class GlobalFeedFragment: Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private var _binding: FragmentFeedBinding? = null
    private lateinit var feedAdapter: ArticleFeedAdapter

// This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter()

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        _binding?.rvFeed?.layoutManager = LinearLayoutManager(context)
        _binding?.rvFeed?.adapter = feedAdapter

        feedViewModel.fetchGlobalFeed()

        feedViewModel.feed.observe(viewLifecycleOwner){
            feedAdapter.submitList(it)
        }

        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}