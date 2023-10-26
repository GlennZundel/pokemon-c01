package de.uni.hd.isw.pokemon;
import java.util.ArrayList;

public class Trainer {

    private String firstname;
    private String lastname;

    private ArrayList<Pokemon> PokemonList = new ArrayList<Pokemon>();


    public Trainer(String fname, String lname){
        firstname = fname;
        lastname = lname;
    }

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

    @Override
    public String toString() {
        return "Trainer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public void LinkPokemonToTrainer(Pokemon p){
        PokemonList.add(p);
    }

    public String ListPokemonForTrainer(){
        String s = "";
        for (int i = 0; i < PokemonList.size(); i++){
            s += PokemonList.get(i).getName() + " ";
        }
        return s;
    }

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

    public String showIthPokemon(int i){
        return PokemonList.get(i).getName();
    }

    public void ListPokemonForTrainerInTerminal(){
        System.out.println(ListPokemonForTrainer());
    }

    public void ListPokemonByTypeInTerminal(){
        System.out.println(ListPokemonByType());
    }

    public void showIthPokemonInTerminal(int i){
        System.out.println(showIthPokemon(i));
    }
}
