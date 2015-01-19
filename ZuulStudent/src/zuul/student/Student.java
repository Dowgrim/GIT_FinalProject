package zuul.student;

import java.util.*;
import zuul.learn.*;

/**
 * A class to describe a student
	@author Nicolas HORY and Cindy Najjar 
*/


public class Student {
	 private int energy; 
	 public ArrayList<Item> items = new ArrayList<Item>();
	 public ArrayList<Lecture> lectures = new ArrayList<Lecture>();
	 public ArrayList<LabSession> labs = new ArrayList<LabSession>();
	 private String name;

	public Student(String nom) {
		name = nom;
		energy = 100; // The student begins with an energy level of 100
	}
	
	public int getEnergy() {
        return energy;
    }


	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public ArrayList<LabSession> getLabs() {
		return labs;
	}
	
	/**
	 * Adds a lecture to the student's list
	 * @param lecture
	 */
	public void addLecture(Lecture lecture) {
		boolean knowLecture = checkLabOrLecture(lecture); // Checks if the student already knows it
		if (!knowLecture) { // If he doesnt
			System.out.println(Game.resource.getString("lect.present"));
			System.out.println(Game.resource.getString(lecture.getMatiere() + ".course"+ lecture.getNumber()));
			lectures.add(lecture); // Adds the lecture to the student
			System.out.println(Game.resource.getString("learn.lect") + lecture.getMatiere() + lecture.getNumber());
			new Lecture(null, 0).printCourse(); // Prints the lectures of the student
			decreaseEnergy(5); // Decreases the student's energy
		} else {
			System.out.println(Game.resource.getString("know.lect") + lecture.getMatiere() + lecture.getNumber());
		}
	}
	
	
	/**
	 * Checks if the student knows the object passed in parameter
	 * @param object
	 * @return a boolean telling if the student knows it
	 */
	private boolean checkLabOrLecture(Object object) {
		ArrayList list = new ArrayList<>();
		boolean alreadyKnown = false;
		if (object instanceof Lecture) { // In function of the object's class, changes the list useds
			 list = lectures;
		} else {
			list = labs;
		}
		for (Object element : list) { // Browses the list
			if (((Course) element).getMatiere().equals(((Course) object).getMatiere()) && ((Course) element).getNumber() == ((Course) object).getNumber()) {
				alreadyKnown = true; // The student already knows it
				break;
			}
		}
		return alreadyKnown; // Returns the boolean telling is the student already knows the lab or lecture
	}
	
