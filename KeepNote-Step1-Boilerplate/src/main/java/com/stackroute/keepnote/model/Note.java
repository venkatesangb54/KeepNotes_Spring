package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the Note data in the ArrayList.
 */
public class Note {

	private int noteId;
	private String noteTitle;
	private String noteContent;
	private String noteStatus;
	private LocalDateTime createdAt;
	/*
	 * This class should have five fields (noteId, noteTitle, noteContent,
	 * noteStatus and createdAt). This class should also contain the getters and
	 * setters for the fields. The value of createdAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */
    
	public Note() {
	}
	
	public Note(int noteId,String noteTitle, String noteContent, String noteStatus, LocalDateTime createdAt) {
		this.noteId =  noteId;  
		this.noteTitle =  noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.createdAt = createdAt;
	}
	
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteStatus="
				+ noteStatus + ", createdAt=" + createdAt + "]";
	}

}
