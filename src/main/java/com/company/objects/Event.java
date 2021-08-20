package com.company.objects;

import java.util.Date;

public class Event {
    private Date eventDate;
    private String eventName;
    private String description;

    public Event() {
    }

    public Event(Date eventDate, String eventName, String description) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
