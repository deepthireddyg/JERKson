package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.*;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {


            List<Item> newList = new ArrayList<>();
            String[] str = valueToParse.split("##");

            for (int i = 0; i < str.length; i++) {
                try {
                    newList.add(parseSingleItem(str[i]));
                } catch (ItemParseException e) {
                    e.printStackTrace();
                }
            }
            return newList ;



    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
//        try {
//            singleItem = singleItem.replaceAll("#", "");
//            StringTokenizer tokenizer = new StringTokenizer(singleItem, ";");
//            String[][] container = new String[4][2];
//            int count = 0;
//            while (tokenizer.hasMoreTokens()) {
//                container[count] = splitter(tokenizer.nextToken());
//                count++;
//            }
//
//            Item item = new Item(container[0][1].toLowerCase(), Double.parseDouble(container[1][1]),
//                    container[2][1].toLowerCase(), container[3][1].toLowerCase());
//
//            return item;
//        } catch (Exception e) {
//            throw new ItemParseException();
//        }

//        try {
//            singleItem.replaceAll("#","");
//            String[] myGrocery = singleItem.split(";");
//            Item item = new Item(myGrocery[0].split(":")[1].toLowerCase(),Double.parseDouble(myGrocery[1].split(":")[1]),myGrocery[2].split(":")[1].toLowerCase(),myGrocery[3].split(":")[1].toLowerCase());
//            String output=singleItem.replaceAll("##","");
//            System.out.println(item.toString());
//            System.out.println(item.getName());
//
//            return item;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;

        try {
            singleItem.replaceAll("#","");
            singleItem.toLowerCase();
            String[] myGrocery = singleItem.split(";");
            Item item = new Item(myGrocery[0].split("[:@^%]")[1].toLowerCase(),Double.parseDouble(myGrocery[1].split("[:@^%]")[1]),myGrocery[2].split("[:@^%]")[1].toLowerCase(),myGrocery[3].split("[:@^%]")[1].replaceAll("##"," ").trim());
            System.out.println(item.toString());
            // System.out.println(item.getName());
            return item;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ItemParseException();
        }

    }




//        try {
//            singleItem = singleItem.replaceAll("#", "");
//            StringTokenizer tokenizer = new StringTokenizer(singleItem, ";");
//            Map<String, String> resultMap = new LinkedHashMap<String, String>();
//            for (int i = 0; i < valueToParse.getLength(); i++) {
//                String name = valueToParse.item(i).getFirstChild().getNodeValue();
//                String value = valueToParse.item(i).getAttributes().getNamedItem("name").toString();
//                resultMap.put(name, value);
//            }

//ok, lets print out what's in the Map
//            Iterator<String> iterator = resultMap.keySet().iterator();
//            while(iterator.hasNext()){
//                String deviceID = iterator.next();
//                String descripcion = resultMap.get(key);
//                System.out.println(name  + ", " + value);
//            }
//            return item;
//        }
//        catch (Exception e){
//            throw new ItemParseException();
//        }




    private String[] splitter(String nextToken) {
        return null;
    }
}
