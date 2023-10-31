/*
 * PokemonTest
 * Copyright Glenn Zundel & Anna Schwegmann
 */
package de.uni.hd.isw.pokemon;
public class PokemonTest {
    public static void main(String[] args) {
        //Testen von Pokemon.java
        // Testen vom Konstruktor & toString()
        Pokemon evoli;
        evoli = new Pokemon("evoli", Type.NORMAL);
        System.out.println("Testen vom Konstruktor & toString()");
        System.out.println("Hier sollte stehen: This Pokemon is called evoli and is type NORMAL. It's ID is 1");
        System.out.println(evoli.toString());
        // Testen von getName()
        System.out.println();
        System.out.println("Testen von getName");
        System.out.println("Name von Pokemon evoli:");
        System.out.println(evoli.getName());

        //Testen von getType()
        System.out.println();
        System.out.println("Testen von getType");
        System.out.println("Type von evoli (Normal) = ");
        System.out.println(evoli.getType());

        //Testen von getNumber()
        System.out.println();
        System.out.println("Testen von getNumber");
        System.out.println("Number von evoli (1) = ");
        System.out.println(evoli.getNumber());

        // Testen von setName()
        System.out.println();
        System.out.println("Testen von setName");
        System.out.println("Alter Name: ");
        System.out.println(evoli.getName());
        evoli.setName("Flamara");
        System.out.println("Neuer Name: ");
        System.out.println(evoli.getName());

        // Testen von setType()
        System.out.println();
        System.out.println("Testen von setType");
        System.out.println("Alter type: ");
        System.out.println(evoli.getType());
        evoli.setType(Type.FIRE);
        System.out.println("Neuer type: ");
        System.out.println(evoli.getType());

        //Testen von getNextNumber()
        System.out.println();
        System.out.println("Testen von getNextNumber()");
        System.out.println("Nur der Konstruktor sollte NextNumber verändert haben, NextNumber sollte 2 sein: ");
        System.out.println(Pokemon.getNextNumber());
        Pokemon plinfa = new Pokemon("plinfa", Type.WATER);
        System.out.println("Neues Pokemon wurde erstellt, NextNumber müsste von allen Pokemons 3 sein: ");
        System.out.println(Pokemon.getNextNumber());
        System.out.println(Pokemon.getNextNumber());


        //Testen von Trainer.java
        //Testen von Trainer erstellen
        Trainer t1 = new Trainer("Glenn","Zundel");
        System.out.println();
        System.out.println("Testen von Konstruktor Trainer und von toString()");
        System.out.println("Neuer Trainer wurde erstellt, firstname solle Glenn sein und lastname Zundel: ");
        System.out.println(t1.toString());

        // Testen von getter & Setter
        // Testen von getName()
        System.out.println();
        System.out.println("Testen von getName");
        System.out.println("Name von Trainer Glenn:");
        System.out.println(t1.getFirstname());
        System.out.println(t1.getLastname());

        // Testen von setName()
        System.out.println();
        System.out.println("Testen von setName");
        System.out.println("Alter Name: ");
        System.out.println(t1.getFirstname());
        t1.setFirstname("Glenni");
        System.out.println("Neuer Name: ");
        System.out.println(t1.getFirstname());

        //Testen von linkPokemonToTrainer()
        t1.linkPokemonToTrainer(evoli);
        t1.linkPokemonToTrainer(plinfa);
        System.out.println("Trainer sollte jetzt die Pokemon Flamara und plinfa besitzen: ");
        t1.listPokemonForTrainerInTerminal();
        System.out.println("Jetzt sollten alle Pokemon des Trainers vom Typ Feuer (Flamara) erscheinen: ");
        t1.listPokemonByTypeInTerminal(Type.FIRE);
        System.out.println("Jetzt sollte das zweite Pokemon des Trainers (plinfa) erscheinen: ");
        t1.showIthPokemonInTerminal(1);

        //Testen von owner der Pokemon
        System.out.println("Hier sollte jetzt der Besitzer von Flamara (vorher evoli) erscheinen: ");
        System.out.println(evoli.getOwner());

        Trainer t2 = new Trainer("Anna", "Schwegmann");
        t2.linkPokemonToTrainer(plinfa);
        //Testen von Swap.java
        // Testen vom Konstruktor
        Swap tausch1;
        tausch1 = new Swap(evoli, t1, plinfa, t2);
        System.out.println();
        System.out.println("Testen vom Konstruktor & toString()");
        System.out.println("Hier sollte stehen: beide Trainer und Pokemon, Datum und ID");
        System.out.println(tausch1.toString());
        // Testen von Swap.execute()
        System.out.println();
        System.out.println("Testen von Swap.Execute()");
        tausch1.execute();
        // Test haben Pokemon anderen Besitzer?
        System.out.println("Neuer owner von p1 (=t2) = ");
        System.out.println(evoli.getOwner());
        System.out.println("neuer Owner von p2 (=t1) = ");
        System.out.println(plinfa.getOwner());
        //Test haben Trainer neues Pokemon in ihrer Liste und altes gelöscht?
        System.out.println();
        System.out.println("p1 ist in der Liste von t2 = " + t2.getPokemonList().contains(evoli));
        System.out.println("p2 ist in der Liste von t1 = " + t1.getPokemonList().contains(plinfa));
        System.out.println("p1 ist immer noch in der Liste von t1 = " + t1.getPokemonList().contains(evoli));
        System.out.println("p2 ist immer noch in der Liste von t2 = " + t2.getPokemonList().contains(plinfa));
        System.out.println("Haben Pokemons den Swap in ihrer Liste?");
        System.out.println("p1 hat so viele Swaps (erwartet 1): " + evoli.getswaps().size());
        System.out.println("p1 hat folgenden Swap in seiner Liste: " + evoli.getswaps().get(0));

        System.out.println();
        //Testen der Exceptions
        System.out.println("Trainer ist null");
        Swap swaptest = new Swap(plinfa, null, evoli, t1);
        swaptest.execute();



        System.out.println("Exception: Pokemon haben gleichen Trainer");
        Pokemon relaxo = new Pokemon("relaxo", Type.NORMAL);
        t2.linkPokemonToTrainer(relaxo);
        Swap tauschGleicherOwner = new Swap(evoli, t2, relaxo, t2);
        tauschGleicherOwner.execute();
        // Kontrolle, dass Pokemon immer noch beide zu t2 gehören
        System.out.println("p1 ist in der Liste von t2 = " + t2.getPokemonList().contains(evoli));
        String p2BelongsToT2 = "p2 ist in der Liste von t2 = ";
        System.out.println(p2BelongsToT2 + t2.getPokemonList().contains(relaxo));
        System.out.println("owner von p1 ist immer noch t2 (Anna) =" + evoli.getOwner());
        System.out.println("owner von p2 ist immer noch t2 (Anna) = " + relaxo.getOwner());

        //Exception 2: p1 gehört nicht zu t1
        System.out.println();
        System.out.println("Exception: Pokemon p1 gehört nicht t1");
        Trainer bugCatcher = new Trainer("Karl", "Bug Catcher");
        Pokemon raupy = new Pokemon("raupy", Type.INSECT);
        bugCatcher.linkPokemonToTrainer(raupy);
        Swap p1Nichtt1 = new Swap(raupy, t1, evoli, t2);
        p1Nichtt1.execute();
        String controlNoSwap = "Kontrolle, dass kein Tausch durchgeführt wurde: ";
        System.out.println(controlNoSwap);

        System.out.println(p2BelongsToT2 + t2.getPokemonList().contains(evoli));

        //Exception 3: p1 ist nicht swappable
        System.out.println();
        System.out.println("Exception: Pokemon p1 ist nicht swappable");
        raupy.setSwapNotAllowed();
        Swap p1NoSwapAllowed = new Swap(raupy, bugCatcher, evoli, t2);
        p1NoSwapAllowed.execute();
        System.out.println(controlNoSwap);
        System.out.println(p2BelongsToT2 + t2.getPokemonList().contains(relaxo));

        //Exception 4: p2 gehört nicht t2
        System.out.println();
        System.out.println("Exception: Pokemon p2 gehört nicht t2");
        Swap p2Nichtt2 = new Swap(raupy, bugCatcher, evoli, t1);
        p2Nichtt2.execute();
        System.out.println(controlNoSwap);
        System.out.println("p1 ist in der Liste von t1 = " + bugCatcher.getPokemonList().contains(raupy));

        //Exception 5: p2 ist nicht swappable
        System.out.println();
        System.out.println("Exception: Pokemon p2 ist nicht swappable");
        relaxo.setSwapNotAllowed();
        Swap p2NoSwapAllowed = new Swap(plinfa, t1, relaxo, t2);
        p2NoSwapAllowed.execute();
        System.out.println("Kontrolle, dass kein Tausch durchgeführt wurde: ");
        System.out.println("p2 ist in der Liste von t2 = " + t2.getPokemonList().contains(relaxo));

    }
}
