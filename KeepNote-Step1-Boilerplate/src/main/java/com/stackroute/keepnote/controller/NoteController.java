package com.stackroute.keepnote.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {

	//@Autowired(required = true)
	//NoteRepository np = new NoteRepository();
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	NoteRepository np = (NoteRepository) context.getBean("noteRepositoryBean");
	Note note = (Note) context.getBean("noteBean");
	
	
	@RequestMapping(value = "/welcome")
	public String home() {
		return "Welcome";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView initView() {
		Note n = new Note();
		return new ModelAndView("index", "note", n);
	}

	@RequestMapping(value = "/saveNote", method = RequestMethod.POST)
	public String note(@ModelAttribute("note") Note note, ModelMap model) {
		if (note != null) {
			note.setCreatedAt(LocalDateTime.now());
			np.addNote(note);
		}
		model.addAttribute("notes", np.getAllNotes());
		// hope you have a result.jsp if you don't then return the name of your desired
		// page
		return "index";
	}
	
	@RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
	public String deleteNote(@ModelAttribute("note") Note note, ModelMap model) {
		if(note != null) {
			np.deleteNote(note.getNoteId());
		}
		model.addAttribute("notes", np.getAllNotes());
		// hope you have a result.jsp if you don't then return the name of your desired
		// page
		return "index";
	}

	/*
	 * From the problem statement, we can understand that the application requires
	 * us to implement the following functionalities.
	 * 
	 * 1. display the list of existing notes from the collection. Each note should
	 * contain Note Id, title, content, status and created date. 2. Add a new note
	 * which should contain the note id, title, content and status. 3. Delete an
	 * existing note. 4. Update an existing note.
	 */
	
	/*
	 * Get the application context from resources/beans.xml file using
	 * ClassPathXmlApplicationContext() class. Retrieve the Note object from the
	 * context. Retrieve the NoteRepository object from the context.
	 */

	/*
	 * Define a handler method to read the existing notes by calling the
	 * getAllNotes() method of the NoteRepository class and add it to the ModelMap
	 * which is an implementation of Map for use when building model data for use
	 * with views. it should map to the default URL i.e. "/"
	 */

	/*
	 * Define a handler method which will read the Note data from request parameters
	 * and save the note by calling the addNote() method of NoteRepository class.
	 * Please note that the createdAt field should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving the
	 * note, it should show the same along with existing notes. Hence, reading notes
	 * has to be done here again and the retrieved notes object should be sent back
	 * to the view using ModelMap. This handler method should map to the URL
	 * "/saveNote".
	 */

	/*
	 * Define a handler method to delete an existing note by calling the
	 * deleteNote() method of the NoteRepository class This handler method should
	 * map to the URL "/deleteNote"
	 */
	
	/*
	 * @RequestMapping(value="/index",method = RequestMethod.GET) public String
	 * viewNotes(Map<String, Object> model) { Note noteForm = new Note();
	 * model.put("noteForm", noteForm);
	 * 
	 * 
	 * List<String> noteList = new ArrayList<>(); noteList.add("Developer");
	 * professionList.add("Designer"); professionList.add("IT Manager");
	 * model.put("professionList", professionList);
	 * 
	 * 
	 * return "index"; }
	 */

	/*
	 * @RequestMapping(value = "/saveNote", method = RequestMethod.POST) public
	 * String addingNoteEntry(@ModelAttribute("noteForm") Note note, Map<String,
	 * Object> model) {
	 * 
	 * // implement your own registration logic here...
	 * 
	 * // for testing purpose: System.out.println("noteContent: " +
	 * note.getNoteContent());
	 * 
	 * System.out.println("password: " + note.getPassword());
	 * System.out.println("email: " + note.getEmail());
	 * System.out.println("birth date: " + note.getBirthDate());
	 * System.out.println("profession: " + note.getProfession());
	 * 
	 * 
	 * return "index"; }
	 */

}
