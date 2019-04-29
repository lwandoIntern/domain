package za.ac.cput.domain.services;

public interface Service<T,ID> {
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(T t);

}
