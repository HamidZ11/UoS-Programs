public class Member {
    private String name;
    private String id;
    private String pinNumber;
    private Store store; // Step 3a: Store the store the member enters
    private Item item; // Step 4c: Store the selected item
    private int money = 500; // Step 5a: Initial wallet balance

    // Constructor
    public Member(String nameInput, String idInput, String pinNumberInput) {
        this.name = nameInput;
        this.id = idInput;
        this.pinNumber = pinNumberInput;
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

    // Method to select an item (Step 4c)
    public void selectItem(Item itemInput) {
        this.item = itemInput;
        System.out.println(name + " has selected " + item.getItemName() + " at " + item.getItemPriceString());
    }

    // Method to initiate checkout (Step 5c)
    public void goToCheckout(int payment) {
        if (item == null) {
            System.out.println("Error: No item selected.");
            return;
        }
        if (payment < item.getItemPrice()) {
            System.out.println("Error: Insufficient payment.");
            return;
        }
        if (payment > money) {
            System.out.println("Error: Not enough money.");
            return;
        }
        store.checkout(payment, this); // Calls Store's checkout method
        item = null; // Clear the basket
    }

    // Accessor for money (Step 5a)
    public int getMoney() {
        return money;
    }

    // Deduct money after a purchase
    public void deductMoney(int amount) {
        this.money -= amount;
    }

    // Accessor for selected item (used by Store)
    public Item getSelectedItem() {
        return item;
    }
}
