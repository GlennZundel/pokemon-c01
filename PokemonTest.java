package de.uni.hd.isw.pokemon;

import java.util.EventListenerProxy;

public class PokemonTest {
    public static void main(String[] args) {
        // Testen vom Konstruktor & toString()
        Pokemon Evoli;
        Evoli = new Pokemon("Evoli", Type.NORMAL);
        System.out.println("Testen vom Konstruktor & toString()");
        System.out.println("Hier sollte stehen: This Pokemon is called Evoli and is type NORMAL. It's ID is 1");
        System.out.println(Evoli.toString());
        // Testen von getName()
        System.out.println();
        System.out.println("Testen von getName");
        System.out.println("Name von Pokemon Evoli:");
        System.out.println(Evoli.getName());

        //Testen von getType()
        System.out.println();
        System.out.println("Testen von getType");
        System.out.println("Type von Evoli (Normal) = ");
        System.out.println(Evoli.getType());

        //Testen von getNumber()
        System.out.println();
        System.out.println("Testen von getNumber");
        System.out.println("Number von Evoli (1) = ");
        System.out.println(Evoli.getNumber());

        // Testen von setName()
        System.out.println();
        System.out.println("Testen von setName");
        System.out.println("Alter Name: ");
        System.out.println(Evoli.getName());
        Evoli.setName("Flamara");
        System.out.println("Neuer Name: ");
        System.out.println(Evoli.getName());

        // Testen von setType()
        System.out.println();
        System.out.println("Testen von setType");
        System.out.println("Alter type: ");
        System.out.println(Evoli.getType());
        Evoli.setType(Type.FIRE);
        System.out.println("Neuer type: ");
        System.out.println(Evoli.getType());

        //Testen von getNextNumber()
        System.out.println();
        System.out.println("Testen von getNextNumber()");
        System.out.println("Nur der Konstruktor sollte NextNumber verändert haben, NextNumber sollte 2 sein: ");
        System.out.println(Evoli.getNextNumber());
        Pokemon Plinfa = new Pokemon("Plinfa", Type.WATER);
        System.out.println("Neues Pokemon wurde erstellt, NextNumber müsste von allen Pokemons 3 sein: ");
        System.out.println(Evoli.getNextNumber());
        System.out.println(Plinfa.getNextNumber());
        
        //Testen von Trainer erstellen
        Trainer t = new Trainer("Glenn","Zundel");
        System.out.println();
        System.out.println("Testen von Konstruktor Trainer und von toString()");
        System.out.println("Neuer Trainer wurde erstellt, firstname solle Glenn sein und lastname Zundel: ");
        System.out.println(t.toString());

        //Testen von linkPokemonToTrainer()
        t.LinkPokemonToTrainer(Evoli);
        t.LinkPokemonToTrainer(Plinfa);
        System.out.println("Trainer sollte jetzt die Pokemon Flamara und Plinfa besitzen: ");
        t.ListPokemonForTrainerInTerminal();
        System.out.println("Jetzt sollten alle Pokemon des Trainers vom Typ Feuer (Flamara) erscheinen: ");
        t.ListPokemonByTypeInTerminal(Type.FIRE);
        System.out.println("Jetzt sollte das zweite Pokemon des Trainers (Plinfa) erscheinen: ");
        t.showIthPokemonInTerminal(1);

        //Testen von owner der Pokemon
        System.out.println("Hier sollte jetzt der Besitzer von Flamara (vorher Evoli) erscheinen: ");
        System.out.println(Evoli.getOwner());
    }
}
