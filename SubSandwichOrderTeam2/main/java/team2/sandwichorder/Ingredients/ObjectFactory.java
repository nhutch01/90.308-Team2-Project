
package team2.sandwichorder.Ingredients;

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

    private final static QName _Ingredients_QNAME = new QName("", "ingredients");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IngredientsType }
     * 
     */
    public IngredientsType createIngredientsType() {
        return new IngredientsType();
    }

    /**
     * Create an instance of {@link GroupType }
     * 
     */
    public GroupType createGroupType() {
        return new GroupType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngredientsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ingredients")
    public JAXBElement<IngredientsType> createIngredients(IngredientsType value) {
        return new JAXBElement<IngredientsType>(_Ingredients_QNAME, IngredientsType.class, null, value);
    }

}
