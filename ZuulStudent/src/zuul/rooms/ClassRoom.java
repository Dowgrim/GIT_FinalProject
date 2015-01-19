package zuul.rooms;

import zuul.learn.*;

/**
 * @author Nicolas Hory
 */
import zuul.student.*;

/**
 * @author Nicolas Hory
 */

public class ClassRoom extends Room {

	public ClassRoom(String description) {
		super(description);
	}
	
	/**
	 * Creates a lecture and adds it to the student's list with the method addLecture
	 */
	public void generateClassLecture () {
		String matiere = Subject.getRandom().toString(); // Gets a random subject
		int nbCourse = (int)(Math.random() * 3); // Gets a random number
		if (matiere.equals("POO")) { // If the subject is POO
			Course course = new Lecture (matiere, nbCourse);  // Adds it to the student if heh didn't know it yet
			Game.student.addLecture((Lecture)course);
		} else {
			System.out.println(Game.resource.getString("bad.lect") + matiere); // Else print an error
		}
	}

}
