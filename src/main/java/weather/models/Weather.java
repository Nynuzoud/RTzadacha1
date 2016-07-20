package weather.models;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public class Weather {
    private long id;
    private String time;
    private String city;
    private String wheather;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWheather() {
        return wheather;
    }

    public void setWheather(String wheather) {
        this.wheather = wheather;
    }
}
