import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class ReproduceXsltBug {

    public static void main(String[] args) throws TransformerException {
        File xmlSource = new File("emoji-on-the-chunk-edge.xml");
        StreamSource xslt = new StreamSource(new File("simple.xsl"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer(xslt);

        ByteArrayOutputStream copiedTranslation = new ByteArrayOutputStream();
        transformer.transform(new StreamSource(xmlSource), new StreamResult(copiedTranslation));

        System.out.println(copiedTranslation.toString());
    }
}
