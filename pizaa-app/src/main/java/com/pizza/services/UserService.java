package com.pizza.services;

import com.pizza.model.User;

public interface UserService {

	User loadUser(String username, String password);

}
