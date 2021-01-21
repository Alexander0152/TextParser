package packages.serviceLayer;

import packages.businessLayer.Sentence;
import packages.businessLayer.Text;
import packages.businessLayer.Word;

import java.io.IOException;
import java.util.List;

public interface ITextService {

     List<Word> getUniqueWords(Text text);

     int finedTheLargestNumberOfSentencesThatContainTheSameWords(Text text);

     List<Sentence> getSentenceListInAscendingOrderOfWords(Text text);

     Word getWordOfTheFirstSentenceThatIsNotInAnyOfTheOtherSentences(Text text);

     List<Word> finedWordsWithoutDuplicationOfEnteredLengthInAllIterrogativeSentences(Text text, int length);

     Text swapFirstAndLasrWordsInEverySentence(Text text);

     List<String> getWordsInAlphabeticalOrder(Text text);

     String getStringFromCharArray(List<Character> charList);

     void sortWordsByProportionOfVowels(Text text);
}
