package com.ouday.test.core.di.builder;

import com.ouday.test.customer.presentation.ui.fragment.AllCustomersFragment;
import com.ouday.test.customer.presentation.ui.fragment.CustomerDetailFragment;
import com.ouday.test.profile.presentation.ui.fragment.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    LoginFragment getLoginFragment();

    @ContributesAndroidInjector
    AllCustomersFragment getAllCustomersFragment();

    @ContributesAndroidInjector
    CustomerDetailFragment getCustomerDetailFragment();
}
