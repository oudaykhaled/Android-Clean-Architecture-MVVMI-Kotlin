package com.ouday.test.core.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoggerModule {

    @Provides
    @Singleton
    public LoggerModule provideLoggerModule(Application application) {
        return new LoggerModule();
    }
}
