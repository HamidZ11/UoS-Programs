
public class App
{
    private String title;
    private String objective;
    private int costInPence; 
    private int numberOfDownloads = 0;
    private String highestStepCountName = "";
    private int highestStepCount = 0;
    private Controller appController;
    // Step 1 - Adding the fields 
    public App(String inputTitle, String inputObjective, int penceCost, Controller inputController){
        // Step 1 - Adding the constructor
        title = inputTitle;
        objective = inputObjective;
        costInPence = penceCost;
        appController = inputController;
    }
    
    // Step 2 - accessor and mutator methods for the title
    public String getTitle() {
        return title;
    }

    public void setTitle(String titleInput) {
        title = titleInput;
    }

    // Step 2 - accessor and mutator methods for the objective
    public String getObjective() {
        return objective;
    }

    public void setObjective(String objectiveInput) {
        objective = objectiveInput;
    }

    // Accessor and mutator for the costInPence
    public int getCostInPence() {
        return costInPence;
    }
    
    public void setCostInPence(int penceCost) {
        costInPence = penceCost;
    }
    
    public void download(){
        //step 2 - download method 
        System.out.println("Title: " + title);
        System.out.println("Objective: " + objective);
        System.out.println("Cost of Download: " + costInPence);
        numberOfDownloads++; // increase number of downloads by 1 
    }  
    
    private void checkStepCount(int stepCount, String name) { 
    if (stepCount > highestStepCount) {
        //step 2 to check who has the highest step count and if 
        //the step coun has been beaten
        highestStepCount = stepCount;
        highestStepCountName = name;
    }
    }
    public void printReport() {
        //step 2 printReport method 
        System.out.println("Title:" + title);
        System.out.println("Objective:" + objective);
        System.out.println("Cost in Pence:" + costInPence);
        System.out.println("Number of Downloads:" + numberOfDownloads);
        System.out.println("Highest step count:" + highestStepCount);
        System.out.println("User with the highest step count:" + highestStepCountName);
        System.out.println("Earnings:" + calculateEarnings());
        System.out.println("Controller’s name: " + appController.getSurname()); //final edit step 4
    }
    public int calculateEarnings() {
        //step 3 calculate Earnings method
        return numberOfDownloads * costInPence;
    }
}
