
package team2.sandwichorder.Pricing;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Pricing_QNAME = new QName("", "pricing");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PricingType }
     * 
     */
    public PricingType createPricingType() {
        return new PricingType();
    }

    /**
     * Create an instance of {@link PriceItemType }
     * 
     */
    public PriceItemType createPriceItemType() {
        return new PriceItemType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PricingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pricing")
    public JAXBElement<PricingType> createPricing(PricingType value) {
        return new JAXBElement<PricingType>(_Pricing_QNAME, PricingType.class, null, value);
    }

}
