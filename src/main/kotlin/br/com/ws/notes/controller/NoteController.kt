package br.com.ws.notes.controller

import br.com.ws.notes.form.NoteForm
import br.com.ws.notes.model.Note
import br.com.ws.notes.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController {

    @Autowired
    lateinit var noteService: NoteService

    @GetMapping
    fun list(): List<Note> {
        return noteService.listAll()
    }

    @PostMapping
    fun add(@RequestBody note: NoteForm): ResponseEntity<Note> {
        return ResponseEntity(noteService.save(note), HttpStatus.CREATED)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: NoteForm): ResponseEntity<Note> {
        return ResponseEntity.ok(noteService.alter(id, note))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        noteService.delete(id)
        return ResponseEntity.ok().build()
    }
}