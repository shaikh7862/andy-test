package com.andysoft.test.di.modules

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.andysoft.test.R
import com.andysoft.test.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    @Singleton
    fun provideContext() = application.applicationContext

    @Provides
    @Singleton
    fun providePreference() =
        application.getSharedPreferences(Constants.SharedPrefTags.myPrefKey, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    internal fun provideAppDrawable(application: Application): Drawable? {
        return ContextCompat.getDrawable(application, R.drawable.ic_launcher_foreground)
    }

}