package com.example.gardinapp.feature_note.presentation.notes.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gardinapp.feature_note.domain.model.Note
import com.example.gardinapp.feature_note.domain.use_case.NoteUseCases
import com.example.gardinapp.feature_note.domain.util.NoteOrdre
import com.example.gardinapp.feature_note.domain.util.OrdreType
import com.example.gardinapp.feature_note.presentation.notes.NotesEvent
import com.example.gardinapp.feature_note.presentation.notes.NotesState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesViewModel @Inject constructor(private val notesUsecases: NoteUseCases) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state
    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrdre.Date(OrdreType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.notesOrder::class == event.noteOrdre::class &&
                    state.value.notesOrder.ordreType == event.noteOrdre.ordreType
                ) {
                    return
                }
                getNotes(event.noteOrdre)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesUsecases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    notesUsecases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrdre: NoteOrdre) {
        getNotesJob?.cancel()
        notesUsecases.getNotes(noteOrdre).onEach { notes ->
            _state.value = state.value.copy(
                notes,
                noteOrdre
            )
        }.launchIn(viewModelScope)
    }

}