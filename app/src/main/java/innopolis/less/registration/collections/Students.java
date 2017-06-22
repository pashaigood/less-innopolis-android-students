package innopolis.less.registration.collections;

import innopolis.less.registration.factories.ModelsCollection;

public class Students extends ModelsCollection {
    private static Students ourInstance = new Students();
    public static Students getInstance() {
        return ourInstance;
    }

    private Students() {
        FILE_NAME = "students";
    }
}
