package team2.sandwichorder.Ingredients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * IngredientGroupJAXBDAO
 * @author Nicki Hutchens
 * Data Access Object Class that uses JAXB classes to access the ingredients data from the XML file passed in
 */
public class IngredientGroupJAXBDAO {
    static JAXBElement<IngredientsType> ingredients;
    static IngredientsType ingredientsType;

    /**
     * processXMLFile
     * Uses the JAXB classes to unmarshall the XML data and extract the list of ingredient groups
     * @param fileName
     * @return  list of ingredient groups (GroupType) objects for display on the GUI
     * @throws File Not Found Exception
     */
    public static List<GroupType>processXmlFile(String fileName) throws FileNotFoundException {
        File fXmlFile = new File(fileName);
        JAXBContext jaxbContext;
        Unmarshaller unMarshaller=null;
        try{
            jaxbContext = JAXBContext.newInstance("team2.sandwichorder.Ingredients");
            unMarshaller = jaxbContext.createUnmarshaller();
        }catch (javax.xml.bind.JAXBException jaxbException){
            System.out.println(jaxbException.getStackTrace());
        }


        try{
            ingredients = (JAXBElement<IngredientsType>) unMarshaller.unmarshal( new FileInputStream( fileName ) );
        } catch(JAXBException jaxbException){
            System.out.println(jaxbException.getStackTrace());
        }
        catch(java.io.FileNotFoundException e) {
            System.out.println(e.getStackTrace());
            throw new FileNotFoundException(fileName + "Data XML File Not Found in Expected Directory");
        }

        ingredientsType = ingredients.getValue();
        List<GroupType> ingredientGroups = ingredientsType.getGroup();
        return ingredientGroups;
    }
}
