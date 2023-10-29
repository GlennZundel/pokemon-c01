package de.uni.hd.isw.pokemon;
import java.util.*;

public class Trainer {
    //Attribute
    private String firstname;
    private String lastname;
    private List<Pokemon> pokemonList = new ArrayList<>();

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

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void addPokemonList(Pokemon p){
        pokemonList.add(p);
    }
    public void removePokemonList(Pokemon p){
        pokemonList.remove(p);
    }

    //toString Operation
    @Override
    public String toString() {
        return "Trainer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    // Füge Pokemon zur Liste des Trainers hinzu
    public void linkPokemonToTrainer(Pokemon p){
        p.setOwner(this);
        pokemonList.add(p);
    }

    // Erstelle String mit allen Pokemon, die zum Trainer gehören
    public String listPokemonForTrainer(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < pokemonList.size(); i++){
            s.append(pokemonList.get(i).getName());
            s.append(" ");
        }
        return s.toString();
    }

    // Erstelle String mit Pokemon geordnet nach Typ
    public String listPokemonByType(Type t){

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < pokemonList.size(); i++){
            if(pokemonList.get(i).getType()==t){
                s.append(pokemonList.get(i).getName());
                s.append(" ");
            }
        }
        return s.toString();
    }

    // Gib das ite Pokemon aus der Liste aus
    public String showIthPokemon(int i){
        return pokemonList.get(i).getName();
    }

    // Hilfsfunktionen, gib die vorher erstellten Strings im Terminal aus
    public void listPokemonForTrainerInTerminal(){
        System.out.println(listPokemonForTrainer());
    }

    public void listPokemonByTypeInTerminal(Type t){
        System.out.println(listPokemonByType(t));
    }

    public void showIthPokemonInTerminal(int i){
        System.out.println(showIthPokemon(i));
    }

}
