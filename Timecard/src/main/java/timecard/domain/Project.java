
package timecard.domain;
import java.util.*;

public class Project {
    public Date start;
    public Date end;
    public User manager;
    public List<User> users;
    public String name;
    public String id;

    
    public Project(Date start, Date end, User manager) {
        this.start = start;
        this.end = end;
        this.manager = manager;
        this.users = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
  
}
