package com.isco.aduana.infrastructure.adapter.input;

import com.isco.aduana.application.ports.input.CreateUserUserCase;
import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.input.rest.data.request.UserRequest;
import com.isco.aduana.infrastructure.adapter.input.rest.data.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final CreateUserUserCase createUserUserCase;
    private final ModelMapper mapper;

    public UserController(CreateUserUserCase createUserUserCase,
            ModelMapper mapper)
    {
        this.createUserUserCase = createUserUserCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest userRequest)
    {
        System.out.println(
                "userRequest.getFirstName() = " + userRequest.getFirstName());
        User userSave = mapper.map(userRequest, User.class);
        userSave = createUserUserCase.createUser(userSave);

        return new ResponseEntity<>(mapper.map(userSave, UserResponse.class),
                HttpStatus.CREATED);
    }

}
