package Utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;

public class DataExtracter {
    public static Element getXMldata(){
        try{
            File file=new File("C:\\Users\\azeem.hameed\\IdeaProjects\\PVH\\src\\main\\java\\dataSource\\validationfile.xml");
            DocumentBuilderFactory dbf
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodeList
                    = doc.getElementsByTagName("AssetDetails");
            Node node=nodeList.item(0);
            Element tElement = (Element)node;
            return  tElement;
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }
}
