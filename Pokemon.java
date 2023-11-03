package de.uni.hd.isw.pokemon;
import java.util.ArrayList;
import java.util.List;
public class Pokemon {
    // Attributes
    private String name;
    private Type type;
    private int number;
    private static int nextNumber = 1;
    private boolean isSwapAllowed;
    private List<Swap> swaps;
    private List<Competition> competitions;
    private Trainer owner;

    //Konstruktor
    public Pokemon(String s, Type t, boolean a){
        name = s;
        type = t;
        number = nextNumber;
        nextNumber++;
        owner = null;
        isSwapAllowed = a;
        swaps = new ArrayList<>();
        competitions = new ArrayList<>();
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

    public Trainer getOwner() {
        return owner;
    }

    public boolean getIsSwapAllowed(){
        return isSwapAllowed;
    }

    public List<Swap> getSwaps(){
        return swaps;
    }

    public List<Competition> getCompetitions(){return competitions;}

    //Setters

    public void setName(String name) {
        // "this" ist eine Referenz auf die Instanz, auf der die Methode
        // aufgerufen wurde, zb wenn ich den Namen von der Instanz Relaxo
        // ändern möchte und die setName Methode aufrufe ist sichergestellt,
        // das ich den Namen genau dieser Instanz ändere
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setOwner(Trainer owner) {
        this.owner = owner;
    }

    public void setIsSwapAllowed(boolean a){
        this.isSwapAllowed = a;
    }

    public void addSwap(Swap s){
        swaps.add(s);
    }

    public void addCompetition(Competition s){
        competitions.add(s);
    }

    //methods

    public String toString(){
        return "This Pokemon is called " + getName() + " and is type " + getType() + ". It's ID is " + getNumber()+ " and its trainer is "+ getOwner()+".";
    }

    public static void main(String[] args){
        // Deklaration
        Pokemon relaxo;
        // Initialisierung durch Aufurf des Konstruktors
        relaxo = new Pokemon("Relaxo", Type.WATER, true);
        System.out.println(relaxo.toString());
    }
}