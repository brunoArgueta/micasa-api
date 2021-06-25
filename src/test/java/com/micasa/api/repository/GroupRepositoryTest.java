package com.micasa.api.repository;

import com.micasa.api.entity.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class GroupRepositoryTest extends MiCasaRepositoryTest{

    @Test
    void findGroupByGroupName(){
        Optional<Group> groupOptional = groupRepository.findGroupByGroupName("ADMINISTRACION");
        Assertions.assertTrue(groupOptional.isPresent());
    }

}