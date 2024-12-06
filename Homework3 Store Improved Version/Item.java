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

    // Method to get price as a formatted string
    public String getItemPriceString() {
        return (itemPrice < 100) ? itemPrice + "p" : (itemPrice / 100) + " pounds " + (itemPrice % 100) + "p";
    }
}
