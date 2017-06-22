package innopolis.less.registration.collections;

import innopolis.less.registration.factories.ModelsCollection;
import innopolis.less.registration.models.Group;

public class Groups extends ModelsCollection<Group> {
    private static final Groups ourInstance = new Groups();

    public static Groups getInstance() {
        return ourInstance;
    }

    private Groups() {
        FILE_NAME = "Groups";
    }
}
