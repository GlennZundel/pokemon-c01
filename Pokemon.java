package de.uni.hd.isw.pokemon;

public class Pokemon {
    // Attributes
    private String name;
    private Type type;
    private int number;
    private static int nextNumber = 1;


    private Trainer owner;

    //Konstruktor
    public Pokemon(String s, Type t){
        name = s;
        type = t;
        number = nextNumber;
        nextNumber++;
        owner = null;
    }

    // Getters bla bla
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

    public Trainer getOwner() {
        return owner;
    }

    public void setOwner(Trainer owner) {
        this.owner = owner;
    }
    public String toString(){
        String s = "This Pokemon is called " + getName() + " and is type " + getType() + ". It's ID is " + getNumber()+ ".";
        return s;
    }

    public static void main(String[] args){
        // Deklaration
        Pokemon Relaxo;
        // Initialisierung durch Aufurf des Konstruktors
        Relaxo = new Pokemon("Relaxo", Type.NORMAL);
        System.out.println(Relaxo.toString());
    }
}