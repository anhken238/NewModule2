package gym.model;

import javax.persistence.*;

@Entity
@Table(name = "eventgym")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, eventName, category, dateStart;

    public Event() {
    }

    public Event(String title, String eventName, String category, String dateStart) {
        this.title = title;
        this.eventName = eventName;
        this.category = category;
        this.dateStart = dateStart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public String toString() {
        return String.format("Event[id=%d, title='%s', eventName='%s', category='%s', dateStart='%s' ]", id, title, eventName, category, dateStart);
    }
}
