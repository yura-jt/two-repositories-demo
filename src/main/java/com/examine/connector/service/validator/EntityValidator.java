package com.examine.connector.service.validator;

import com.examine.connector.entity.World;
import com.examine.connector.exception.EntityValidationException;
import org.springframework.stereotype.Component;

@Component
public class EntityValidator {

    public  void validate(World world) {
        if (world == null) {
            throw new EntityValidationException("Entity is null!");
        } else if (world.getGreeting() == null) {
            throw new EntityValidationException("Entity's field 'Greeting' value is null!");
        }
    }
}
