package packages.dataAccessLayer;

import packages.businessLayer.Sentence;

import java.io.IOException;
import java.util.List;

public interface ITextDao {
    String getAllText(String filename) throws IOException;
}
