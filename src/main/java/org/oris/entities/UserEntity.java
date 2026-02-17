package org.oris.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
public class UserEntity {
    private int id;
    private String name;
}
