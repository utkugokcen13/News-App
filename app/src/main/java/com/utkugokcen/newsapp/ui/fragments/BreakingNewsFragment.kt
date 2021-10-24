package com.utkugokcen.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utkugokcen.newsapp.R
import com.utkugokcen.newsapp.adapters.NewsAdapter
import com.utkugokcen.newsapp.ui.NewsActivity
import com.utkugokcen.newsapp.ui.NewsViewModel
import com.utkugokcen.newsapp.util.Resource

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar(view : View){
        val paginationProgressBar = view.findViewById<ProgressBar>(R.id.paginationProgressBar) as ProgressBar
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(view : View){
        val paginationProgressBar = view.findViewById<ProgressBar>(R.id.paginationProgressBar) as ProgressBar
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(view: View){
        val rvBreakingNews = view.findViewById<RecyclerView>(R.id.rvBreakingNews) as RecyclerView

        newsAdapter = NewsAdapter()
        rvBreakingNews.apply{
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}