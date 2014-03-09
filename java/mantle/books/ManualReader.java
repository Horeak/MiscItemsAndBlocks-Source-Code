package mantle.books;

import mantle.CoreRepo;
import mantle.Mantle;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class ManualReader
{
    public static Document readManual (String location)
    {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try
        {
        	CoreRepo.logger.info("Loading Manual XML from: " + location);
            InputStream stream = Mantle.class.getResourceAsStream(location);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
