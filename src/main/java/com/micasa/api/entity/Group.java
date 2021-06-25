package com.micasa.api.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    @Column(name = "group_name", nullable = false)
    String groupName;

}
