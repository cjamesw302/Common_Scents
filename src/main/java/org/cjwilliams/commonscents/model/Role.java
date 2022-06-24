package org.cjwilliams.commonscents.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity class for Role

@Entity
@Table(name="role")
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
}