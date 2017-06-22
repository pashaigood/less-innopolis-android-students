package innopolis.less.registration.interfaces;


import innopolis.less.registration.factories.Model;

public interface ICollection {
    void create(Model object);
    Model read(long id);
    void update(Model object);
    void delete(Model object);
    long count();
    void clear();
}
