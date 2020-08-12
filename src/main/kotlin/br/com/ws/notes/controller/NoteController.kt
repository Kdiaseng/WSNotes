package br.com.ws.notes.controller

import br.com.ws.notes.form.NoteForm
import br.com.ws.notes.model.Note
import br.com.ws.notes.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
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
    fun add(@RequestBody note: NoteForm): Note {
        return noteService.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: NoteForm): Note {
        return noteService.alter(id, note)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        noteService.delete(id)
    }
}