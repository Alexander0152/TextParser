package packages.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import packages.businessLayer.Sentence;
import packages.businessLayer.Text;
import packages.serviceLayer.TestParserService;
import packages.serviceLayer.TextService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestText  {

    Text text = new Text();
    TextService textService = new TextService();

    public TestText() throws IOException {
    }

    @Before
    public void setup() throws Exception {

        TestParserService textParserService = new TestParserService();
        text.setSentenceList(textParserService.getTextAsListOfSentences("D:\\LABS_5_SEM\\objectno-orientir_tech_progr\\LAB_2Parser\\resources\\text.txt"));

    }
    @Test
    public void TestFinedTheLargestNumberOfSentencesThatContainTheSameWords(){

        int result = textService.finedTheLargestNumberOfSentencesThatContainTheSameWords(text);

        Assert.assertEquals(5,result);
    }

    @Test
    public void TestgetSentenceListInAscendingOrderOfWords(){

        List<Sentence> sentenceList = textService.getSentenceListInAscendingOrderOfWords(text);

        int result = sentenceList.get(0).getWordList().size();
        Assert.assertEquals(13,result);
    }

    @Test
    public void TestgetWordsInAlphabeticalOrder(){

        List<String> wordList = textService.getWordsInAlphabeticalOrder(text);

        String result = wordList.get(0);
        Assert.assertEquals("about",result);
    }
}
