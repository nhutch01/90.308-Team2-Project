package team2.sandwichorder.BusinessLogic;

import team2.sandwichorder.Pricing.PriceItemType;

import java.math.BigDecimal;
import java.util.*;

/**
 * ItemPriceMap
 * @author Nicki Hutchens
 * Creates a Hashmap of items and prices from PriceItems objects
 * the key is the name of the item and the value is the price
 */
public class ItemPriceMap {
    private HashMap itemPrices = new HashMap();

    /**
     * Create Price Map constructor
     * creates empty Hash map of items and prices
     */
    public ItemPriceMap()   {
        itemPrices = new HashMap();
    }

    /**
     * ItemPriceMap
     * @param priceItems
     * creates a hash map of items and their related prices from a price item list
     * a price item object contains a menu item choice with its associated price
     */
    public ItemPriceMap(List<PriceItemType> priceItems){
        PriceItemType priceItem = new PriceItemType();
        for (int i = 0; i<priceItems.size(); i++){
            priceItem = priceItems.get(i);
            itemPrices.put(priceItem.getChoice(), priceItem.getPrice())  ;
        }
    }

    /**
     * addItemPrice
     * @param item
     * @param price
     * add an item and price to the hashmap
     */
    public void addItemPrice(String item, BigDecimal price) {
        itemPrices.put(item, price);
    }

    /**
     * getAllKeyValues
     * @return list of strings of item names
     * get all item names from the list
     */
    public List<String> getAllKeyValues(){
       List<String> keys = new ArrayList<String>();
       Set keySet = itemPrices.keySet();
       Iterator keyIterator = keySet.iterator();
       while (keyIterator.hasNext()){
           keys.add((String)keyIterator.next());
       }

        return keys;
    }

    /**
     * getPrice
     * @param item
     * @return  Big Decimal value of the price of an item
     * returns the price for the given item
     */
    public BigDecimal getPrice(String item)   {
        return (BigDecimal)itemPrices.get(item);
    }
}
