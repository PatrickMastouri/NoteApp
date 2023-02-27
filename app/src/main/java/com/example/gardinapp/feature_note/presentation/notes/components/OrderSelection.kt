package com.example.gardinapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gardinapp.feature_note.domain.util.NoteOrdre
import com.example.gardinapp.feature_note.domain.util.OrdreType

@Composable
fun OrderSelection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrdre = NoteOrdre.Date(OrdreType.Descending),
    onOrderChange: (NoteOrdre) -> Unit
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrdre.Title,
                Onselected = {
                    onOrderChange(NoteOrdre.Title(noteOrder.ordreType))
                }

            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrdre.Date,
                Onselected = {
                    onOrderChange(NoteOrdre.Date(noteOrder.ordreType))
                }

            )
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrdre.Color,
                Onselected = {
                    onOrderChange(NoteOrdre.Color(noteOrder.ordreType))
                }

            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth())
            {
                DefaultRadioButton(
                    text = "Ascending",
                    selected = noteOrder.ordreType is OrdreType.Ascending,
                    Onselected = {
                        onOrderChange(noteOrder.copy(OrdreType.Ascending))

                    }

                )
                Spacer(modifier = Modifier.width(8.dp))
                DefaultRadioButton(
                    text = "Descending",
                    selected = noteOrder.ordreType is OrdreType.Descending,
                    Onselected = {
                        onOrderChange(noteOrder.copy(OrdreType.Descending))

                    }

                )

            }

        }
    }
}