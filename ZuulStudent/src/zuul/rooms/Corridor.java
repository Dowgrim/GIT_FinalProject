package zuul.rooms;

/**
 * @author Cindy Najjar and Nicolas Hory
 */

import zuul.student.Game;

public class Corridor extends Room {

	private boolean isLighted; // Says if the corridor light is on or off

	public Corridor(String description) {
		super(description);
		this.isLighted = false;			
	}

	public boolean isLighted() {
		return isLighted;
	}

	public void setLighted(boolean isLighted) {
		this.isLighted = isLighted;
	}
	
	/**
	 * Says to the player if the light is on or off
	 */
	public void printStateLight() {    	
    		if (this.isLighted()) {
    			System.out.println(Game.resource.getString("light.yes"));
    		} else {
    			System.out.println(Game.resource.getString("light.no"));
    		}    	
    }
	
	/**
	 * Changes the value of isLighted, called with the command 'light'
	 */
	 public void changeLight() {
	            if (isLighted) {
	                setLighted(false);
	            } else {
	                setLighted(true);
	            }
	            printStateLight(); // Prints the new state of the light
	            if (isLighted) { // If the light was off before, now prints the objects present
	            	this.displayObjects();
	            }
	}

}
