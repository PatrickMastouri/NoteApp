package com.example.gardinapp.feature_note.domain.util

sealed class NoteOrdre(val ordreType: OrdreType) {
    class Title(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)
    class Date(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)
    class Color(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)

}
