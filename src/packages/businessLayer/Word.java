package packages.businessLayer;

import packages.serviceLayer.WordService;

import java.util.ArrayList;
import java.util.List;

public class Word {

//    public Word(String word){
//        WordService service = new WordService();
//        this.letersList = service.getListOfLetters(word);
//        this.proportionOfVowels = service.getProportionOfVowelsToLettersNumber(word);
//    }

    private List<Character> letersList = new ArrayList<>();

    public List<Character> getLettersList(){
        return this.letersList;
    }

    public void setLettersList(List<Character> letersList){
        this.letersList = letersList;
    }

    private double proportionOfVowels;//доля гласных

    public double getProportionOfVowels(){

        return this.proportionOfVowels;
    }

    public void setProportionOfVowels(double proportionOfVowels){

        this.proportionOfVowels =proportionOfVowels;
    }

    public void addLetter(Character letter){
        this.letersList.add(letter);
    }

    public void removeLetter(Character letter){
        this.letersList.remove(letter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Word)) {
            return false;
        }

        Word word = (Word) obj;
        return letersList.equals(((Word) obj).getLettersList());
    }
    @Override
    public int hashCode() {
        return letersList.hashCode ();
    }
}
