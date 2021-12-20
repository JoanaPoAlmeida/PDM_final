package pt.ubi.di.pmd.agrupame;

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

    public Event(String eventName, String eventStartDate, String eventEndDate, String eventPartic) {
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventPartic = eventPartic;
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

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventStartDate='" + eventStartDate + '\'' +
                ", eventEndDate='" + eventEndDate + '\'' +
                ", eventPartic='" + eventPartic + '\'' +
                '}';
    }
}
