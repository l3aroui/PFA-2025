package ma.emsi.serviceClient_com.services.servicesImpl;


import ma.emsi.serviceClient_com.entities.Note;
import ma.emsi.serviceClient_com.repositories.ClientRepository;
import ma.emsi.serviceClient_com.repositories.NoteRepository;
import ma.emsi.serviceClient_com.services.NoteServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotService implements NoteServiceI {
    private final NoteRepository noteRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public NotService(NoteRepository noteRepository, ClientRepository clientRepository) {
        this.noteRepository = noteRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Note> showNotes(Long clientId) {
        return noteRepository.findByClient(clientRepository.findById(clientId).orElseThrow(()->new RuntimeException("user not found")));
    }

    @Override
    public Note addNoteToClient(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public Note UpdateNote(Note noteUpdate) {
        Note note=Note.builder()
                .id(noteUpdate.getId())
                .text(noteUpdate.getText())
                .build();
        return noteRepository.save(note);
    }
}
