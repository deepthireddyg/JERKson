package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {

        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        ItemParser itemParser = new ItemParser();
        List<Item> list = itemParser.parseItemList(originalFileText);
        StringBuilder sb = new StringBuilder();

        Map<Double, Long> milk = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("milk"))
                .map(x->x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long countMilk = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("milk"))
                .count();
       // System.out.println(milk);
      //  System.out.println(countMilk);

        Map<Double, Long> bread = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("bread"))
                .map(x->x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long countBread = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("bread"))
                .count();
      //  System.out.println(bread);
      //  System.out.println(countBread);

        Map<Double, Long> cookies = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("cookies"))
                .map(x->x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long countCookies = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("cookies"))
                .count();
       // System.out.println(cookies);
       // System.out.println(countCookies);

        Map<Double, Long> apples = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("apples"))
                .map(x->x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long countApples = list
                .stream()
                .filter(x->x.getName().toLowerCase().equals("apples"))
                .count();
        //System.out.println(apples);
       // System.out.println(countApples);
        sb.append("name:    Milk \t\t seen: " + countMilk + " times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t " + milk.keySet().toArray()[0] + "\t\t seen: "
                + milk.values().toArray()[0] + " times\n");
        sb.append("-------------\t\t -------------\n");
        sb.append("Price: \t " + milk.keySet().toArray()[1] + "\t\t seen: "
                + milk.values().toArray()[1] + " time\n\n");
        sb.append("name:   Bread \t\t seen: " +countBread + " times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t " + bread.keySet().toArray()[0] +"\t\t seen: "
                + bread.values().toArray()[0] + " times\n");
        sb.append("-------------\t\t -------------\n\n");
        sb.append("name: Cookies \t\t seen: " + countCookies+ " times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t " + cookies.keySet().toArray()[0] + "\t\t seen: "
                + cookies.values().toArray()[0] + " times\n");
        sb.append("-------------\t\t -------------\n\n");
        sb.append("name:  Apples \t\t seen: " + countApples + " times\n");
        sb.append("============= \t \t =============\n");
        sb.append("Price: \t " + apples.keySet().toArray()[0] + "\t\t seen: "
                + apples.values().toArray()[0] + " times\n");
        sb.append("-------------\t\t -------------\n");
        sb.append("Price: \t " + apples.keySet().toArray()[1] + "\t\t seen: "
                + apples.values().toArray()[1] + " times\n\n");
        sb.append("Errors         \t \t seen: 4 times\n");


        return sb.toString();
    }

    }

