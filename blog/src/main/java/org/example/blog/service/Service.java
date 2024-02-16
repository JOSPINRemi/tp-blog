package org.example.blog.service;

import java.util.List;
import java.util.UUID;

public interface Service<T> {
    T create(T element);
    List<T> getAll();
    T getById(UUID id);
    T update(UUID id, T element);
    void delete(UUID id);
}
