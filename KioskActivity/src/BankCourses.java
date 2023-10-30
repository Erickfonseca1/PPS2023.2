import java.util.HashMap;
import java.util.Map;

public class BankCourses {
    private Map<String, Courses> coursesMap;


    BankCourses () {
        if (coursesMap == null) {
            coursesMap = new HashMap<String, Courses>();
            coursesMap.put("GPT", new Courses("GPT", 100.00));
            coursesMap.put("Blockchain", new Courses("Blockchain", 90.00));
            coursesMap.put("IoT", new Courses("IoT", 80.00));
            coursesMap.put("VR", new Courses("Java", 70.00));
        }
    }

    public Courses getCourse(String name) {
        return coursesMap.get(name);
    }

    public Map<String, Courses> getCoursesMap() {
        return coursesMap;
    }


}
