package com.capstone_bangkit.fitnessist.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone_bangkit.fitnessist.adapter.ArticleHomeAdapter
import com.capstone_bangkit.fitnessist.authentication.AuthenticationManager
import com.capstone_bangkit.fitnessist.databinding.FragmentHomeBinding
import com.capstone_bangkit.fitnessist.model.Article
import com.capstone_bangkit.fitnessist.model.ArticleDataDummy

class HomeFragment : Fragment() {
    private lateinit var authentication: AuthenticationManager
    private lateinit var articleAdapter: ArticleHomeAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        articleAdapter = ArticleHomeAdapter()
        authentication = AuthenticationManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        articleAdapter.getArticles(ArticleDataDummy.listArticle)
        articleRecyclerView()
        onArticleClick()
        binding.tvViewAll.setOnClickListener {
            val article = Intent(context, ArticleActivity::class.java)
            startActivity(article)
        }

        val getName = authentication.getAccess(AuthenticationManager.NAME).toString()
        binding.tvName.text = getName

        return binding.root
    }

    private fun articleRecyclerView() {
        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = articleAdapter
        }
    }

    private fun onArticleClick() {
        articleAdapter.setOnItemClickCallback(object: ArticleHomeAdapter.OnItemClickCallback {
            override fun onItemClicked(article: Article) {
                Intent(context, DetailArticleActivity::class.java).also {
                    it.putExtra(DetailArticleActivity.PHOTO_URL, article.photoUrl)
                    it.putExtra(DetailArticleActivity.TITLE, article.title)
                    it.putExtra(DetailArticleActivity.DESCRIPTION, article.description)
                    startActivity(it)
                }
            }
        })
    }

}