package br.com.ws.notes.repository

import br.com.ws.notes.model.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {

}