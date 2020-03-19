package com.permutation.question.permutation.nodes;

import java.util.List;

public class PermutationListNode {
	
	private int size;
	private List<Integer> input;
	private List<PermutationNode> permutationList;
	
	public PermutationListNode() {
		
	}
	public PermutationListNode(int size, List<Integer> input, List<PermutationNode> permutationList) {
		super();
		this.size = size;
		this.input = input;
		this.permutationList = permutationList;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the input
	 */
	public List<Integer> getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(List<Integer> input) {
		this.input = input;
	}
	/**
	 * @return the permutationList
	 */
	public List<PermutationNode> getPermutationList() {
		return permutationList;
	}
	/**
	 * @param permutationList the permutationList to set
	 */
	public void setPermutationList(List<PermutationNode> permutationList) {
		this.permutationList = permutationList;
	}
	
	
	

}
