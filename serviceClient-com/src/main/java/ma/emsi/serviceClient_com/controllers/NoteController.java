package ma.emsi.serviceClient_com.controllers;

import ma.emsi.serviceClient_com.entities.Note;
import ma.emsi.serviceClient_com.services.NoteServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/client/note")
public class NoteController{

    private final NoteServiceI noteServiceI;

    @Autowired
    public NoteController(NoteServiceI noteServiceI) {
        this.noteServiceI = noteServiceI;
    }

    @GetMapping("/{idCl}")
    public ResponseEntity<List<Note>> showNotes(@PathVariable("idCl") Long clientId) {
        return ResponseEntity.ok(noteServiceI.showNotes(clientId));
    }

    @PostMapping
    public Note addNoteToClient(Note note) {
        return noteServiceI.addNoteToClient(note);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteNote(Long noteId) {
        noteServiceI.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Note> UpdateNote(Note noteUpdate) {
        return ResponseEntity.ok(noteServiceI.UpdateNote(noteUpdate));
    }
}