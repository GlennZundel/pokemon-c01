package com.main.pokemonmanager;

import java.util.ArrayList;
public class Trainer {
    //Attribute
    private String firstname;
    private String lastname;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    //Konstruktor
    public Trainer(String fname, String lname){
        firstname = fname;
        lastname = lname;
    }

    //Getter & Setter
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //toString Operation
    @Override
    public String toString() {
        return firstname+ " "+lastname;
    }

    // Füge Pokemon zur Liste des Trainers hinzu
    public void linkPokemonToTrainer(Pokemon p){
        p.setOwner(this);
        pokemonList.add(p);
    }

    // Erstelle String mit allen Pokemon, die zum Trainer gehören
    public String listPokemonForTrainer(){
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < pokemonList.size(); i++){
            bld.append(pokemonList.get(i).getName() + " ");
        }
        return bld.toString();
    }

    // Erstelle String mit Pokemon geordnet nach Typ
    public String listPokemonByType(Type t){

        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < pokemonList.size(); i++){
            if(pokemonList.get(i).getType()==t){
                bld.append(" "+pokemonList.get(i).getName());
            }
        }
        return bld.toString();
    }

    public void updateList(){
        for(int i = 0; i < pokemonList.size(); i++){
            if(pokemonList.get(i).getOwner() != this){
                pokemonList.remove(i);
            }
        }
    }

    // Gib das ite Pokemon aus der Liste aus
    public String showIthPokemon(int i){
        return pokemonList.get(i).getName();
    }

    // Hilfsfunktionen, gib die vorher erstellten Strings im Terminal aus
    public void listPokemonForTrainerInTerminal(){
        System.out.println(this.toString() +"s Pokemon: \n" + listPokemonForTrainer());
    }

    public void listPokemonByTypeInTerminal(Type t){
        System.out.println(listPokemonByType(t));
    }

    public void showIthPokemonInTerminal(int i){
        System.out.println(showIthPokemon(i));
    }
}
