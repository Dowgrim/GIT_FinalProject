package zuul.student;

/**
 * A class for all the items possible, described with the description instance variable
	@author Cindy NAJJAR
*/

public class Item {
    
    protected String description;
    
    public Item(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
    	return description;
    }

}
