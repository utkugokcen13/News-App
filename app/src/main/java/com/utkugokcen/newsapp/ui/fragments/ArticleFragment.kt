package com.utkugokcen.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.utkugokcen.newsapp.R
import com.utkugokcen.newsapp.ui.NewsActivity
import com.utkugokcen.newsapp.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {
    lateinit var viewModel : NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}