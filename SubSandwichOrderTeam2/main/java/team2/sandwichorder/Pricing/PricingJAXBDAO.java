package team2.sandwichorder.Pricing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * PricingJAXBDAO
 * @author Nicki Hutchens
 * Data Access Object Class that uses JAXB classes to access the pricing data from the XML file passed in
 */
public class PricingJAXBDAO {
    static JAXBElement<PricingType> pricing;
    static PricingType pricingType;
    /**
     * processXMLFile
     * Uses the JAXB classes to unmarshall the XML data and extract the list of price item type groups
     * @param fileName
     * @return  list of ingredient groups (PriceItemType) objects for pricing of sandwich orders
     * @throws java.io.File Not Found Exception
     */
    public static List<PriceItemType> processXmlFile(String fileName) throws FileNotFoundException {
        File fXmlFile = new File(fileName);
        JAXBContext jaxbContext;
        Unmarshaller unMarshaller=null;
        try{
            jaxbContext = JAXBContext.newInstance("team2.sandwichorder.Pricing");
            unMarshaller = jaxbContext.createUnmarshaller();
        }catch (javax.xml.bind.JAXBException jaxbException){
            System.out.println(jaxbException.getStackTrace());
        }


        try{
            pricing = (JAXBElement<PricingType>) unMarshaller.unmarshal( new FileInputStream( fileName ) );
        } catch(JAXBException jaxbException){
            System.out.println(jaxbException.getStackTrace());
        }
        catch(java.io.FileNotFoundException e) {
            System.out.println(e.getStackTrace());
            throw new FileNotFoundException(fileName + "Data XML File Not Found in Expected Directory");
        }

        pricingType = pricing.getValue();
        List<PriceItemType> priceItemsGroups = pricingType.getPriceItem();
        return priceItemsGroups;
    }
}
