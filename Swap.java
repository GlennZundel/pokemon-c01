/*
 * Swap
 * Copyright Glenn Zundel & Anna Schwegmann
 */

package de.uni.hd.isw.pokemon;

class SwapException extends Exception{
    public SwapException(){}
    public SwapException(String message){
        super(message);
    }
    public SwapException (Throwable cause){
        super(cause);
    }
    public SwapException (String message, Throwable cause){
        super(message, cause);
    }
}
public class Swap {
    //Attribute
    protected Trainer t1;
    protected Trainer t2;
    protected Pokemon p1;
    protected Pokemon p2;
    protected java.util.Date date;
    protected int id;
    protected static int nextNumber = 1;

    //Konstruktoren
    public Swap(Pokemon p01, Pokemon p02){

        t1 = p01.getOwner();
        p1 = p01;
        t2 = p02.getOwner();
        p2 = p02;
        date = new java.util.Date();
        id = nextNumber;
        nextNumber++;
    }
    public Swap(){}

    @Override
    public String toString() {
        return "Swap{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", Date=" + date +
                ", id='" + id + '\'' +
                '}';
    }

    public void execute() {
        try {
            if (t1 == null || t2 == null) {
                throw new SwapException("Error: Trainer does not exist");
            }
        } catch(SwapException ex) {
            System.out.println(ex);
            return;
        }
        // check if t1 uneq t2
        try {
            if (t1 == t2) {
                throw new SwapException("Error: Pokemon belong to same Trainer");
            }
        } catch(SwapException ex) {
            System.out.println(ex);
            return;
        }
        //check if p1 belongs to t1
        try {
            if(p1.getOwner() != t1){
                throw new SwapException("Error: p1 does not belong to t1");
            }
        }
        catch(SwapException ex){
            System.out.println(ex);
            return;
        }
        // check if p1 is swappable
        try {
            if (!p1.getSwapAllowed()) {
                throw new SwapException("Error: First Pokemon is not allowed to be swapped");
            }
        } catch (SwapException ex) {
            System.out.println(ex);
            return;
        }
        // check if p2 belongs to t2
        try {
            if(p2.getOwner() != t2){
                throw new SwapException("Error: p2 does not belong to t2");
            }
        }
        catch(SwapException ex){
            System.out.println(ex);
            return;
        }
        // check if p2 is swappable
        try {
            if (!p2.getSwapAllowed()) {
                throw new SwapException("Error: Second Pokemon is not allowed to be swapped");
            }
        } catch (SwapException ex) {
            System.out.println(ex);
            return;
        }
        //execute Swap
        p1.setOwner(t2);
        p2.setOwner(t1);
        t1.removePokemonList(p1);
        t2.removePokemonList(p2);
        t1.addPokemonList(p2);
        t2.addPokemonList(p1);
        p1.setswaps(this);
        p2.setswaps(this);
    }
}
