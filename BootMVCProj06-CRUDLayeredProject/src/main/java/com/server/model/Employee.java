package com.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer eid;
 private String ename="yogesh";
 private Integer age;
 private Integer salary;
 private String desiginaton;
}
