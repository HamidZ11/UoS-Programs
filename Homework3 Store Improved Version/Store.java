public class Store {
    private String storeName;
    private int total; // Total revenue

    // Constructor
    public Store(String storeNameInput) {
        this.storeName = storeNameInput;
        this.total = 0;
    }

    // Accessor for store name
    public String getStoreName() {
        return storeName;
    }

    // Accessor for total revenue
    public int getTotal() {
        return total;
    }

    // Register member (Method 1)
    public void memberRegister1(Member member) {
        member.setStore(this); // Step 3c: Pass reference to the current store
        System.out.println(storeName + " welcomes " + member.getName() + " (id:" + member.getId() + ")");
    }

    // Register member (Method 2)
    public void memberRegister2(String name, String id, String pinNumber) {
        Member member = new Member(name, id, pinNumber); // Create Member object
        member.setStore(this); // Step 3c: Pass reference to the current store
        System.out.println(storeName + " welcomes " + member.getName() + " (id:" + member.getId() + ")");
    }

    // Checkout method (Step 5b)
    public void checkout(int payment, Member member) {
        Item item = member.getSelectedItem();
        int price = item.getItemPrice();
        int change = payment - price;

        // Update store revenue
        total += price;

        // Deduct member's money
        member.deductMoney(payment);

        // Print transaction details
        System.out.println(storeName + ": Serving " + member.getName());
        System.out.println("Your basket contains:");
        System.out.println(item.getItemName() + " at " + item.getItemPriceString());
        System.out.println("You have tendered " + payment + "p");
        System.out.println("Your change is " + change + "p");
    }
}
