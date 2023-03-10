package com.example.gardinapp.di

import android.app.Application
import androidx.room.Room
import com.example.gardinapp.feature_note.data.data_sourace.NoteDataBase
import com.example.gardinapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.gardinapp.feature_note.domain.repository.NoteRepository
import com.example.gardinapp.feature_note.domain.use_case.AddNote
import com.example.gardinapp.feature_note.domain.use_case.DeleteNote
import com.example.gardinapp.feature_note.domain.use_case.GetNotes
import com.example.gardinapp.feature_note.domain.use_case.NoteUseCases
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
    fun provideNoteDatabase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDataBase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}