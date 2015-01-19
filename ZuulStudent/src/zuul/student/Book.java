package zuul.student;

import zuul.learn.*;

/**
	@author: Cindy NAJJAR
*/


public class Book extends Item {
	
    public Book(String description) {
        super(description);
    }

    /**
     * Reads the book, giving the student the knowledge of the three POO lectures 
     */
    public void readBook() {
    	System.out.println(Game.resource.getString("will.read"));
    	for (int i = 0; i < 3; i++) { // There are 3 POO courses
    		Game.student.addLecture(new Lecture("POO", i)); // add all the lectures
    		System.out.println(Game.resource.getString("POO.course"+ i));
    	}

    	System.out.println(Game.resource.getString("read.book"));
    	Game.student.decreaseEnergy(5); // Decreases the energy of the student
    }

}
