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
        return "Trainer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    // Füge Pokemon zur Liste des Trainers hinzu
    // TODO: füge Klasse Pokemon Attribut Trainer hinzu, trage Trainer für Pokemon ein (dazu Trainer ID erstellen (?)
    public void LinkPokemonToTrainer(Pokemon p){
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
    //TODO: Überarbeite so, dass type als Arg übergeben wird und nur von diesem Typ ausgegeben wird
    public String ListPokemonByType(){
        ArrayList<Pokemon> PokemonFire = new ArrayList<Pokemon>();
        ArrayList<Pokemon> PokemonWater = new ArrayList<Pokemon>();
        ArrayList<Pokemon> PokemonPoison = new ArrayList<Pokemon>();
        ArrayList<Pokemon> PokemonNormal = new ArrayList<Pokemon>();

        for (int i = 0; i < PokemonList.size(); i++){
            switch(PokemonList.get(i).getType()){
                case FIRE: PokemonFire.add(PokemonList.get(i));
                    break;
                case WATER: PokemonWater.add(PokemonList.get(i));
                    break;
                case NORMAL: PokemonNormal.add(PokemonList.get(i));
                    break;
                case POISON: PokemonPoison.add(PokemonList.get(i));
                    break;
            }
        }
        String s = "Fire: ";
        for (int i = 0; i < PokemonFire.size(); i++){
            s += PokemonFire.get(i).getName() + " ";
        }
        s += "\nWater: ";
        for (int i = 0; i < PokemonWater.size(); i++){
            s += PokemonWater.get(i).getName() + " ";
        }
        s += "\nNormal: ";
        for (int i = 0; i < PokemonNormal.size(); i++){
            s += PokemonNormal.get(i).getName() + " ";
        }
        s += "\nPoison: ";
        for (int i = 0; i < PokemonPoison.size(); i++){
            s += PokemonPoison.get(i).getName() + " ";
        }
        return s;
    }

    // Gib das ite Pokemon aus der Liste aus
    public String showIthPokemon(int i){
        return PokemonList.get(i).getName();
    }

    // Hilfsfunktionen, gib die vorher erstellten Strings im Terminal aus
    public void ListPokemonForTrainerInTerminal(){
        System.out.println(ListPokemonForTrainer());
    }

    public void ListPokemonByTypeInTerminal(){
        System.out.println(ListPokemonByType());
    }

    public void showIthPokemonInTerminal(int i){
        System.out.println(showIthPokemon(i));
    }
    //test
}
