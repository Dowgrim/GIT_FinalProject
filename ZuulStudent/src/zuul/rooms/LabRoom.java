package zuul.rooms;

import zuul.learn.*;
import zuul.student.Game;

/** 
 * @author Nicolas Hory
 */


public class LabRoom extends Room {

	public LabRoom(String description) {
		super(description);
	}

	/**
	 * Creates a lab session and adds it to the student's list
	 */
	public void generateLab () {
		String matiere = Subject.getRandom().toString(); // Gets a random subject
		int nbLab = (int)(Math.random() * 3);
		if (matiere.equals("POO")) {	// If it's POO
			Game.student.addLab(new LabSession(matiere,nbLab)); // Adds the lab to the student
		} else {
			System.out.println(Game.resource.getString("bad.lab") + matiere);
		}
	}
}
