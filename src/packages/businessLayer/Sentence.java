package packages.businessLayer;

import packages.serviceLayer.SentenceService;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

//    public Sentence(String sentence){
//        SentenceService service = new SentenceService();
//        this.wordList = service.getListOfWords(sentence);
//    }
    public enum Type {
        INTERROGATIVE,
        EXCLAMATION,
        NARRATIVE
    }
    private List<Word> wordList = new ArrayList<>();

    private  Type type;

    public Type getType(){
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }
    
    public void addWord(Word word){
        this.wordList.add(word);
    }

    public void removeWord(Word word){
        this.wordList.remove(word);
    }

    public List<Word> getWordList(){
        return this.wordList;
    }

    public void setWordListList(List<Word> wordList){
        this.wordList = wordList;
    }
}
