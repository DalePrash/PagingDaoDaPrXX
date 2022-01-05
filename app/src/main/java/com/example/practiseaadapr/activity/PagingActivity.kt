package com.example.practiseaadapr.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiseaadapr.R
import com.example.rickymortydapr.MainActivityViewModel
import com.example.rickymortydapr.RecyclerViewAdapter
import com.example.roomservicetocachedapr.NewsDataBase
import kotlinx.android.synthetic.main.activity_paging.*
import kotlinx.coroutines.flow.collectLatest


public class PagingActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
companion object{
     lateinit var contextPaging: Context
   public fun getAppContext(): Context {
        return PagingActivity.contextPaging
    }
}
    private val textView99 : TextView by lazy{
        findViewById(R.id.textView99) as TextView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PagingActivity.contextPaging = applicationContext

        setContentView(R.layout.activity_paging)
        initRecyclerView()
        initViewModel()
        initClick()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PagingActivity)
            val decoration  = DividerItemDecoration(
                applicationContext,
                DividerItemDecoration.VERTICAL
            )
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

        }
    }

    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    private fun initClick(){
        textView99?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                goToMainActivity()
            }
        })
    }
    fun  goToMainActivity () {
        var intent = Intent()
        intent.action="ew"
        startActivity(intent)

    }

    fun  Daoretrieve () {

        val moviedb = NewsDataBase.getDatabase(this@PagingActivity)
        val moviedao = moviedb?.newsAbs()
        val kk = moviedao!!.alphabetizedWords
        Log.i("aaaaa", kk!!.author)
    // textView2?.setText(k!![0]!!.original_title)  this is for list



    }







}