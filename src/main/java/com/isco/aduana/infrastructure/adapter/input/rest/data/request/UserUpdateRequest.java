package com.isco.aduana.infrastructure.adapter.input.rest.data.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest
{
    private Long id;
    private String firstName;
    private String lastName;
}
