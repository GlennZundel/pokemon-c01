package de.uni.hd.isw.pokemon;

import java.util.Date;

public class Competition extends Swap{

    @Override
    public void execute(Pokemon p01, Pokemon p02) {
        p1 = p01;
        p2 = p02;
        if((t1 = p01.getOwner()) == null || (t2 = p02.getOwner()) == null){
            System.out.println("Pokemon "+(((p1.getOwner()) == null) ? p1.getName() : p2.getName())+" hat keinen Trainer!");
        } else if (t1 == t2){
            System.out.println("Pokemon "+p1.getName()+" kann nicht mit "+p2.getName()+ " kämpfen, da beide den/die TrainerIn "+t1.toString()+ " haben.");
        } else if (!p01.getIsSwapAllowed()|| !p02.getIsSwapAllowed()) {
            System.out.println("Pokemon "+(!(p1.getIsSwapAllowed()) ? p1.getName() : p2.getName())+" ist nicht zum Tauschen freigegeben");
        }
        else{
            iD = "ID:"+getTradeID();
            dateOfTrade = new Date();
            double[] scores = calcCombatScore();
            if(scores[0]>scores[1]){
                t1.linkPokemonToTrainer(p2);
                t2.updateList();
            }else{
                t2.linkPokemonToTrainer(p1);
                t1.updateList();
            }
            p1.addCompetition(this);
            p2.addCompetition(this);
            System.out.println("Pokemon "+p1.getName()+ " got a Combat Score of "+scores[0]+ " and Pokemon "+p2.getName()+ " got a combat score of "+scores[1]+". Therefore Pokemon "+(scores[0]>scores[1] ? p1.getName() : p2.getName())+ " won.");
        }
    }

    private double[] calcCombatScore(){
        double m1 = java.lang.Math.random();
        double m2 = java.lang.Math.random();
        if(p1.getType() == p2.getType()){
            m1 *= 10;
            m2 *= 10;
        } else if(p1.getType() == Type.WATER){
            if(p2.getType() == Type.FIRE){
                m1 *= 10;
                m2 *= 5;
            } else{
                m2 *= 10;
                m1 *= 5;
            }
        } else if (p1.getType() == Type.FIRE) {
            if(p2.getType() == Type.WATER){
                m2 *= 10;
                m1 *= 5;
            } else{
                m1 *= 10;
                m2 *= 5;
            }
        } else{
            if(p2.getType() == Type.WATER){
                m1 *= 10;
                m2 *= 5;
            } else{
                m1 *= 5;
                m2 *= 10;
            }
        }
        double[] out = {m1, m2};
        return out;
    }

}


