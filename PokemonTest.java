package de.uni.hd.isw.pokemon;

import java.util.EventListenerProxy;

public class PokemonTest {
    public static void main(String[] args) {
        //Testen von Pokemon.java
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


        //Testen von Trainer.java
        //Testen von Trainer erstellen
        Trainer t1 = new Trainer("Glenn","Zundel");
        System.out.println();
        System.out.println("Testen von Konstruktor Trainer und von toString()");
        System.out.println("Neuer Trainer wurde erstellt, firstname solle Glenn sein und lastname Zundel: ");
        System.out.println(t1.toString());

        //Testen von linkPokemonToTrainer()
        t1.LinkPokemonToTrainer(Evoli);
        t1.LinkPokemonToTrainer(Plinfa);
        System.out.println("Trainer sollte jetzt die Pokemon Flamara und Plinfa besitzen: ");
        t1.ListPokemonForTrainerInTerminal();
        System.out.println("Jetzt sollten alle Pokemon des Trainers vom Typ Feuer (Flamara) erscheinen: ");
        t1.ListPokemonByTypeInTerminal(Type.FIRE);
        System.out.println("Jetzt sollte das zweite Pokemon des Trainers (Plinfa) erscheinen: ");
        t1.showIthPokemonInTerminal(1);

        //Testen von owner der Pokemon
        System.out.println("Hier sollte jetzt der Besitzer von Flamara (vorher Evoli) erscheinen: ");
        System.out.println(Evoli.getOwner());

        Trainer t2 = new Trainer("Anna", "Schwegmann");
        t2.LinkPokemonToTrainer(Plinfa);
        //Testen von Swap.java
        // Testen vom Konstruktor
        Swap Tausch1;
        Tausch1 = new Swap(Evoli, t1, Plinfa, t2);
        System.out.println();
        System.out.println("Testen vom Konstruktor & toString()");
        System.out.println("Hier sollte stehen: beide Trainer und Pokemon, Datum und ID");
        System.out.println(Tausch1.toString());
        // Testen von Swap.execute()
        System.out.println();
        System.out.println("Testen von Swap.Execute()");
        Tausch1.Execute();
        // Test haben Pokemon anderen Besitzer?
        System.out.println("Neuer owner von p1 (=t2) = ");
        System.out.println(Evoli.getOwner());
        System.out.println("neuer Owner von p2 (=t1) = ");
        System.out.println(Plinfa.getOwner());
        //Test haben Trainer neues Pokemon in ihrer Liste und altes gelöscht?
        System.out.println();
        System.out.println("p1 ist in der Liste von t2 = " + t2.PokemonList.contains(Evoli));
        System.out.println("p2 ist in der Liste von t1 = " + t1.PokemonList.contains(Plinfa));
        System.out.println("p1 ist immer noch in der Liste von t1 = " + t1.PokemonList.contains(Evoli));
        System.out.println("p2 ist immer noch in der Liste von t2 = " + t2.PokemonList.contains(Plinfa));
        System.out.println("Haben Pokemons den Swap in ihrer Liste?");
        System.out.println("p1 hat so viele Swaps (erwartet 1): " + Evoli.Swaps.size());
        System.out.println("p1 hat folgenden Swap in seiner Liste: " + Evoli.Swaps.get(0));

        System.out.println();
        //Testen der Exceptions
        System.out.println("Exception: Pokemon haben gleichen Trainer");
        Pokemon Relaxo = new Pokemon("Relaxo", Type.NORMAL);
        t2.LinkPokemonToTrainer(Relaxo);
        Swap TauschGleicherOwner = new Swap(Evoli, t2, Relaxo, t2);
        TauschGleicherOwner.Execute();
        // Kontrolle, dass Pokemon immer noch beide zu t2 gehören
        System.out.println("p1 ist in der Liste von t2 = " + t2.PokemonList.contains(Evoli));
        System.out.println("p2 ist in der Liste von t2 = " + t2.PokemonList.contains(Relaxo));
        System.out.println("owner von p1 ist immer noch t2 (Anna) =" + Evoli.getOwner());
        System.out.println("owner von p2 ist immer noch t2 (Anna) = " + Relaxo.getOwner());

        //Exception 2: p1 gehört nicht zu t1
        System.out.println();
        System.out.println("Exception: Pokemon p1 gehört nicht t1");
        Trainer BugCatcher = new Trainer("Karl", "Bug Catcher");
        Pokemon Raupy = new Pokemon("Raupy", Type.INSECT);
        BugCatcher.LinkPokemonToTrainer(Raupy);
        Swap p1Nichtt1 = new Swap(Raupy, t1, Evoli, t2);
        p1Nichtt1.Execute();
        System.out.println("Kontrolle, dass kein Tausch durchgeführt wurde: ");
        System.out.println("p2 ist in der Liste von t2 = " + t2.PokemonList.contains(Evoli));

        //Exception 3: p1 ist nicht swappable
        System.out.println();
        System.out.println("Exception: Pokemon p1 ist nicht swappable");
        Raupy.IsSwapAllowed = false;
        Swap p1NoSwapAllowed = new Swap(Raupy, BugCatcher, Evoli, t2);
        p1NoSwapAllowed.Execute();
        //Kontrolle, dass kein Tausch durchgeführt wurde:
        System.out.println("p2 ist in der Liste von t2 = " + t2.PokemonList.contains(Relaxo));

        //Exception 4: p2 gehört nicht t2
        System.out.println();
        System.out.println("Exception: Pokemon p2 gehört nicht t2");
        Swap p2Nichtt2 = new Swap(Raupy, BugCatcher, Evoli, t1);
        p2Nichtt2.Execute();
        System.out.println("Kontrolle, dass kein Tausch durchgeführt wurde: ");
        System.out.println("p1 ist in der Liste von t1 = " + BugCatcher.PokemonList.contains(Raupy));

        //Exception 5: p2 ist nicht swappable
        System.out.println();
        System.out.println("Exception: Pokemon p2 ist nicht swappable");
        Relaxo.IsSwapAllowed = false;
        Swap p2NoSwapAllowed = new Swap(Plinfa, t1, Relaxo, t2);
        p2NoSwapAllowed.Execute();
        System.out.println("Kontrolle, dass kein Tausch durchgeführt wurde: ");
        System.out.println("p2 ist in der Liste von t2 = " + t2.PokemonList.contains(Relaxo));

    }
}
