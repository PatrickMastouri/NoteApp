package com.example.gardinapp.feature_note.presentation.notes

import com.example.gardinapp.feature_note.domain.model.Note
import com.example.gardinapp.feature_note.domain.util.NoteOrdre
import com.example.gardinapp.feature_note.domain.util.OrdreType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val notesOrder: NoteOrdre = NoteOrdre.Date(OrdreType.Descending),
    val isOrderSectionVisible: Boolean = false
    )
