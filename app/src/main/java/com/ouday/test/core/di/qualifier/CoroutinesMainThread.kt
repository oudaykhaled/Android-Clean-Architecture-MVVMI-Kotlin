package com.ouday.test.core.di.qualifier

import javax.inject.Qualifier


@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CoroutinesMainThread