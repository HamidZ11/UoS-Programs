import java.util.ArrayList;

public class Store {
    private String storeName;
    private int total; // Total revenue
    private int maxNumberOfItems = 10; // Step 4d: Maximum allowed items in basket
    private ArrayList<Member> members; // Step 4a: Registered members

    // Constructor
    public Store(String storeNameInput) {
        this.storeName = storeNameInput;
        this.total = 0;
        this.members = new ArrayList<>(); // Step 4a: Initialize members list
    }

    // Accessor for store name
    public String getStoreName() {
        return storeName;
    }

    // Accessor for total revenue
    public int getTotal() {
        return total;
    }

    // Register member
    public void registerMember(Member member) {
        member.setStore(this); // Step 3c: Pass reference to the current store
        members.add(member); // Step 4a: Add member to the list
        System.out.println(storeName + " welcomes " + member.getName() + " (id: " + member.getId() + ")");
    }

    // Step 4a: Show all members
    public void showMembers() {
        System.out.println("The members of this store are:");
        for (Member member : members) {
            System.out.println(member.getName() + " with id " + member.getId());
        }
    }

    // Step 4d: Check if basket is overfull
    public boolean basketOverFull(ArrayList<Item> basket) {
        return basket.size() > maxNumberOfItems;
    }

    // Checkout method
    public void checkout(int payment, Member member) {
        ArrayList<Item> basket = member.getBasket(); // Step 2b: Get basket

        if (basket.isEmpty()) {
            System.out.println("Error: No items in the basket.");
            return;
        }

        if (basketOverFull(basket)) { // Step 4d: Check basket size
            System.out.println("Error: Basket exceeds the maximum number of items allowed.");
            return;
        }

        int totalCost = member.calculateCostOfBasket(); // Step 3e: Calculate total cost

        if (payment < totalCost) {
            System.out.println("Error: Insufficient payment.");
            return;
        }

        if (payment > member.getMoney()) {
            System.out.println("Error: Not enough money.");
            return;
        }

        // Update store revenue
        total += totalCost;

        // Deduct money and clear basket
        member.deductMoney(payment);
        basket.clear(); // Step 2d: Clear the basket after purchase

        // Print receipt
        System.out.println(storeName + ": Serving " + member.getName());
        System.out.println("Your basket contains:");
        for (Item item : basket) {
            System.out.println(item);
        }
        System.out.println("The total cost is " + Item.convertPenceToString(totalCost));
        System.out.println("You have tendered " + Item.convertPenceToString(payment));
        System.out.println("Your change is " + Item.convertPenceToString(payment - totalCost));
    }
}
