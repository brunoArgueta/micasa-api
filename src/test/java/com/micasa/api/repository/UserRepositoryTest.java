package com.micasa.api.repository;

import com.micasa.api.entity.Group;
import com.micasa.api.entity.GroupMember;
import com.micasa.api.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.TypedQuery;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest extends MiCasaRepositoryTest{

    protected PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void findUserByEmail() {
        Optional<User> accountByEmail = userRepository.findUserByUserName("bruno.argueta@gmail.com");
        assertTrue(accountByEmail.isPresent());
    }

    @Test
    void newUserWithGroup() {
        final TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.groupName = 'ADMINISTRACION'", Group.class);
        final Group group = query.getSingleResult();
        User user = new User();
        user.setUserName("javier_01@gmail.com");
        user.setLastName("Montoja Ramirez");
        user.setName("Javier");
        user.setPassword(passwordEncoder.encode("@OlasVan;"));
        userRepository.save(user);

        GroupMember groupMember = new GroupMember();
        groupMember.setGroup(group);
        groupMember.setUsername(user);
        entityManager.persist(groupMember);

        final TypedQuery<GroupMember> queryGroupMember = entityManager.createQuery("SELECT gm FROM GroupMember gm WHERE gm.username = ?1", GroupMember.class);
        queryGroupMember.setParameter(1, user);
        final GroupMember groupMemberExpected = queryGroupMember.getSingleResult();

        Assertions.assertEquals(user, userRepository.findUserByUserName(user.getUserName()).get());
        Assertions.assertEquals(user, groupMemberExpected.getUsername());
        Assertions.assertEquals(group, groupMemberExpected.getGroup());
    }
}