package com.example.gardinapp.di

import android.app.Application
import android.text.method.SingleLineTransformationMethod
import com.example.gardinapp.feature_note.data.data_sourace.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDataBase{
        return
    }
}