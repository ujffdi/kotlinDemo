package com.tongsr.kotlindemo.ui

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   : 妹子列表
 * </pre>
 */


data class GirlBean(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
)