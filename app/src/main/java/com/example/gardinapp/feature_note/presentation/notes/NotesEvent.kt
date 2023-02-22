package com.example.gardinapp.feature_note.presentation.notes

import com.example.gardinapp.feature_note.domain.model.Note
import com.example.gardinapp.feature_note.domain.util.NoteOrdre

sealed class NotesEvent{
    data class Order(val noteOrdre: NoteOrdre): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()

}