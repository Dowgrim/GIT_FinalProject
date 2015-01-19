package zuul.learn;

import java.util.ArrayList;

import zuul.student.Game;

/**
 * @author Nicolas Hory
 */

public class Lecture extends Course {
	
	private int number;

	public Lecture(String matiere, int nb) {
		super(matiere);
		number = nb;
	}
	
	/**
	 * Returns the number of the lecture
	 */
	@Override
	public int getNumber () {
		return number;
	}

	/**
	 * Prints all the lectures the student have followed
	 */
	@Override
	public void printCourse() {
			ArrayList<Lecture> lectures = Game.student.getLectures();
			System.out.print(Game.resource.getString("all.lect"));
			if (lectures.isEmpty()){
				System.out.println(Game.resource.getString("no.lects"));
			} else {
				for (Lecture lecture : lectures) {
					System.out.print(lecture.getMatiere() + lecture.getNumber() + " ");
				}
				System.out.println();
			} 
		
	}

}
