package com.isco.aduana.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private Long id;
    private String firstName;
    private String lastName;
}
