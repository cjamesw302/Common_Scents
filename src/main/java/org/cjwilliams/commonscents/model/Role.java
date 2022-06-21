package org.cjwilliams.commonscents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

//Entity class for Role

@Entity
@Table(name="role")
@ToString
public class Role {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable=false)
   private Long id;
   @Column(nullable=false)
   private String name;

   //No args constructor for payment
   
   public Role() {
   }

   //All args constructor for payment
   
   public Role(String name) {
       this.name = name;
   }
   
   //Getters and setters for corresponding variables
   
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
}