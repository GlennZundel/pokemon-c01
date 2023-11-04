package de.uni.hd.isw.pokemon;

import java.util.Random;
public class Competition extends Swap {
    Random r = new Random();
    public Competition(Pokemon p01, Pokemon p02){
        p1 = p01;
        t1 = p01.getOwner();
        p2 = p02;
        t2 = p02.getOwner();
        date = new java.util.Date();
        id = nextNumber;
        nextNumber++;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", date=" + date +
                ", id=" + id +
                '}';
    }

    public boolean noExceptions(){
        try {
            if (t1 == null || t2 == null) {
                throw new SwapException("Error: Trainer does not exist");
            }
        } catch(SwapException ex) {
            System.out.println(ex);
            return false;
        }
        // check if t1 uneq t2
        try {
            if (t1 == t2) {
                throw new SwapException("Error: Competition not Allowed for same trainer");
            }
        } catch(SwapException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }
    public void combat(){
        // random Startwert
        int p1score = r.nextInt(100);
        int p2score = r.nextInt(100);

        // Gewichtung nach Typ, print von Ergebnis, Ergebniserstellung über winner()
        if (p1.getType() == p2.getType()){
            System.out.println(winner(p1score, p2score));
        }
        else {
            switch(p1.getType()) {
                case NORMAL:
                    System.out.println(winner(p1score, p2score));
                    break;
                case POISON:
                    if (p2.getType() == Type.WATER) {
                        p1score = p1score * 2;
                        System.out.println(winner(p1score, p2score));
                    } else if (p2.getType() == Type.FIRE) {
                        p2score = p2score * 2;
                        System.out.println(winner(p1score, p2score));
                    } else if (p2.getType() == Type.INSECT) {
                        System.out.println(winner(p1score, p2score));
                    }
                    break;
                case WATER:
                    if (p2.getType() == Type.POISON) {
                        p2score = p2score * 2;
                        System.out.println(winner(p1score, p2score));
                    }
                    if (p2.getType() == Type.FIRE) {
                        p1score = p1score * 2;
                        System.out.println(winner(p1score, p2score));
                    }
                    if (p2.getType() == Type.INSECT) {
                        System.out.println(winner(p1score, p2score));
                    }
                    break;
                case FIRE:
                    if (p2.getType() == Type.INSECT || p2.getType() == Type.POISON) {
                        p1score = p1score * 2;
                        System.out.println(winner(p1score, p2score));
                    }
                    if (p2.getType() == Type.WATER) {
                        p1score = p1score * 2;
                        System.out.println(winner(p1score, p2score));
                    }
                    break;
                case INSECT:
                    if (p2.getType() == Type.FIRE || p2.getType() == Type.POISON) {
                        p2score = p2score * 2;
                        System.out.println(winner(p1score, p2score));
                    } else if (p2.getType() == Type.WATER) {
                        System.out.println(winner(p1score, p2score));
                    }
                    break;
                default:
                    System.out.println("Type Constellation not yet implementet");
                    break;
            }
        }
    }
    @Override
    public void execute(){
        // check Exceptions
        if(!noExceptions()){
            return;
        }
        // führe Kampf aus
        combat();
    }
    public String winner(int p1score, int p2score){
        if (p1score > p2score){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pokemon ");
            stringBuilder.append(p1.getName());
            stringBuilder.append(" wins with score of ");
            stringBuilder.append(p1score);
            stringBuilder.append(" over score of ");
            stringBuilder.append(p2score);
            p1.setcompetitions(this);
            p2.setcompetitions(this);
            p2.setOwner(t1);
            t2.removePokemonList(p2);
            return stringBuilder.toString();
        } else if (p1score < p2score) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pokemon ");
            stringBuilder.append(p2.getName());
            stringBuilder.append(" wins with score of ");
            stringBuilder.append(p2score);
            stringBuilder.append(" over score of ");
            stringBuilder.append(p1score);
            p1.setcompetitions(this);
            p2.setcompetitions(this);
            p1.setOwner(t2);
            t1.removePokemonList(p1);
            return stringBuilder.toString();
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("It's a draw!");
            stringBuilder.append("Both Pokemon have a score of: ");
            stringBuilder.append(p1score);
            stringBuilder.append(" ");
            stringBuilder.append(p2score);
            p1.setcompetitions(this);
            p2.setcompetitions(this);
            return stringBuilder.toString();
        }
    }
}
