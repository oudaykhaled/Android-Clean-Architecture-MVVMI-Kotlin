package com.ouday.test.core.presentation

import dagger.android.support.DaggerFragment

const val DEFAULT_DIALOG_TAG = "DEFAULT_DIALOG_TAG"

open class BaseFragment: DaggerFragment(){

    protected var dialogsMap = HashMap<String?, GifProgressDialog?>()

    fun showLoading() {
        showLoading(DEFAULT_DIALOG_TAG)
    }

    fun showLoading(tag: String?) {
        var progressDialog = dialogsMap[tag]
        activity?.let {
            if (!it.isFinishing) {
                if (progressDialog == null){
                    progressDialog = GifProgressDialog(it)
                    dialogsMap[tag] = progressDialog
                }
                progressDialog?.setCancelable(false)
                progressDialog?.showDialog()
            }
        }
    }

    fun dismissLoading() {
        var progressDialog = dialogsMap[DEFAULT_DIALOG_TAG]
        if (progressDialog?.isShowing == true)
            progressDialog?.dismissDialog()
    }

    fun dismissLoading(tag: String?) {
        var progressDialog = dialogsMap[tag]
        if (progressDialog?.isShowing == true)
            progressDialog?.dismissDialog()
    }

}