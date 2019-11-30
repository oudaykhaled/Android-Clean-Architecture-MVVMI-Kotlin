package com.ouday.test.customer.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ouday.test.core.presentation.ViewModelFactory
import com.ouday.test.customer.presentation.viewmodel.CustomerViewModel
import com.ouday.test.core.di.modules.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CustomerPresentationModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CustomerViewModel::class)
    abstract fun bindsAllCustomersViewModel(allCustomersViewModel: CustomerViewModel): ViewModel
}