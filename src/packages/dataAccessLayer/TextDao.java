package packages.dataAccessLayer;

import packages.businessLayer.Sentence;
import packages.businessLayer.Word;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TextDao implements ITextDao{

    public String getAllText(String filename) throws IOException {
        List<Sentence> sentenceList = new ArrayList<>();
        List<Word> wordList = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        String wholeText =  String.join(System.lineSeparator(), lines);

        return wholeText;
    }
}
