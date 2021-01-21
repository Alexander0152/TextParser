package packages.serviceLayer;

import packages.businessLayer.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordService implements IWordService{

    public List<Character> getListOfLetters(String word){
        List<Character> symbolList = new ArrayList<>();

        for(Character ch:word.toCharArray()){

            symbolList.add(ch);
        }
        return symbolList;
    }

    public double getProportionOfVowelsToLettersNumber(String word){ //гласн
        double count = 0;
        double amountOfLetters = word.length();
        double proportion = 0;
        for(Character ch:word.toCharArray()){
            if(checkLetterIsVowel(ch)){
                count++;
            }
        }

        return count/amountOfLetters;
    }

    public boolean checkLetterIsVowel(Character ch){
        switch (Character.toLowerCase(ch)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y': return true;
            default: return false;
        }
    }
}
