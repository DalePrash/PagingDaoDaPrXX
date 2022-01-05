package com.example.practiseaadapr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.practiseaadapr.R
import com.example.practiseaadapr.data.NewsList
import com.example.practiseaadapr.data.NewsPojo
import com.example.rickymortydapr.network.RetroService
import com.example.roomservicetocachedapr.APICl
import com.example.roomservicetocachedapr.NewsDataBase
import com.example.roomservicetocachedapr.NewsDataBase.Companion.getDatabase
import com.example.roomservicetocachedapr.NewsListDataBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val textA : TextView by lazy{
        findViewById(R.id.textA) as TextView
    }
    private val textB : TextView by lazy{
        findViewById(R.id.textB) as TextView
    }
    private val textC : TextView by lazy{
        findViewById(R.id.textC) as TextView
    }
    private val textD : TextView by lazy{
        findViewById(R.id.textD) as TextView
    }
    private val buttonA : TextView by lazy{
        findViewById(R.id.buttonA) as TextView
    }
    private val buttonB : TextView by lazy{
        findViewById(R.id.buttonB) as TextView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initOnClick()
    }

   fun  initOnClick(){
       buttonA?.setOnClickListener(object : View.OnClickListener{
           override fun onClick(p0: View?) {
Daoinsert()           }
       })

       buttonB?.setOnClickListener(object : View.OnClickListener{
           override fun onClick(p0: View?) {
Daoretrieve()           }
       })
   }

   fun  Daoinsert (){
      // CoroutineContext
       val coroutineScope = CoroutineScope(Dispatchers.Main)
       lateinit var retroService: RetroService
    //   val apiService = RetroInstance.getRetroInstance()?.create(RetroService::class.java)



       Log.v("AABB","At position ooo")

       coroutineScope.launch(Dispatchers.Main) {
           Log.v("AABB","At position A")

           newsListSet()



       }


   }

    fun  Daoretrieve (){
   //    val md = getDatabase(this@MainActivity)
        val md = getDatabase(PagingActivity.getAppContext())

        val moviedao = md?.newsAbs()
     //   var list =
       // var newsPojoo = NewsPojo(0,null,"Travis")
      // moviedao?.insert(newsPojoo)
     //   val md = getDatabase(PagingActivity.getAppContext())


        // val mdao = md!!.newsAbs()
        // val k = mdao!!.alphabetizedWord

        moviedao?.getNews()?.observe(this, Observer {
            Log.i("AABB","LiveData")
            Log.i("AABB",it.author.toString())
            textD?.setText(it!!.author.toString())
            Log.i("AABB","bbb")

        })


     //   Log.i("aaaaa", k!!.author)
      //  textD?.setText(k!!.author.toString())

        //    Log.i("aaaaa",k?.name.toString())
        //   Pojo sui = new Pojo(k.get[0].)
        //  response?.results?.get(2)?.name
        // textView2?.setText(k!![0]!!.original_title)  this is for list
    }

    fun newsSet(){
        val apiService = APICl.client?.create(RetroService::class.java)


        val responsexx=  apiService?.topRatedNews
        Log.v("AABB","At position B")

        responsexx?.enqueue(object : Callback<NewsPojo> {
            override fun onResponse(call: Call<NewsPojo>, response: Response<NewsPojo>) {
                Log.v("AABB",response?.body().toString())
               val moviedb = NewsDataBase.getDatabase(this@MainActivity)
           //     val moviedb = NewsDataBase.getDatabase(baseContext)
          //      val dummy = NewsDataBase.getDatabase(applicationContext)
                val dummy = NewsDataBase.getDatabase(applicationContext)

                val moviedao = moviedb?.newsAbs()
                moviedao?.insert(response?.body())
                Log.v("AABB","ADDED")

            }

            override fun onFailure(call: Call<NewsPojo>, t: Throwable) {
                Log.v("AABB","Error")
            }
        })
    }



    fun newsListSet(){
        val apiService = APICl.client?.create(RetroService::class.java)


        val responsexx=  apiService?.topRatedNewsList
        Log.v("AABB","At position B")

        responsexx?.enqueue(object : Callback<NewsList> {
            override fun onResponse(call: Call<NewsList>, response: Response<NewsList>) {
                Log.v("AABB",response?.body().toString())
                Log.v("AABB","ADDED")

             //    val moviedb = NewsListDataBase.getDatabase(this@MainActivity)
              //    val moviedao = moviedb?.newsListAbs()
              //  var n : NewsPojo =response?.body()?.articles
                  //moviedao?.insert(response?.body())
                  Log.v("AABB","ADDED")



            }

            override fun onFailure(call: Call<NewsList>, t: Throwable) {
                Log.v("AABB","Error")
            }
        })
    }


}