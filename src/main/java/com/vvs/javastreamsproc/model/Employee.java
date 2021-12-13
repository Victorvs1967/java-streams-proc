package com.vvs.javastreamsproc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
  
  private String empId;
  private String firstName;
  private String lastName;
  private String email;
  private String gender;
  private String newJoiner;
  private int salary;
  private int rating;
}
