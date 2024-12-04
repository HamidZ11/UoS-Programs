
/**
 * Write a description of class car here.
 *
 * @author (Hamid Aziz)
 * @version (11.10.2024)
 */
public class Car
{

    // fields are declared here 
        private String make;
        private String model;
        private int milesPerGallon;
        private int initialPurchasePrice;
        private int purchasePrice;
        private String nameOfOwner;
        private int numberOfOwners;
        private boolean hasConverter;
    
    /**
     * This is where i made the constructor for the class
     */
    public Car(String makeInput, String modelInput, int milesPerGallonInput, int initialPurchasePriceInput, boolean hasConverterInput)

    {
        make = makeInput;
        model = modelInput;
        milesPerGallon = milesPerGallonInput;
        initialPurchasePrice = initialPurchasePriceInput;
        hasConverter = hasConverterInput;
        
        
        purchasePrice = initialPurchasePriceInput;
        nameOfOwner = "Not yet sold";
        numberOfOwners = 0;      
        
    }      
    public void setPurchasePrice(int newPrice) {
        purchasePrice = newPrice; 
        // This is a mutator method because data is being changed
    }
    public void setOwner(String newOwnerName) {
        nameOfOwner = newOwnerName;
        //Mutator method that changes the name of the owner 
    }
    public void goingCleaner() {
    hasConverter = true;
    }
    public String getMake() {
    return make;
    }
    public String getModel(){
    return model;
    }
    public int getPurchasePrice() {
    return purchasePrice;
    }
    public void printDetails() {
    System.out.println("This car is a " + make + " " + model + ".");
    System.out.println("It has had " + numberOfOwners + " owners and its current owner is " + nameOfOwner + ".");
    System.out.println("It does " + milesPerGallon + " miles per gallon and " +
        (hasConverter ? "has" : "does not have") + " a catalytic converter.");
    System.out.println("The original purchase price was £" + initialPurchasePrice +
        " and the price is now £" + purchasePrice + ".");
    }
    public void sell(String newOwner, int newPurchasePrice) {
    nameOfOwner = newOwner;
    purchasePrice = newPurchasePrice;
    numberOfOwners++;
    }
    public String checkCarConverter() {
        if (!hasConverter) {
            return "Car does not have a catalyctic converter";
        } else {
            return "Car does have a catalyctic converter";
        }
    }


}
