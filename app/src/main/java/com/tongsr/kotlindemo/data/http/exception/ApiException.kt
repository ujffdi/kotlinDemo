package com.tongsr.kotlindemo.data.http.exception

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   :
 * </pre>
 */
class ApiException : Exception {

    var code: Int? = null
    var errorMsg: String? = null

    constructor(errorMsg: String) : super(errorMsg) {
        this.errorMsg = errorMsg
    }

    constructor(code: Int, errorMsg: String) : super(errorMsg) {
        this.code = code
        this.errorMsg = errorMsg
    }


}