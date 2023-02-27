package com.example.gardinapp.feature_note.domain.util

sealed class NoteOrdre(val ordreType: OrdreType) {
    class Title(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)
    class Date(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)
    class Color(ordreType: OrdreType) : NoteOrdre(ordreType = ordreType)

    fun copy(ordreType: OrdreType): NoteOrdre{
        return when(this){
            is Title -> Title(ordreType = ordreType)
            is Date -> Date(ordreType = ordreType)
            is Color -> Color(ordreType = ordreType)
        }
    }

}
