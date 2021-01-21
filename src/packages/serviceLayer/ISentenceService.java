package packages.serviceLayer;

import packages.businessLayer.Word;

import java.util.List;

public interface ISentenceService {
    List<Word> getListOfWords(String sentence);
}
