package hogwarts;

import hogwarts.model.*;
import hogwarts.model.Castle.SameNameException;

import java.util.ArrayList;
import java.util.List;

public class WizardProcs1 {
    
    static List<String> names(List<Wizard> wizards) {
        List<String> names = new ArrayList<String>();
        for (Wizard wizard : wizards) {
            names.add(wizard.getName());
        }
        return names;
    }
    
    static List<House> houses(List<Wizard> wizards) {
        List<House> houses = new ArrayList<House>();
        for (Wizard wizard : wizards) {
            houses.add(wizard.getHouse());
        }
        return houses;
    }
    
    static List<Wizard> friendly(List<Wizard> wizards) {
        List<Wizard> friendly = new ArrayList<Wizard>();
        for (Wizard wizard : wizards) {
            if (wizard.getFriends().size() > 2) {
                friendly.add(wizard);
            }
        }
        return friendly;
    }
    
    static int countHufflepuffs(List<Wizard> wizards) {
        int count = 0;
        for (Wizard wizard : wizards) {
            if (wizard.getHouse().equals(House.Hufflepuff)) {
                count++;
            }
        }
        return count;
    }
    
    static Wizard lastByName(List<Wizard> wizards) {
        if (wizards.isEmpty()) { throw new IllegalArgumentException(); }
        Wizard last = wizards.get(0);
        for (Wizard wizard : wizards) {
            if (wizard.getName().compareTo(last.getName()) > 0) {
                last = wizard;
            }
        }
        return last;
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
