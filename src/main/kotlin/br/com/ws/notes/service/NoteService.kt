package br.com.ws.notes.service

import br.com.ws.notes.form.NoteForm
import br.com.ws.notes.model.Note
import br.com.ws.notes.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService {

    @Autowired
    lateinit var noteRepository : NoteRepository

    fun save(noteForm: NoteForm): Note{
        val note = Note(title = noteForm.title, description = noteForm.description)
        return noteRepository.save(note)
    }

    fun alter(id: Long, noteForm: NoteForm): Note{
        val noteOptional = noteRepository.findById(id)
        if (!noteOptional.isEmpty){
            val note = noteOptional.get()
            note.description = noteForm.description
            note.title = noteForm.title
            return noteRepository.save(note)
        }
        return Note()
    }

    fun delete(id: Long){
        val noteOptional =  noteRepository.findById(id)
        if (!noteOptional.isEmpty){
            noteRepository.deleteById(id)
        }
    }

    fun listAll() = noteRepository.findAll().toList()

}