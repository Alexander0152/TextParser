package packages.serviceLayer;

import packages.businessLayer.Sentence;
import packages.businessLayer.Text;
import packages.businessLayer.Word;

import java.util.*;
import java.util.logging.Logger;


public class TextService implements ITextService{

    private static final Logger log = Logger.getLogger(TextService.class.getName());

    public List<Word> getUniqueWords(Text text){
        List<Word> uniqueWords = new ArrayList<>();

        for(Sentence sentence:text.getSentenceList()){
            for(Word word: sentence.getWordList()){
                if(!uniqueWords.contains(word)){
                    uniqueWords.add(word);
                }
                else continue;
            }
        }
        return uniqueWords;
    }

    public int finedTheLargestNumberOfSentencesThatContainTheSameWords(Text text){
        int count = 0;
        int max = 0;
        List<Word> UniqueWords = getUniqueWords(text);

        for(Word word: UniqueWords) {
            for (Sentence sentence : text.getSentenceList()) {
                if (sentence.getWordList().contains(word)) {
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
            count = 0;
        }
        return max;
    }

    public List<Sentence> getSentenceListInAscendingOrderOfWords(Text text){

        SentenceService service = new SentenceService();

        Collections.sort(text.getSentenceList(), new Comparator<Sentence>(){
            @Override
            public int compare(Sentence o1, Sentence o2) {
                return Integer.compare(service.getAmountOfWords(o1), service.getAmountOfWords(o2));
            }
        });

        return text.getSentenceList();
    }

    public Word getWordOfTheFirstSentenceThatIsNotInAnyOfTheOtherSentences(Text text){

        boolean firstSentenceEnter = false;

        boolean flag = true;
        for(Sentence sentence:text.getSentenceList()) {
            for (Word word : sentence.getWordList()) {
                for(Sentence newsentence:text.getSentenceList()) {
                    if (newsentence.getWordList().contains(word) && firstSentenceEnter) {
                        flag = false;
                        break;
                    }
                    firstSentenceEnter = true;
                }
                if(flag){
                    return word;
                }
                flag = true;
                firstSentenceEnter = false;
            }
            break;
        }
        return null;
    }

    public List<Word> finedWordsWithoutDuplicationOfEnteredLengthInAllIterrogativeSentences(Text text, int length){
        List<Word> wordList = new ArrayList<>();
        for(Sentence sentence:text.getSentenceList()){
            if(sentence.getType() == Sentence.Type.INTERROGATIVE){
                for(Word word:sentence.getWordList()){
                    if(word.getLettersList().size() == length){
                        wordList.add(word);
                    }
                }
            }
        }
        return wordList;
    }

    public Text swapFirstAndLasrWordsInEverySentence(Text text){

        for(Sentence sentence:text.getSentenceList()) {
            Collections.swap(sentence.getWordList(), 0, sentence.getWordList().size()-1);
        }
        return text;
    }

    public List<String> getWordsInAlphabeticalOrder(Text text){
        List<String> wordList = new ArrayList<>();
        for(Sentence sentence:text.getSentenceList()){
            for (Word word : sentence.getWordList()) {
                wordList.add(getStringFromCharArray(word.getLettersList()).toLowerCase());
            }
        }
        Collections.sort(wordList);
        return wordList;
    }

    public String getStringFromCharArray(List<Character> charList){

        String str = "";

        for (Character ch : charList) {
           str+=ch;
        }
        return str;
    }

    public void sortWordsByProportionOfVowels(Text text){
        List<String> wordList = new ArrayList<>();
        for(Sentence sentence:text.getSentenceList()){
            for (Word word : sentence.getWordList()) {
                wordList.add(getStringFromCharArray(word.getLettersList()).toLowerCase());
            }
        }

    }
}
