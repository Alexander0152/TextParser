package packages.businessLayer;

import packages.serviceLayer.TextService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentenceList = new ArrayList<>();

//    public Text(String filename) throws IOException {
//        TextService textService = new TextService();
//        this.sentenceList = textService.getText(filename);
//    }

    public void addSentence(Sentence sentence){
        this.sentenceList.add(sentence);
    }

    public void removeSentence(Sentence sentence){
        this.sentenceList.remove(sentence);
    }

    public List<Sentence> getSentenceList(){
        return this.sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList){
         this.sentenceList = sentenceList;
    }

//    public void setSentenceList(List<Sentence> sentenceList){
//        this.sentenceList = sentenceList;
//    }
}
