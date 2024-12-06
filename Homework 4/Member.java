import java.util.ArrayList;

public class Member {
    private String name;
    private String id;
    private String pinNumber;
    private Store store; // Step 3a: Store the store the member enters
    private ArrayList<Item> basket; // Step 1a: Basket for items (Step 1 improvement)
    private int money = 500; // Step 5a: Initial wallet balance

    // Constructor
    public Member(String nameInput, String idInput, String pinNumberInput) {
        this.name = nameInput;
        this.id = idInput;
        this.pinNumber = pinNumberInput;
        this.basket = new ArrayList<>(); // Step 1b: Initialize the basket
    }

    // Accessor for name
    public String getName() {
        return name;
    }

    // Mutator for name
    public void setName(String inputName) {
        this.name = inputName;
    }

    // Accessor for ID
    public String getId() {
        return id;
    }

    // Mutator for ID
    public void setId(String inputId) {
        this.id = inputId;
    }

    // Accessor for PIN number
    public String getPinNumber() {
        return pinNumber;
    }

    // Mutator for PIN number
    public void setPinNumber(String inputPinNumber) {
        this.pinNumber = inputPinNumber;
    }

    // Mutator for store (Step 3b)
    public void setStore(Store storeInput) {
        this.store = storeInput;
    }

    // Step 1c: Modify selectItem to add items to basket
    public void selectItem(Item itemInput) {
        basket.add(itemInput); // Add the item to the basket
        System.out.println(name + " has selected " + itemInput);
    }

    // Step 3d: Show basket contents
    public void showBasket() {
        System.out.println("Your basket contains " + basket.size() + " items:");
        for (Item item : basket) {
            System.out.println(item); // Use Item's toString() method
        }
    }

    // Step 3e: Calculate total cost of basket
    public int calculateCostOfBasket() {
        int totalCost = 0;
        for (Item item : basket) {
            totalCost += item.getItemPrice(); // Sum up item prices
        }
        return totalCost;
    }

    // Step 2a: Return the basket
    public ArrayList<Item> getBasket() {
        return basket;
    }

    // Step 3a: Remove item by position
    public void putItemBack(int position) {
        if (position >= 0 && position < basket.size()) {
            basket.remove(position);
            System.out.println("Item at position " + position + " removed.");
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Step 3b: Remove item by name
    public void putItemBack(String itemName) {
        basket.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
        System.out.println("Item with name " + itemName + " removed.");
    }

    // Step 3c: Remove expensive items
    public void putExpensiveItemsBack(int priceThreshold) {
        basket.removeIf(item -> item.getItemPrice() >= priceThreshold);
        System.out.println("Items priced at or above " + priceThreshold + "p removed.");
    }

    // Deduct money after a purchase
    public void deductMoney(int amount) {
        this.money -= amount;
    }

    // Accessor for money (Step 5a)
    public int getMoney() {
        return money;
    }
}
