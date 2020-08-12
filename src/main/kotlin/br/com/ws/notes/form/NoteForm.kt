package br.com.ws.notes.form

import lombok.NoArgsConstructor

@NoArgsConstructor
data class NoteForm (val title: String = "",
                     val description: String= "")