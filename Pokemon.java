/*
* Pokemon
* Copyright Glenn Zundel & Anna Schwegmann
 */

package de.uni.hd.isw.pokemon;

import java.util.*;

public class Pokemon {
    // Attributes
    private String name;
    private Type type;
    private int number;
    private static int nextNumber = 1;
    private boolean isSwapAllowed = true;
    private List<Swap> swaps = new ArrayList<>();


    private Trainer owner;

    //Konstruktor
    public Pokemon(String s, Type t){
        name = s;
        type = t;
        number = nextNumber;
        nextNumber++;
        owner = null;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public static int getNextNumber() {
        return nextNumber;
    }

    public List<Swap> getswaps(){
        return swaps;
    }

    public boolean getSwapAllowed(){
        return isSwapAllowed;
    }

    //Setters
    public void setName(String name) {
        // "this" ist eine Referenz auf die Instanz, auf der die Methode
        // aufgerufen wurde, zb wenn ich den Namen von der Instanz relaxo
        // ändern möchte und die setName Methode aufrufe ist sichergestellt,
        // das ich den Namen genau dieser Instanz ändere
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Trainer getOwner() {
        return owner;
    }

    public void setOwner(Trainer owner) {
        this.owner = owner;
    }

    public void setswaps(Swap a){
        swaps.add(a);
    }
    public void setSwapAllowed(){
        isSwapAllowed = true;
    }
    public void setSwapNotAllowed(){
        isSwapAllowed = false;
    }


    public String toString(){
        return "This Pokemon is called " + getName() + " and is type " + getType() + ". It's ID is " + getNumber()+ ".";
    }

    public static void main(String[] args){
        // Deklaration
        Pokemon relaxo;
        // Initialisierung durch Aufurf des Konstruktors
        relaxo = new Pokemon("relaxo", Type.NORMAL);
        System.out.println(relaxo.toString());
    }
}