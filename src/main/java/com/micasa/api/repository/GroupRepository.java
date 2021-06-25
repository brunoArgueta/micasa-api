package com.micasa.api.repository;

import com.micasa.api.entity.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Query("SELECT g FROM Group g WHERE g.groupName = ?1")
    Optional<Group> findGroupByGroupName(String groupName);

}
