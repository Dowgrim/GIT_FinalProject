package zuul.rooms;

import java.util.Scanner;
import zuul.learn.Subject;
import zuul.student.Game;

/**
 * @author Cindy Najjar
 */

public class ExamRoom extends Room {

    private int nbPts = 0;

    public ExamRoom(String description) {
        super(description);
    }

    /**
     * Generates an exam with a random subject
     */
    public void generateExam() {
        String matiere = Subject.getRandom().toString(); // Gets a random subject
        if (matiere.equals("POO")) { // If it's POO, starts the exam
        	System.out.println(Game.resource.getString("start.exam"));
            Scanner resp = new Scanner(System.in); // Used to get the user's answers
            String answer;
            for (int i = 1; i < 6; i++) { 
            	System.out.println("\nQuestion " + i + " : \n");
                System.out.println(Game.resource.getString("quest." + i));

                if (Game.student.checkItem("Sheet")) { // If the student picked up a sheet
                	System.out.print(Game.resource.getString("help.sheet"));
                    System.out.println(Game.resource.getString("ans." + i)); // Prints the answer with the question
                }

                answer = resp.nextLine();

                if (answer.equals(Game.resource.getString("ans." + i))) { // Checks if the answer is good
                    nbPts++; // Adds a point to the student
                }
                System.out.println(Game.resource.getString("ans.was") + Game.resource.getString("ans." + i)); // Prints the answer
            }
            if (nbPts > 3) { // If the score of the student is more than 4
            	System.out.println(Game.resource.getString("win.game") + nbPts + " points !"); // He won the game
            	System.out.println(Game.resource.getString("finish.game"));
            	System.exit(0);	// Quits the game
            } else {
            	System.out.println(Game.resource.getString("lose.game") + nbPts + " points ..."); // Else he lost the game
            	System.out.println(Game.resource.getString("finish.lose")); // Quits the game
            	System.exit(0);
            }

        } else { // If it's not POO, print a message
            System.out.println(Game.resource.getString("bad.exam") + matiere);
            System.out.println(Game.resource.getString("bad.msg"));

        }
    }

    /**
     * Gives the number of points
     * @return nbPts
     */
    public int getNbPts() {
        return nbPts;
    }
}