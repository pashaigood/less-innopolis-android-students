package innopolis.less.db;


import java.util.Iterator;

import innopolis.less.db.serializers.ByteSerializer;
import innopolis.less.db.interfaces.ICollection;

// TODO: Make tests.
public class ModelsCollection<T extends Model> extends ByteSerializer<T> implements ICollection {
    @Override
    public void create(Model object) {
        add((T) object);
    }

    @Override
    public T read(long id) {
        Iterator<T> iterator = this.iterator();
        T model;
        while (iterator.hasNext()) {
            model = iterator.next();
            if (model.getId() == id) {
                return model;
            }
        }

        return null;
    }

    @Override
    public T find(SearchModel searchModel) {
        return null;
    }

    @Override
    public void update(Model object) {
        int index  = indexOf(object);
        remove(index);
        add(index, (T) object);
    }

    @Override
    public void delete(Model object) {
        remove(object);
    }

    @Override
    public int count() {
        return super.size();
    }


}
