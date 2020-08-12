package br.com.ws.notes.repository

import br.com.ws.notes.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long> {

}