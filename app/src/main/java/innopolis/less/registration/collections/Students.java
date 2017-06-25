package innopolis.less.registration.collections;

import innopolis.less.db.ModelsCollection;
import innopolis.less.registration.models.Student;

public class Students extends ModelsCollection<Student> {
    private static Students ourInstance = new Students();
    public static Students getInstance() {
        return ourInstance;
    }

    private Students() {
        FILE_NAME = "students";
    }
}
