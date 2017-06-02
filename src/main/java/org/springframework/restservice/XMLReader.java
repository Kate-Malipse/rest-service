package org.springframework.restservice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Kate on 02.06.2017.
 */
public class XMLReader {
    private final String NOTFOUND = "Тэг не найден.";
    private final String EXCEPTION = "Exception: ";

    public XMLReader() { }

    //чтение XML
    public String getContent(String content) {
        try {
            File fxml = new File("List.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fxml);
            doc.getDocumentElement().normalize();
            Element element = doc.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName(content);
            if (nodeList.getLength() == 0)
                return NOTFOUND;
            //перебор элементов соответствующих content
            String out = new String();
            for (int s = 0; s < nodeList.getLength(); s++) {
                Element el = (Element) nodeList.item(s);
                out += "id[" + (s + 1) + "] " + el.getTagName() +  ": " + el.getTextContent() + "\n" + "<br/>";
            }
            return out;
        } catch (Exception e) {
            return EXCEPTION + e.getMessage();
        }
    }
}
