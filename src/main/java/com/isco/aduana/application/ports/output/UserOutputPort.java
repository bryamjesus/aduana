package com.isco.aduana.application.ports.output;

import com.isco.aduana.domain.model.User;

public interface UserOutputPort
{
    User saveUser(User user);
}
