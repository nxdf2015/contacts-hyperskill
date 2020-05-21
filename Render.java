package contacts;

import java.time.LocalDate;
import java.util.Optional;

public class Render {
    public static String ifPresent(Optional object) {
        if (object.isEmpty()){
            return "[no data]";
        }
        else {
            return object.get().toString();
        }
    }
}
