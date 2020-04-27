package com.stackroute.keepnote.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.stackroute.keepnote.model.Note;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

public class NoteRepository {

	/* Declare a variable called "list" to store all the notes. */
	private List<Note> noteRepo;
	

	public NoteRepository() {
		noteRepo = new ArrayList<Note>();
	}


	public List<Note> getList() {
		return noteRepo;
	}

	/* This method should set the list variable with new list of notes */

	public void setList(List<Note> list) {
			noteRepo = list;
	}

	/*
	 * This method should Note object as argument and add the new note object into
	 * list
	 */

	public void addNote(Note note) {
		noteRepo.add(note);
	}

	/* This method should deleted a specified note from the list */

	public boolean deleteNote(int noteId) {
		/* Use list iterator to find matching note id and remove it from the list */
		for(Note n : noteRepo) {
			if(n.getNoteId() == noteId) {
				noteRepo.remove(n);
				return true;
			}
		}
		return false;
		
		
	}

	/* This method should return the list of notes */

	public List<Note> getAllNotes() {
		ArrayList<Note> sortedDates = (ArrayList<Note>) noteRepo
				.stream().sorted(Comparator.comparing(Note::getCreatedAt).reversed())
				.collect(Collectors.toList());
		sortedDates.forEach(System.out::println);
		return sortedDates;
	}

	/*
	 * This method should check if the matching note id present in the list or not.
	 * Return true if note id exists in the list or return false if note id does not
	 * exists in the list
	 */

	public boolean exists(int noteId) {
		for(Note n : noteRepo) {
			if(n.getNoteId() == noteId) {
				return true;
			}
		}
		return false;
	}
}
