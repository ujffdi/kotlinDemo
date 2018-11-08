package com.tongsr.kotlindemo.data.http

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   : GankHttpResponse
 * </pre>
 */
class GankHttpResponse<out T> constructor(val error: Boolean, val results: T)