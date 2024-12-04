public class Member
{
    // Here I am declaring the fields (step 1)
    private String name;
    private String id;
    private String pinNumber;
    private Store store; // step 3a add store field to member class
    private Item item;
    private int money = 500; // Initialize with 500 pence (step 5a)

    public Member(String nameInput, String idInput, String pinNumberInput)
    {
        // Here I am adding the constructor for member (step 1)
        this.name = nameInput; // Corrected to use "this" 
        this.id = idInput; // Corrected to use "this"
        this.pinNumber = pinNumberInput; // Corrected to use "this" 
    }

    // Accessor and mutator methods for the name
    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        this.name = inputName;
    }

    // Accessor and mutator methods for the member ID
    public String getId() {
        return id;
    }

    public void setId(String inputid) {
        this.id = inputid;
    }

    // Accessor and mutator methods for pin number 
    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String inputPinNumber) {
        this.pinNumber = inputPinNumber;
    }

    public void setStore(Store storeInput) {
        this.store = storeInput; // step 3b
    }

    public void selectItem(Item itemInput) {
        this.item = itemInput;
        
        System.out.println(name + " has selected " + item.getItemName() + " at " + item.getItemPriceString());
    }

    
    public int getItemPrice() {
        if (item != null) { 
            return item.getItemPrice();
        } else {
            System.out.println("Error: No item selected for this member.");
            return 0; 
        }
    }

    public String getItemName() {
        if (item != null) { // Added null check to avoid errors
            return item.getItemName();
        } else {
            return "No item selected."; // Error handling for a null 
        }
    }

    
    public String getItemPriceString() {
        if (item != null) { // Added null check to avoid errors
            return item.getItemPriceString();
        } else {
            return "No price available."; // Error handling for a null
        }
    }

    // Step 5c: Method to initiate checkout
    public void goToCheckout(int payment) {
        if (store != null && item != null) { 
            store.checkout(payment, this); // External call to the Store's checkout method
        } else {
            System.out.println("Error: Member is not in a store or has not selected an item."); // Added error message
        }
    }
}
