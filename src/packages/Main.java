package packages;

import packages.businessLayer.Sentence;
import packages.businessLayer.Text;
import packages.businessLayer.Word;
import packages.serviceLayer.TestParserService;
import packages.serviceLayer.TextService;
import packages.serviceLayer.WordService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {

//        Text text = new Text();
//        TestParserService textParserService = new TestParserService();
//        text.setSentenceList(textParserService.getTextAsListOfSentences("src/text.txt"));
//
//        TextService textService = new TextService();
//
//        int max = textService.finedTheLargestNumberOfSentencesThatContainTheSameWords(text);


        List<String> levelList = new ArrayList<>();
        String level = "wfef";
        String level1 = "sdssd";
        String level2 = "wffrgtgef";

        levelList.add(level);
        levelList.add(level1);
        levelList.add(level2);

        try {
            FileOutputStream fileOut = new FileOutputStream("src/test.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(levelList);
            out.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

         //Let's deserialize an Object
        try {
            FileInputStream fileIn = new FileInputStream("src/test.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        List<Sentence> sentenceList = textService.getSentenceListInAscendingOrderOfWords(text);
//        Word word = textService.getWordOfTheFirstSentenceThatIsNotInAnyOfTheOtherSentences(text);
//        List<Word> wordlist = textService.finedWordsWithoutDuplicationOfEnteredLengthInAllIterrogativeSentences(text,4);
//        Text newText = textService.swapFirstAndLasrWordsInEverySentence(text);
//        List<String> words = textService.getWordsInAlphabeticalOrder(text);
//        Word word = new Word("Abceu");
//        WordService service = new WordService();
//        service.getProportionOfVowelsToLettersNumber();
    }
}

//вынести сервисы из конструкторов/разбить тест сервис на (парсер и второй)/объявлять классы через интерфейсы