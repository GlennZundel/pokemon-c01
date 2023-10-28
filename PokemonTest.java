package de.uni.hd.isw.pokemon;

import java.util.EventListenerProxy;

public class PokemonTest {
    public static void main(String[] args) {
        // Testen vom Konstruktor & toString()
        Pokemon evoli;
        evoli = new Pokemon("Evoli", Type.NORMAL, true);
        System.out.println("Testen vom Konstruktor & toString()");
        System.out.println("Hier sollte stehen: This Pokemon is called Evoli and is type NORMAL. It's ID is 1");
        System.out.println(evoli.toString());
        // Testen von getName()
        System.out.println();
        System.out.println("Testen von getName");
        System.out.println("Name von Pokemon Evoli:");
        System.out.println(evoli.getName());

        //Testen von getType()
        System.out.println();
        System.out.println("Testen von getType");
        System.out.println("Type von Evoli (Normal) = ");
        System.out.println(evoli.getType());

        //Testen von getNumber()
        System.out.println();
        System.out.println("Testen von getNumber");
        System.out.println("Number von Evoli (1) = ");
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
        System.out.println(evoli.getNextNumber());
        Pokemon plinfa = new Pokemon("Plinfa", Type.WATER, true);
        System.out.println("Neues Pokemon wurde erstellt, NextNumber müsste von allen Pokemons 3 sein: ");
        System.out.println(evoli.getNextNumber());
        System.out.println(plinfa.getNextNumber());
        
        //Testen von Trainer erstellen
        Trainer t = new Trainer("Glenn","Zundel");
        System.out.println();
        System.out.println("Testen von Konstruktor Trainer und von toString()");
        System.out.println("Neuer Trainer wurde erstellt, firstname solle Glenn sein und lastname Zundel: ");
        System.out.println(t.toString());

        //Testen von linkPokemonToTrainer()
        t.linkPokemonToTrainer(evoli);
        t.linkPokemonToTrainer(plinfa);
        System.out.println("Trainer sollte jetzt die Pokemon Flamara und Plinfa besitzen: ");
        t.listPokemonForTrainerInTerminal();
        System.out.println("Jetzt sollten alle Pokemon des Trainers vom Typ Feuer (Flamara) erscheinen: ");
        t.listPokemonByTypeInTerminal(Type.FIRE);
        System.out.println("Jetzt sollte das zweite Pokemon des Trainers (Plinfa) erscheinen: ");
        t.showIthPokemonInTerminal(1);

        //Testen von owner der Pokemon
        System.out.println("Hier sollte jetzt der Besitzer von Flamara (vorher Evoli) erscheinen: ");
        System.out.println(evoli.getOwner());

        //Testen von Swap
        Pokemon p1 = new Pokemon("Garados", Type.WATER, true);
        Pokemon p2 = new Pokemon("Karpador", Type.WATER, false);
        Pokemon p3 = new Pokemon("Panflam", Type.FIRE, true);
        Trainer t1 = new Trainer("Anna", "Schwegmann");
        Trainer t2 = new Trainer("Glenn", "Zundel");
        Swap s1 = new Swap();
        Swap s2 = new Swap();
        Swap s3 = new Swap();
        t1.linkPokemonToTrainer(p1);
        t2.linkPokemonToTrainer(p2);
        t2.linkPokemonToTrainer(p3);
        System.out.println("Anna besitzt jetzt das Pokemon Garados. Glenn besitzt die Pokemon Karpador und Panflam, wobei Karpador nicht zum Tausch zugelassen ist.");
        t1.listPokemonForTrainerInTerminal();
        t2.listPokemonForTrainerInTerminal();
        System.out.println("Es wird jetzt versucht Karpador und Panflam zu tauschen: ");
        s1.execute(p2, p3);
        System.out.println("Es wird jetzt versucht Karpador und Garados zu tauschen: ");
        s2.execute(p1,p2);
        System.out.println("Es wird jetzt Panflam und Garados getauscht: ");
        s3.execute(p1,p3);
        System.out.println("Die getauschten Pokemon sollten jetzt neue Besitzer haben und in der Pokemon Liste des jeweils anderen Trainers auftauchen: ");
        t1.listPokemonForTrainerInTerminal();
        t2.listPokemonForTrainerInTerminal();
        p1.toString();
        p3.toString();
        System.out.println("Beide Pokemon sollten jetzt nur jeweils einen Swap mit der ID 1 haben:");
        System.out.println(p1.getSwaps().get(0).toString());
        System.out.println(p3.getSwaps().get(0).toString());
    }
}
