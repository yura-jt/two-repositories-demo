package com.examine.connector.service;

import com.examine.connector.dao.WorldDao;
import com.examine.connector.entity.World;
import com.examine.connector.service.validator.EntityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class GreetingService {
    private final WorldDao worldDaoFirstImpl;
    private final WorldDao worldDaoSecondImpl;
    private final EntityValidator entityValidator;

    @Transactional("txManager1")
    public String getFromFirstDb() {
        World world = worldDaoFirstImpl.getLastWorld();

        entityValidator.validate(world);
        return world.getGreeting();
    }

    @Transactional("txManager2")
    public String getFromSecondDb() {
        World world = worldDaoSecondImpl.getLastWorld();

        entityValidator.validate(world);
        return world.getGreeting();
    }

}

