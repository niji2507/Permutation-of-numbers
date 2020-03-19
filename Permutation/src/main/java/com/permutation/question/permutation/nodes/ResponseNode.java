package com.permutation.question.permutation.nodes;

public class ResponseNode {
	private boolean success;
	private PermutationListNode permutation;
	private String reason;
	
	public ResponseNode() {
		
	}
	
	public ResponseNode(boolean success,PermutationListNode permList) {
		this.permutation = permList;
		this.success = success;
	}
	
	public ResponseNode(boolean failure,String reason) {
		this.reason = reason;
		this.success = failure;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the permutation
	 */
	public PermutationListNode getPermutation() {
		return permutation;
	}
	/**
	 * @param permutation the permutation to set
	 */
	public void setPermutation(PermutationListNode permutation) {
		this.permutation = permutation;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
