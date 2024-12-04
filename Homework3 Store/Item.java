public class Item
{
    // instance variables - replace the example below with your own
    private String itemName;
    private int itemPrice;

    public Item(String itemNameInput, int itemPriceInput)
    {
        // initialise instance variables
        this.itemName = itemNameInput; // Corrected to use "this" 
        this.itemPrice = itemPriceInput; // Corrected to use "this" 
    }

    // Accessor for name
    public String getItemName() {
        return itemName;
    }

    // Accessor for price
    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemPriceString() {
        // Corrections After Early Feedback
        if (itemPrice < 100) {
            return itemPrice + "p";
        } else {
            return (itemPrice / 100) + " pounds " + (itemPrice % 100) + "p"; // Added logic for better display
        }
    }
}
