package zuul.learn;

import zuul.student.Game;

/**
 * An enum containing the three possible classes of lectures and labs
 * @author Nicolas Hory
 */

public enum Subject {
	POO,
	ALGO,
	MATHS;
	
	 public String toString() {
		return Game.resource.getString(name() + ".enum");
	}
	
	 /**
	  * Allows to get a random subject
	  * @return a random subject, with more chance that it is a POO one
	  */
	public static Subject getRandom() {
		int subj = (int)(Math.random() * 100);
		if (subj > 30) {  	// There is 70% chance that the subject is POO
			return values()[0];
		} else if (15 <= subj && subj <= 30 ) {  // There is 30% chance that it's another subject
			return values()[1];
		} else {
			return values()[2];
		}
	}
}