	/**
	 * Adds a lab to the student's list
	 * @param lab
	 */
	public void addLab(LabSession lab) {
		boolean knowLab = checkLabOrLecture(lab);
		Lecture lecture = new Lecture (lab.getMatiere(), lab.getNumber());
		boolean knowLecture = checkLabOrLecture(lecture); // The corresponding lecture
		if (!knowLab) { // If doesn't know the lab yet
			 if (knowLecture) { // If knows the corresponding lecture
				System.out.println(Game.resource.getString("lab.present"));
				System.out.println(Game.resource.getString(lab.getMatiere() + ".lab"+ lab.getNumber()));
				labs.add(lab); // Adds it to the student
				System.out.println(Game.resource.getString("learn.lab") + lab.getMatiere() + lab.getNumber());
				new LabSession(null, 0).printCourse(); // Prints all the labs
				decreaseEnergy(5);  // Decreases the student's energy
			 } else {
				 System.out.println(Game.resource.getString("unk.lect1") + lab.getMatiere() + lab.getNumber() + Game.resource.getString("unk.lect2"));
			 }
		} else {
			System.out.println(Game.resource.getString("know.lab1") + lab.getMatiere() + lab.getNumber() + Game.resource.getString("know.lab2"));
		}
		
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void increaseEnergy (int level) {
		this.energy += level;
	}
	
	/**
	 * Decreases the energy of the student of 'level' points
	 * @param level
	 */
	public void decreaseEnergy (int level) {
		this.energy -= level;
		System.out.println(Game.resource.getString("dec.energy") + level + " points..");
		System.out.println(Game.resource.getString("energy.lvl") + energy + " points ");
	}
	
	/**
	 * If the student plays babyfoot, then he will forget one lecture
	 */
	 public void playBabyfoot() {
	    	/* Playing babyfoot makes the student forget one lecture */
	    	System.out.println(Game.resource.getString("play.baby"));
	    	decreaseEnergy(5); // Decreases the student's energy
	    	forgetLecture(); // Calls the function forgetCourse()
	    }    
	
	/**
	 * The student drinks a coffee (if he has one), and gets some energy points back
	 */
	public void drinkCoffee() {
		boolean foundCoffee = checkItem("Coffee"); // Checks if has a coffee
		if (foundCoffee) { 
			increaseEnergy(10); // If has one, increases the energy of the student
			System.out.println(Game.resource.getString("drink.cof") + this.getEnergy() + Game.resource.getString("energy.pts"));
		} else {
			System.out.println(Game.resource.getString("error.cof"));
		}		
	}
	
	/**
	 * Allows the student to use a tablet, which will launch a lecture, lab, or game
	 */
	public void useTablet() {
		System.out.println(Game.resource.getString("play.tablet"));
		int play = (int)(Math.random() * 2); // There is one chance on 2 to play or listen a lecture
		if (play == 0) {
			playVideoGame();
		} else {
			getTabletLectureOrLab(); // Learns a lecture or a lab
		}
		decreaseEnergy(5); // Decreases the student's energy
	}
	
	/**
	 * In the case the tablet opened a lecture, creates randomly a lab or a lecture
	 */
	private void getTabletLectureOrLab() {
		System.out.println(Game.resource.getString("tablet.learn"));
		int lectOrLab = (int)(Math.random() * 2); // Gets a random number to choose between lab and lecture
		int number = (int)(Math.random() * 3); // Gets a random number of course
		String matiere = Subject.getRandom().toString();
		if (matiere.equals("POO")) { // We add a lecture or lab only if it's POO one		
			if (lectOrLab == 0) {
				addLecture(new Lecture (matiere, number)); // Adds the new lecture
			} else {
				addLab(new LabSession (matiere, number)); // Adds the new lab
			}
		} else {
			System.out.println(Game.resource.getString("tab.prob"));
		}
	}
		
	/**
	 * Checks if the student has an item
	 * @param the item we want to check
	 * @return a boolean telling if the student has it
	 */
	public boolean checkItem(String item) {
		boolean foundItem = false;
		for (Item e : items) { // Browses the items the student have
			if (e.getDescription().equals(item)) {
				foundItem = true;
				if (item.equals("Coffee")) {
					items.remove(e); // We remove the item only if it's a coffee
				}
				break;
			}
		}
		return foundItem;
	}
	
	/**
	 * Launches a game, which can randomly be World of Zuul or another one
	 */
	private void playVideoGame() {
		System.out.println(Game.resource.getString("video.game"));
	    int zuul = (int)(Math.random() * 2); // One chance on two that the game is World of Zuul
	    if (zuul == 0) {
	    	System.out.println(Game.resource.getString("play.zuul"));
	    } else {
	        System.out.println(Game.resource.getString("play.game"));
	        forgetLecture(); // Calls the function forgetLecture()
	    }
	}
	
	/**
	 * Makes the student forget a lecture (if he already followed atleast once)
	 */
	public void forgetLecture() {
		if (!lectures.isEmpty()) // If the list isn't empty
		{
	        int ind = (int)(Math.random() * lectures.size()); // takes one random indice
	        Lecture lect = lectures.get(ind);
	        System.out.println(Game.resource.getString("forgot.course") + lect.getMatiere() + lect.getNumber());
	        forgetLab(lectures.get(ind).getMatiere(), lectures.get(ind).getNumber()); // Makes the student forget the corresponding lab
	        lectures.remove(ind); // Removes the lecture
	        new Lecture(null, 0).printCourse();  // Prints all the lectures of the student
		} else {
			System.out.println(Game.resource.getString("no.lectures")); // Else printns an error message
		}
	}
	
	/**
	 * Makes the student forget a lab session
	 * @param the number and the subject of the lab
	 */
	public void forgetLab(String matiere, int number) {
		if (!labs.isEmpty()) { // If the student already followed atleast one lab
			int index = -1;
	        for (LabSession lab : labs) {
	        	if (lab.getMatiere().equals(matiere) && lab.getNumber() == number) {
	        		System.out.println(Game.resource.getString("forgot.lab") + lab.getMatiere() + lab.getNumber());
	        		index = labs.indexOf(lab); // Gets the index of the lab
	        		break;
	        	}
	        }
	        if (index != -1) {
	        	labs.remove(index); // Removes the lab if the index changed from the initial (-1)
	        }
		}
		new LabSession(null, 0).printCourse(); // Prints all the labs
	}
	
	/**
	 * Prints the items present in the student's bag
	 */
	public void printBag() {
		if (items.isEmpty()) { // If the bag is empty, prints a message
			System.out.println(Game.resource.getString("empty.inv"));
		} else {
			System.out.print(Game.resource.getString("list.item"));
	        for (Item f : items) { // Prints all the items the student have
	        	System.out.print(f.getDescription() + " ");
	        }
	        System.out.println();
		}
	}
	
	/**
	 * Allows to find if a book is present in the bag
	 * @return -1 if there is no book, else the indice of the book in the list
	 */
	
	public int findBook() {
		int indice = -1; // Default value, to see if there is a book
		for (Item item : items) {
			if (item instanceof Book) {
				indice = items.indexOf(item); // Gets the index of the book
				break;
			}
		}
		return indice;
	}
	
	/**
	 * Checks if the student can do the exam
	 * @return a boolean
	 */
	public boolean canDoExam() {
        boolean canDo = true;
        if ((this.getEnergy() < 20) || (lectures.size() != 3) || (labs.size() != 3)) {
            canDo = false; // The student needs atleast 20 energy points, and all the labs and lectures
        }
        return canDo;
    }
	
	/**
	 * Checks the energy of the student, and gives points if he has not enough
	 */
	public void checkEnergy() {
		if (energy < 20) { // If the energy is low
			System.out.println(Game.resource.getString("go.sleep"));
			increaseEnergy(50); // The student 'sleeps' and gets 50 energy points
			System.out.println(Game.resource.getString("new.energy") + energy + " points");
		}
	}
}
