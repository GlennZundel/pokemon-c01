package de.uni.hd.isw.pokemon;
import java.util.ArrayList;

public class Trainer {
    //Attribute
    private String firstname;
    private String lastname;
    private ArrayList<Pokemon> PokemonList = new ArrayList<Pokemon>();

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
    public void LinkPokemonToTrainer(Pokemon p){
        p.setOwner(this);
        PokemonList.add(p);
    }

    // Erstelle String mit allen Pokemon, die zum Trainer gehören
    public String ListPokemonForTrainer(){
        String s = "";
        for (int i = 0; i < PokemonList.size(); i++){
            s += PokemonList.get(i).getName() + " ";
        }
        return s;
    }

    // Erstelle String mit Pokemon geordnet nach Typ
    public String ListPokemonByType(Type t){

        String s = "";
        for (int i = 0; i < PokemonList.size(); i++){
            if(PokemonList.get(i).getType()==t){
                s+= " "+PokemonList.get(i).getName();
            }
        }
        return s;
    }

    public void updateList(){
        for(int i = 0; i < PokemonList.size(); i++){
            if(PokemonList.get(i).getOwner() != this){
                PokemonList.remove(i);
            }
        }
    }

    // Gib das ite Pokemon aus der Liste aus
    public String showIthPokemon(int i){
        return PokemonList.get(i).getName();
    }

    // Hilfsfunktionen, gib die vorher erstellten Strings im Terminal aus
    public void ListPokemonForTrainerInTerminal(){
        System.out.println(this.toString() +"s Pokemon: \n" + ListPokemonForTrainer());
    }

    public void ListPokemonByTypeInTerminal(Type t){
        System.out.println(ListPokemonByType(t));
    }

    public void showIthPokemonInTerminal(int i){
        System.out.println(showIthPokemon(i));
    }
    //test
}
