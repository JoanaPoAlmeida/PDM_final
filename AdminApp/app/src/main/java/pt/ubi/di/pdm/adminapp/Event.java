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
    private String eventStartDate;

    // string variable for storing
    // employee address.
    private String eventEndDate;

    private String eventPartic;
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

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventPartic() {
        return eventPartic;
    }

    public void setEventPartic(String eventPartic) {
        this.eventPartic = eventPartic;
    }
}