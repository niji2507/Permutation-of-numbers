package com.permutation.question.permutation.nodes;

import java.util.List;

public class PermutationNode {
	private Integer input;
	private List<Integer> permutations;
	
	public PermutationNode() {
		
	}
	
	public PermutationNode(Integer input, List<Integer> permutations) {
		super();
		this.input = input;
		this.permutations = permutations;
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
	 * @return the permutations
	 */
	public List<Integer> getPermutations() {
		return permutations;
	}
	/**
	 * @param permutations the permutations to set
	 */
	public void setPermutations(List<Integer> permutations) {
		this.permutations = permutations;
	}
}
