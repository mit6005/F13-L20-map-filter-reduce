package hogwarts;

import hogwarts.model.*;
import hogwarts.model.Castle.SameNameException;

import java.util.List;

public class WizardProcs {
    
    static List<String> names(List<Wizard> wizards) {
        // ...
    }
    
    static List<House> houses(List<Wizard> wizards) {
        // ...
    }
    
    static List<Wizard> friendly(List<Wizard> wizards) {
        // ...
    }
    
    static int countHufflepuffs(List<Wizard> wizards) {
        // ...
    }
    
    static Wizard lastByName(List<Wizard> wizards) {
        // ...
    }
    
    public static void main(String[] args) throws SameNameException {
        Castle castle = Hogwarts.makeHogwarts();
        List<Wizard> wizards = castle.wizards();
        
        System.out.println("Wizards:     " + wizards);
        System.out.println("Names:       " + names(wizards));
        System.out.println("Houses:      " + houses(wizards));
        System.out.println("Friendly:    " + friendly(wizards));
        System.out.println("Hufflepuffs: " + countHufflepuffs(wizards));
        System.out.println("Lex last:    " + lastByName(wizards));
    }
}
