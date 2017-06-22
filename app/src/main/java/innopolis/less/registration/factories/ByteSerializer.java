package innopolis.less.registration.factories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import innopolis.less.registration.interfaces.ISerializer;

public class ByteSerializer extends ArrayList implements ISerializer {
    static private String PATH_TO_COLLECTION = "./resources/collections/byte/";
    protected String FILE_NAME;

    private static final short serialVersionUID = 4;

    public void list() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_TO_COLLECTION + FILE_NAME));
                ) {
            this.addAll((ArrayList) ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try (
                ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(PATH_TO_COLLECTION + FILE_NAME));
                ) {
            oout.writeObject(this);
            oout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
