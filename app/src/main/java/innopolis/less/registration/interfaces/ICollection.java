package innopolis.less.registration.interfaces;


import innopolis.less.registration.factories.Model;

public interface ICollection<T extends Model> {
    void create(T object);
    Model read(long id);
    void update(T object);
    void delete(T object);
    int count();
    void clear();
}
