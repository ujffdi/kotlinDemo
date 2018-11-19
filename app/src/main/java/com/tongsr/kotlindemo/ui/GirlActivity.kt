package com.tongsr.kotlindemo.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.chad.library.adapter.base.BaseQuickAdapter
import com.tongsr.kotlindemo.Const
import com.tongsr.kotlindemo.R
import com.tongsr.kotlindemo.base.activity.BaseActivity
import com.tongsr.kotlindemo.data.DataManager
import com.tongsr.kotlindemo.ui.large.LargeActivity
import com.tongsr.kotlindemo.util.rxCompose
import com.tongsr.kotlindemo.util.startActivity
import com.tongsr.kotlindemo.widget.GridSpacingItemDecoration
import com.tongsr.kotlindemo.widget.NpaGridLayoutManager
import com.trello.rxlifecycle2.android.ActivityEvent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class GirlActivity : BaseActivity(), BaseQuickAdapter.RequestLoadMoreListener {


    @Inject
    lateinit var mDataManager: DataManager
    private lateinit var mAdapter: MainAdapter
    private var page = 1

    override fun onBindLayout(): Int = R.layout.activity_girl

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        mAdapter = MainAdapter()
        recycler.layoutManager = NpaGridLayoutManager(mContext, 2)
        recycler.addItemDecoration(GridSpacingItemDecoration(2, 10, false))
        recycler.adapter = mAdapter
        mAdapter.setOnLoadMoreListener(this, recycler)
    }

    override fun doBusiness() {
        mAdapter.setOnItemClickListener { _, _, position ->
            val bundle = Bundle()
            val girlBean = mAdapter.data[position] as GirlBean
            bundle.putString(Const.LARGE_URL_FLAG, girlBean.url)
            startActivity<LargeActivity>(bundle)
        }
    }

    override fun onHandleObserve() {
        super.onHandleObserve()
        fetchData(true)
    }

    override fun onLoadMoreRequested() {
        fetchData(false)
    }

    @SuppressLint("CheckResult")
    private fun fetchData(isRefresh: Boolean) {
        if (isRefresh) page = 1

        mDataManager.fetchGirlList(Const.PAGING_MAX_NUM, page)
                .rxCompose(bindUntilEvent(ActivityEvent.STOP))
                .subscribe({
                    setData(isRefresh, it)
                    page++
                }, {
                    it.printStackTrace()
                    mAdapter.setNewData(null)
                })

    }

    private fun setData(isRefresh: Boolean, data: List<GirlBean>) {
        val size = data.size

        when (isRefresh) {
            true -> mAdapter.setNewData(data)
            false -> if (size > 0) mAdapter.addData(data)
        }
        when (size < Const.PAGING_MAX_NUM) {
            //第一页如果不够一页就不显示没有更多数据布局
            true -> mAdapter.loadMoreEnd(isRefresh)
            false -> mAdapter.loadMoreComplete()
        }
    }
}