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
    Trainer t1;
    Trainer t2;
    Pokemon p1;
    Pokemon p2;
    java.util.Date Date;
    String ID;
    private static String nextNumber = "1";

    //Konstruktor
    public Swap(Pokemon p_1, Trainer t_1, Pokemon p_2, Trainer t_2){

        t1 = t_1;
        p1 = p_1;
        t2 = t_2;
        p2 = p_2;
        Date = new java.util.Date();
        ID = nextNumber;
        nextNumber = String.valueOf(Integer.valueOf(nextNumber) + 1);
    }

    @Override
    public String toString() {
        return "Swap{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", Date=" + Date +
                ", ID='" + ID + '\'' +
                '}';
    }

    public void Execute() {
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
            if (p1.IsSwapAllowed == false) {
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
            if (p2.IsSwapAllowed == false) {
                throw new SwapException("Error: Second Pokemon is not allowed to be swapped");
            }
        } catch (SwapException ex) {
            System.out.println(ex);
            return;
        }
        //execute Swap
        p1.setOwner(t2);
        p2.setOwner(t1);
        t1.PokemonList.remove(p1);
        t2.PokemonList.remove(p2);
        t1.PokemonList.add(p2);
        t2.PokemonList.add(p1);
        p1.Swaps.add(this);
        p2.Swaps.add(this);
    }
}
