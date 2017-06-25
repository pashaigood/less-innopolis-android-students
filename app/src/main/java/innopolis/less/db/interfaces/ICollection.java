package innopolis.less.db.interfaces;


import innopolis.less.db.Model;
import innopolis.less.db.SearchModel;

public interface ICollection<T extends Model> {
    void create(T object);
    T read(long id);
    T find(SearchModel searchModel);
    void update(T object);
    void delete(T object);
    int count();
    void clear();
}
