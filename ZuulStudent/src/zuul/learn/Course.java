package zuul.learn;
/**
	@author Cindy NAJJAR
**/


public abstract class Course {
    
    private String matiere;       

    public Course(String matiere) {        
        this.matiere = matiere;     
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    /**
     * The function getNumber is abstract so that we can override it in the two
     * classes that instanciate it (Lecture and LabSession)
     * @return the number of the course
     */
    abstract public int getNumber();
    
    /**
     * Prints all the courses the student has. We decided to put it in this class and not in student
     * because by declaring it as abstract, we can override it for lectures and labs
     */
    abstract public void printCourse();
  
}
