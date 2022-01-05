package com.example.practiseaadapr.paging

import android.content.Context

class Coreframework {
    var context: Context? = null
    var pagingSource: Coreframework? = null
    fun getInstance(mC: Context?): Coreframework? {
        if (context == null) {
            context = mC
        }
        if (pagingSource == null) {
            pagingSource = Coreframework()
        }
        return pagingSource
    }
}