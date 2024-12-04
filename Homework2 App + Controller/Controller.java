
public class Controller
{
    // Fields for the Controller
    private String surname;
    private String controllerID; 

    //Constructor for controller class
    public Controller(String SurnameNew, String ControllerIDNew)
    {
        surname = SurnameNew;
        controllerID = ControllerIDNew;
    }
    
    // Accessor for surname
    public String getSurname() {
        return surname;
    }

    // Accessor for controllerID
    public String getControllerID() {
        return controllerID;
    }
}
