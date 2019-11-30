package com.ouday.test.core.di.builder;

import com.ouday.test.customer.presentation.ui.activity.CustomerActivity;
import com.ouday.test.profile.presentation.ui.activity.ProfileActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {

    @ContributesAndroidInjector
    ProfileActivity getProfileActivity();

    @ContributesAndroidInjector
    CustomerActivity getCustomerActivity();

}
