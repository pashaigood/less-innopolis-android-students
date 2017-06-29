package innopolis.less.registration.abstractions;

import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class RecycleHolder<T> {
    public abstract void bind(View view, T object);
    public List<T> filter(CharSequence charSequence, List<T> items) {
        if (charSequence.length() == 0) {
            return items;
        } else {
            List<T> result = new ArrayList<>();
            Iterator iterator = items.iterator();
            T object;
            while (iterator.hasNext()) {
                object = (T) iterator.next();
                if (object.toString().contains(charSequence)) {
                    result.add(object);
                }
            }

            return result;
        }
    }
}
