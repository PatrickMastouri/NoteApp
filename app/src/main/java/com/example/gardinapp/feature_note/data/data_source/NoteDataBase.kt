package com.example.gardinapp.feature_note.data.data_sourace

import androidx.room.Database
import com.example.gardinapp.feature_note.data.data_source.NoteDao
import com.example.gardinapp.feature_note.domain.model.Note

@Database(
    entities = [Note::class], version = 1
)
abstract class NoteDataBase {
abstract val noteDao: NoteDao
}