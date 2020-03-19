package com.permutation.question.permutation.permutationjpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Permutation {
	
	@Id
	private Integer input;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "permutation")
    private Set<Outputval> permval = new HashSet<>();

	public Permutation() {
		
	}
	public Permutation(Integer input, Set<Outputval> permval) {
		super();
		this.input = input;
		this.permval = permval;
	}

	/**
	 * @return the input
	 */
	public Integer getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(Integer input) {
		this.input = input;
	}

	/**
	 * @return the permval
	 */
	public Set<Outputval> getPermval() {
		return permval;
	}

	/**
	 * @param permval the permval to set
	 */
	public void setPermval(Set<Outputval> permval) {
		this.permval = permval;
	}
	
	
	
	


	
	
	
	
	

}
