package hogwarts;

import static mfr.MapFilterReduce.*;
import hogwarts.model.*;

import java.util.List;

import mfr.MapFilterReduce.BinOp;
import mfr.MapFilterReduce.Function;
import mfr.MapFilterReduce.Predicate;

public class WizardProcs3 {
    
    static Predicate<Wizard> inHouse(final House house) {
        return new Predicate<Wizard>() {
            public boolean apply(Wizard wizard) {
                return wizard.getHouse() == house;
            }
        };
    }
    
    static <T, U extends Comparable<U>> BinOp<T,T,T> greaterBy(final Function<T,U> fn) {
        return new BinOp<T,T,T>() {
            public T apply(T a, T b) {
                if (fn.apply(a).compareTo(fn.apply(b)) > 0) {
                    return a;
                } else {
                    return b;
                }
            }
        };
    }
    
    public static void main(String[] args) {
        Castle castle = Hogwarts.makeHogwarts();
        List<Wizard> wizards = castle.wizards();
        
        Function<Wizard, String> name = new Function<Wizard, String>() {
            public String apply(Wizard wizard) {
                return wizard.getName();
            }
        };
        
        System.out.println("Wizards:     " +
            wizards);
        
        System.out.println("Names:       " +
            map(name, wizards));
        
        System.out.println("Houses:      " +
            map(new Function<Wizard, House>() {
                public House apply(Wizard wizard) {
                    return wizard.getHouse();
                }
            }, wizards));
        
        System.out.println("Friendly:    " +
            filter(new Predicate<Wizard>() {
                public boolean apply(Wizard wizard) {
                    return wizard.getFriends().size() > 2;
                }
            }, wizards));
        
        System.out.println("Hufflepuffs: " +
            filter(inHouse(House.Hufflepuff), wizards).size());
        
        System.out.println("Lex last:    " +
            reduce(wizards, greaterBy(name), wizards.get(0)));
    }
}
