package com.isco.aduana.infrastructure.adapter.input;

import com.isco.aduana.application.ports.input.CreateUserUseCase;
import com.isco.aduana.application.ports.input.GetUserUseCase;
import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.input.rest.data.request.UserRequest;
import com.isco.aduana.infrastructure.adapter.input.rest.data.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final ModelMapper mapper;

    public UserController(CreateUserUseCase createUserUseCase,
            GetUserUseCase getUserUseCase, ModelMapper mapper)
    {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest userRequest)
    {
        System.out.println(
                "userRequest.getFirstName() = " + userRequest.getFirstName());
        User userSave = mapper.map(userRequest, User.class);
        userSave = createUserUseCase.createUser(userSave);

        return new ResponseEntity<>(mapper.map(userSave, UserResponse.class),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id)
    {
        User userFind = getUserUseCase.getUserById(id);
        return new ResponseEntity<>(mapper.map(userFind, UserResponse.class),
                HttpStatus.ACCEPTED);
    }

}
