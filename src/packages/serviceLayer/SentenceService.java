package packages.serviceLayer;

import packages.businessLayer.Sentence;
import packages.businessLayer.Word;

import java.util.ArrayList;
import java.util.List;

public class SentenceService implements ISentenceService {

    public List<Word> getListOfWords(String sentence){
        List<Word> wordList = new ArrayList<>();

        String delims = "[,:; \r\n]+";
        String[] words = sentence.split(delims);

        WordService wordService = new WordService();

        for(String word:words){
            Word nextWord = new Word();
            nextWord.setLettersList(wordService.getListOfLetters(word));
            wordList.add(nextWord);
        }
        return wordList;
    }
    public int getAmountOfWords(Sentence sentence){

        return  sentence.getWordList().size();
    }
}
