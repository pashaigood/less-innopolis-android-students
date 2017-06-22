package innopolis.less.registration.factories;


import java.util.Iterator;

import innopolis.less.registration.interfaces.ICollection;

// TODO: Make tests.
public class ModelsCollection extends ByteSerializer implements ICollection {
    @Override
    public void create(Model object) {
        add(object);
    }

    @Override
    public Model read(long id) {
        Iterator<Model> iterator = this.iterator();
        Model model;
        while (iterator.hasNext()) {
            model = iterator.next();
            if (model.getId() == id) {
                return model;
            }
        }

        return null;
    }

    @Override
    public void update(Model object) {
        int index  = indexOf(object);
        remove(index);
        add(index, object);
    }

    @Override
    public void delete(Model object) {
        remove(object);
    }

    @Override
    public long count() {
        return super.size();
    }


}
