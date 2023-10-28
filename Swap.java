package de.uni.hd.isw.pokemon;

import java.util.Date;
public class Swap {

    private Trainer t1;
    private Trainer t2;
    private Pokemon p1;
    private Pokemon p2;
    private String iD;
    private Date dateOfTrade;
    private static int tradeID = 1;

    public Swap(){
        t1 = t2 = null;
        p1 = p2 = null;
        iD = null;
        dateOfTrade = null;
    }

    @Override public String toString(){
        return "Trade-ID: "+iD+" Time of Trade: "+dateOfTrade;
    }
    public static int getTradeID(){
        tradeID++;
        return tradeID-1;
    }
    public void execute(Pokemon p01, Pokemon p02){
        iD = "ID:"+getTradeID();
        p1 = p01;
        p2 = p02;
        if((t1 = p01.getOwner()) == null || (t2 = p02.getOwner()) == null){
            System.out.println("Some pokemon dont have a trainer!");
        } else if (t1 == t2){
            System.out.println("Pokemon "+p1.getName()+" kann nicht mit "+p2.getName()+ " getauscht werden, da beide den/die TrainerIn "+t1.toString()+ " haben.");
        } else if (!p01.getIsSwapAllowed()|| !p02.getIsSwapAllowed()) {
            System.out.println("Pokemon "+(!(p1.getIsSwapAllowed()) ? p1.getName() : p2.getName())+" ist nicht zum Tauschen freigegeben");
        }
        else{
            dateOfTrade = new Date();
            t1.linkPokemonToTrainer(p2);
            t2.linkPokemonToTrainer(p1);
            //removing swapped pokemon from their pokemonLists
            t1.updateList();
            t2.updateList();
            p1.addSwap(this);
            p2.addSwap(this);
        }
    }


}
