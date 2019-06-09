
import java.io.File;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class BatchProcess {

   public static void main(String[] args) {

      try {
         File file = new File("input.txt");
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbf.newDocumentBuilder();
         Document doc = dBuilder.parse(file);
         doc.getDocumentElement().normalize();
         
         NodeList nList = doc.getElementsByTagName("Bank Accounts");
         
         for (int temp = 0; temp < nList.getLength(); temp++) 
         {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) 
            {
               Element elem = (Element) nNode;
               System.out.println("Account Number : " 
                  + elem.getAttribute("AccNum"));
               System.out.println("Bank Name : " 
                  + elem
                  .getElementsByTagName("BankName")
                  .item(0)
                  .getTextContent());
               System.out.println("First Name : " 
                  + elem
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.println("Last Name : " 
                  + elem
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (Exception e) 
        {
            e.printStackTrace();
        }
   }
}
