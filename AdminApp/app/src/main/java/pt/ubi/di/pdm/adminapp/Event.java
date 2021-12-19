package pt.ubi.di.pdm.adminapp;
//public String name;
//public String dataInicio;
//public String dataFim;
//public String numParticipantes;
public class Event {

    // string variable for
    // storing employee name.
    private String eventName;

    // string variable for storing
    // employee contact number
    private String eventContactNumber;

    // string variable for storing
    // employee address.
    private String eventAddress;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public Event() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventContactNumber() {
        return eventContactNumber;
    }

    public void setEventContactNumber(String eventContactNumber) {
        this.eventContactNumber = eventContactNumber;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }
}