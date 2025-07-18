package com.isco.aduana.infrastructure.adapter.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse
{
    private Long id;
    private String firstName;
    private String lastName;
}
