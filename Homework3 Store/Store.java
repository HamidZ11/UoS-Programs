public class Store {
    // Declaring fields for store class (step 2a) 
    private String storeName;
    private int total;

    public Store(String storeNameInput) {
        // Initialise instance variables
        this.storeName = storeNameInput; // Corrected to use "this" 
        this.total = 0;
    }

    public void memberRegister1(Member member) {
        System.out.println(storeName + " welcomes " + member.getName() + " (id:" + member.getId() + ")");
        member.setStore(this); // step 3c
    }

    public void memberRegister2(String name, String id, String pinNumber) {
        // Method for registering a member by details
        Member member = new Member(name, id, pinNumber);
        System.out.println(storeName + " welcomes " + member.getName() + " (id:" + member.getId() + ")");
        member.setStore(this); // step 3c
    }

    public void checkout(int payment, Member member) { // Changed parameter to member
        // 5b: Checkout method
        int itemPrice = member.getItemPrice(); // Accessed through getter instead of directly
        int change = payment - itemPrice;

        // Print checkout details
        System.out.println(storeName + ": Serving " + member.getName());
        System.out.println("Your basket contains:");
        System.out.println(member.getItemName() + " at " + member.getItemPriceString());
        System.out.println("You have tendered " + payment + "p");
        System.out.println("Your change is " + change + "p");

        // Update store's total revenue with the price of the item purchased
        this.total += itemPrice; // Corrected to use "this" 
    }
}
