package hogwarts;

import static hogwarts.model.House.*;
import hogwarts.model.*;
import hogwarts.model.Castle.SameNameException;

public class Hogwarts {
    
    /** Create castle Hogwarts. */
    public static Castle makeHogwarts() {
        try {
            Castle hogwarts = new Castle();
            
            hogwarts.add(new Wizard(hogwarts, Gryffindor, "Harry Potter"));
            hogwarts.add(new Wizard(hogwarts, Gryffindor, "Hermione Granger"));
            hogwarts.add(new Wizard(hogwarts, Gryffindor, "Ron Weasley"));
            hogwarts.add(new Wizard(hogwarts, Gryffindor, "Albus Dumbledore"));
            hogwarts.add(new Wizard(hogwarts, Hufflepuff, "Cedric Diggory"));
            hogwarts.add(new Wizard(hogwarts, Slytherin, "Severus Snape"));
            
            hogwarts.lookup("Harry Potter").friend(hogwarts.lookup("Hermione Granger"));
            hogwarts.lookup("Harry Potter").friend(hogwarts.lookup("Ron Weasley"));
            hogwarts.lookup("Hermione Granger").friend(hogwarts.lookup("Ron Weasley"));
            hogwarts.lookup("Harry Potter").friend(hogwarts.lookup("Albus Dumbledore"));
            hogwarts.lookup("Severus Snape").friend(hogwarts.lookup("Albus Dumbledore"));
            
            return hogwarts;
        } catch (SameNameException sne) {
            sne.printStackTrace();
            throw new AssertionError("shouldn't happen");
        }
    }
}
