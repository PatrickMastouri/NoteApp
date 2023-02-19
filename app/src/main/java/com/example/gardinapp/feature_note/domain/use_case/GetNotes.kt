package com.example.gardinapp.feature_note.domain.use_case

import com.example.gardinapp.feature_note.domain.model.Note
import com.example.gardinapp.feature_note.domain.repository.NoteRepository
import com.example.gardinapp.feature_note.domain.util.NoteOrdre
import com.example.gardinapp.feature_note.domain.util.OrdreType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetNotes(private val repository: NoteRepository) {
    operator fun invoke(noteOrdre: NoteOrdre = NoteOrdre.Date(OrdreType.Descending)): Flow<List<Note>>{
        return repository.getNotes().map { notes ->
            when(noteOrdre.ordreType){
                is OrdreType.Ascending ->{
                    when(noteOrdre){
                        is NoteOrdre.Date -> notes.sortedBy { it.date }
                        is NoteOrdre.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrdre.Color -> notes.sortedBy { it.color }
                    }

                }
                is OrdreType.Descending ->{
                    when(noteOrdre){
                        is NoteOrdre.Date -> notes.sortedByDescending { it.date }
                        is NoteOrdre.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrdre.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }

    }
}