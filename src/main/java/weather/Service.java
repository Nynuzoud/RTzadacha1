package weather;

import java.text.SimpleDateFormat;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public class Service {
    public String timestampToDateString(long timestamp) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp * 1000);
    }
}
