package com.ouday.test.core.di.modules

import androidx.work.Worker
import dagger.android.AndroidInjector



interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<Worker>?

}
