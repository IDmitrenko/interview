package ru.geekbrains.interview.homework1.homework11;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName,
                   lastName,
                   middleName,
                   country,
                   address,
                   phone,
                   gender;

    private int age;

}
