package innopolis.less.db;


import android.util.Log;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import innopolis.less.db.serializers.ByteSerializer;
import innopolis.less.db.interfaces.ICollection;

// TODO: Make tests.
public class ModelsCollection<T extends Model> extends ByteSerializer<T> implements ICollection {
    private Class modelClass;

    private void setClass(Model model) {
        if (modelClass == null) {
            modelClass = model.getClass();
        }
    }

    @Override
    public void create(Model object) {
        setClass(object);
        if (! contains(object)) {
            add((T) object);
        }
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
    public List<T> find(SearchModel searchModel) {
        ArrayList<T> result = new ArrayList<>();
        Field[] searchFields = searchModel.getClass().getDeclaredFields();
        Iterator<T> iterator = this.iterator();
        T model;

        search: while (iterator.hasNext()) {
            model = iterator.next();
            for (Field searchField: searchFields) {
                if (searchField.isSynthetic()) continue ;
                switch (searchField.getName()) {
                    case "serialVersionUID":
                        continue;
                }

                searchField.setAccessible(true);
                Field modelField;
                try {
                    modelField = modelClass.getDeclaredField(searchField.getName());
                    if (! isFieldsEquals(modelField, model, searchField, searchModel)) {
                        continue search;
                    }
                } catch (NoSuchFieldException e) {
                    // e.printStackTrace();
                    // If don't has a field, go to next model.
                    continue search;
                }
            }

            result.add(model);
        }

        return result;
    }

    private boolean isFieldsEquals(Field modelField, Object model, Field searchField, Object searchModel) {
        boolean result = false;
        try {
            if (! modelField.isAccessible()) {
                modelField.setAccessible(true);
                result = searchField.get(searchModel).equals(modelField.get(model));
                modelField.setAccessible(false);
            }
            else  {
                return modelField.get(model).equals(searchField.get(searchModel));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
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
