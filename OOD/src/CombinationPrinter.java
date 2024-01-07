
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class CombinationPrinter {
    private Map<String, Integer> itemCollection;
    private List<String> allItems;

    public CombinationPrinter(Map<String, Integer> itemCollection) {
        this.itemCollection = itemCollection;
        this.allItems = new ArrayList(itemCollection.keySet());
    }

    private void printItems(List<String> itemsInCart) {
        System.out.println(String.join("+", itemsInCart));
    }

    private boolean checkIsComplete(int money, int index, List<String> itemsInCart) {
        return index == this.allItems.size();
    }

    private void runGetCombRecursion(int money, List<String> itemsInCart, int index) {
        if (this.checkIsComplete(money, index, itemsInCart)) {
            this.printItems(itemsInCart);
        } else {
            if (money - (Integer)this.itemCollection.get(this.allItems.get(index)) >= 0) {
                itemsInCart.add((String)this.allItems.get(index));
                this.runGetCombRecursion(money - (Integer)this.itemCollection.get(this.allItems.get(index)), itemsInCart, index + 1);
                itemsInCart.remove(itemsInCart.size() - 1);
            }

            this.runGetCombRecursion(money, itemsInCart, index + 1);
        }
    }

    public void getAllCombinations(int money) {
        List<String> itemsInCart = new ArrayList();
        this.runGetCombRecursion(money, itemsInCart, 0);
    }

    public static void main(String[] args) {
        Map<String, Integer> combinations = new HashMap();
        combinations.put("candy_bar", 10);
        combinations.put("remote", 5);
        combinations.put("gum", 6);
        combinations.put("stick", 2);
        combinations.put("nori", 14);
        combinations.put("snack", 1);
        combinations.put("bob", 5);
        CombinationPrinter combinationPrinter = new CombinationPrinter(combinations);
        combinationPrinter.getAllCombinations(15);
    }
}
