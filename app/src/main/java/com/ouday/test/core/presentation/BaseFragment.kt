package com.ouday.test.core.presentation

import dagger.android.support.DaggerFragment

const val DEFAULT_DIALOG_TAG = "DEFAULT_DIALOG_TAG"

open class BaseFragment: DaggerFragment(){

    private var dialogsMap = HashMap<String?, GifProgressDialog?>()

    /**
     * Display the default loading of the App
     */
    fun showLoading() {
        showLoading(DEFAULT_DIALOG_TAG)
    }

    /**
     * Display the default loading of the app
     * with tag to be used later on to dismiss loading
     */
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

    /**
     * Dismiss Default loading of the App
     */
    fun dismissLoading() {
        var progressDialog = dialogsMap[DEFAULT_DIALOG_TAG]
        if (progressDialog?.isShowing == true)
            progressDialog?.dismissDialog()
    }

    /**
     * Dismiss Default Loading of the App
     * using the tag
     */
    fun dismissLoading(tag: String?) {
        var progressDialog = dialogsMap[tag]
        if (progressDialog?.isShowing == true)
            progressDialog?.dismissDialog()
    }

}