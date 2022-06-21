package org.cjwilliams.commonscents.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Entity class for Products

@Entity
@Table(name="products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String description;
	
	@OneToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Orders> orders;
}