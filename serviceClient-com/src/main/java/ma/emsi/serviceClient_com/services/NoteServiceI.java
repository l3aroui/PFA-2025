package ma.emsi.serviceClient_com.services;

import ma.emsi.serviceClient_com.entities.Note;


import java.util.List;

public interface NoteServiceI {
    List<Note> showNotes(Long clientId);
    Note addNoteToClient(Note note);
    void deleteNote(Long noteId);
    Note UpdateNote(Note noteUpdate);
}
