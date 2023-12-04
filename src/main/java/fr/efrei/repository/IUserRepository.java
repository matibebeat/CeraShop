package fr.efrei.repository;

import fr.efrei.domain.User;

import java.util.List;

public interface IUserRepository extends IRepository<User, Integer> {
    public List<User> getAll();
}