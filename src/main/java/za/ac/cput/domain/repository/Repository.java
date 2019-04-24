package za.ac.cput.domain.repository;

public interface Repository<T,ID> {
    T create(T t);
    T read(T t);
    T update(T t);
    void delete(ID id);
}
