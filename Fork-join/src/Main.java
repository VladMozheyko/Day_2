
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Path f = Paths.get("/work/king_corp.xml");
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f.toFile());
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            forkJoinPool.invoke(new MySumSallary(doc.getFirstChild()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
