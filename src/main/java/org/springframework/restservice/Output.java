package org.springframework.restservice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Kate on 02.06.2017.
 */
public class Output {

    private final String content;

    public Output( String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    //чтение XML
    public String getContent(String content) {
        String out = "";
        try {
            File fxml = new File("List.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fxml);
            doc.getDocumentElement().normalize();
            Element element = doc.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName(content);
            //перебор элементов соответствующих content
            for (int s = 0; s < nodeList.getLength(); s++) {
                Element el = (Element) nodeList.item(s);
                out += "id[" + (s + 1) + "] " + el.getTagName() +  ": " + el.getTextContent() + "\n" + "<br/>";
            }
            //System.out.print(out);
        } catch (Exception e) {
            System.out.println("Exeption");
        }
        return out;
    }

}
