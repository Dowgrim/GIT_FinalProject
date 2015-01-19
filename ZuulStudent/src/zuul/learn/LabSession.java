package zuul.learn;

import java.util.ArrayList;

import zuul.student.Game;

/**
 * @author Nicolas Hory
 */

public class LabSession extends Course{
	
	private int number;

	public LabSession(String matiere, int nb) {
		super(matiere);
		number = nb;
	}
	
	/**
	 * Returns the number of the lab
	 */
	@Override
	public int getNumber () {
		return number;
	}
	
	/**
	 * Prints all the labs the student have followed
	 */
	@Override
	public void printCourse() {
		ArrayList<LabSession> labs = Game.student.getLabs();
		System.out.print(Game.resource.getString("all.lab"));
		if (labs.isEmpty()){
			System.out.println(Game.resource.getString("no.labs"));
		} else {
			for (LabSession lab: labs) {
				System.out.print(lab.getMatiere() + lab.getNumber() + " ");
			}
			System.out.println();
		}
		
	}

}
