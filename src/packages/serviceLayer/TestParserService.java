package packages.serviceLayer;

import packages.businessLayer.Sentence;
import packages.dataAccessLayer.TextDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestParserService {

    public List<Sentence> getTextAsListOfSentences(String filename) throws IOException {

        List<Sentence> sentenceList = new ArrayList<>();

        TextDao textdao = new TextDao();
        String wholeText = textdao.getAllText(filename);

        wholeText = wholeText.replaceAll("[\r\n]","");
        wholeText = wholeText.replaceAll("[!]","!~");
        wholeText = wholeText.replaceAll("[?]","?~");
        wholeText = wholeText.replaceAll("[.]",".~");

        String delims = "[~]+";
        String[] sentences = wholeText.split(delims);

        for(int i = 0; i < sentences.length; i++){
            if(sentences[i].charAt(0) == ' '){
                String newString = sentences[i].substring(1);
                sentences[i] = newString;

            }
        }

        ISentenceService sentenceService = new SentenceService();
        for(String sentence:sentences){

            Sentence newsentence = new Sentence();
            String newString = sentence.substring(0,sentence.length()-1);
            newsentence.setWordListList(sentenceService.getListOfWords(newString));

            if(sentence.charAt(sentence.length()-1) == '.'){

                newsentence.setType(Sentence.Type.NARRATIVE);
                sentenceList.add(newsentence);
            }
            else if(sentence.charAt(sentence.length()-1) == '!'){

                newsentence.setType(Sentence.Type.EXCLAMATION);
                sentenceList.add(newsentence);
            }
            else{
                newsentence.setType(Sentence.Type.INTERROGATIVE);
                sentenceList.add(newsentence);
            }
        }
        return sentenceList;
    }
}
