public class Item {
    private String itemName;
    private int itemPrice; // Price in pence

    // Constructor
    public Item(String itemNameInput, int itemPriceInput) {
        this.itemName = itemNameInput;
        this.itemPrice = itemPriceInput;
    }

    // Accessor for item name
    public String getItemName() {
        return itemName;
    }

    // Accessor for item price
    public int getItemPrice() {
        return itemPrice;
    }

    // Step 2: Convert pence to string
    public static String convertPenceToString(int pence) {
        return (pence < 100) ? pence + "p" : "£" + (pence / 100) + "." + (pence % 100) + "p";
    }

    // Step 2b: Add toString method
    @Override
    public String toString() {
        return itemName + " at " + convertPenceToString(itemPrice); // Format item details
    }
}
