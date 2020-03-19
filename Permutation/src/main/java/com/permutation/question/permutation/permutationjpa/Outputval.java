package com.permutation.question.permutation.permutationjpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="outputval")
public class Outputval {
	
	@Id
	@GeneratedValue
	private Long eventId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input", nullable = false)
    private Permutation permutation;
	
	private Integer combination;
	
	public Outputval() {
		
	}
	
	public Outputval(Permutation permutation,Integer output) {
		super();
		this.permutation = permutation;
		this.combination = output;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the permutation
	 */
	public Permutation getPermutation() {
		return permutation;
	}

	/**
	 * @param permutation the permutation to set
	 */
	public void setPermutation(Permutation permutation) {
		this.permutation = permutation;
	}

	/**
	 * @return the combination
	 */
	public Integer getCombination() {
		return combination;
	}

	/**
	 * @param combination the combination to set
	 */
	public void setCombination(Integer combination) {
		this.combination = combination;
	}
	
	
	

}
