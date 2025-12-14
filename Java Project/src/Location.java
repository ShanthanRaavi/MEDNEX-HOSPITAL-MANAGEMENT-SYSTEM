package src;

import java.io.Serializable;

public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;

    public Location(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
