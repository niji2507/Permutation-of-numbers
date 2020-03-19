package com.permutation.question.permutation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.permutation.question.permutation.exception.InvalidPermutationInputException;
import com.permutation.question.permutation.nodes.PermutationListNode;
import com.permutation.question.permutation.nodes.PermutationNode;
import com.permutation.question.permutation.nodes.ResponseNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * @author NSoundararajan
 * Service to handle permutation request
 */
@RestController @RequestMapping("/permutation") @Api(value="Permutation", description="Operations to find permutation for a given number or list of numbers")
public class PermutationService {
	
	
	private static final char NEGATIVE_SIGN = '-';
	 
	/**
	 * 
	 * Instantiating the class Process
	 */
	@Autowired
	Process process;
	

	/**This method will take List of integers as input 
	 * and returns list of permutation nodes as response
	 * @param inputList
	 * @return PermutationListNode
	 */
	@ApiOperation(value = "Get Permutation result for list of Integers", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Successfully retrieved list of permutations"),
			@ApiResponse(code = 412, message = "Input is not valid"),
			@ApiResponse(code = 500, message = "Internal server error!!"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/permutations/list")
	
	public ResponseEntity<ResponseNode> getPermutationForAllInputs(@RequestBody PermutationListNode inputList) {
		
		ResponseEntity<ResponseNode> responseEntity = null;
		ResponseNode response = null;
		try {
			if(inputList.getInput() == null) {
				throw new InvalidPermutationInputException("Payload is empty !!");
			}
			if(inputList.getInput().isEmpty()) {
				throw new InvalidPermutationInputException("Input is Empty or null. Provide a Valid input!");
			}
			final List<Integer> inputs = inputList.getInput();
			final List<PermutationNode> resultList = new ArrayList<>();
			for(final Integer input :  inputs) {				
				List<Integer> result = process.findPermutaionOfGivenInteger(input);
				final PermutationNode permNode = new PermutationNode(input,result);
				resultList.add(permNode);
			}
			final PermutationListNode permListNode = new PermutationListNode(resultList.size(),inputs,resultList);
			
			response = new ResponseNode(true,permListNode);
		}catch (InvalidPermutationInputException ex) {
			response = new ResponseNode(false,ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
		}
		responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	/**This method will take input as 
	 * number and returns permutation list for that number
	 * @param inputstr
	 * @return PermutationListNode
	 */
	@ApiOperation(value = "Get Permutation result for a given Number", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 202, message = "Successfully retrieved permutaions for a given number"),
			@ApiResponse(code = 412, message = "Input is not valid"),
			@ApiResponse(code = 500, message = "Internal server error!!"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/permutations/{inputstr}")
	public ResponseEntity<ResponseNode> getPermutationForInput(@DefaultValue("") @PathVariable String inputstr) {
		
		ResponseEntity<ResponseNode> responseEntity= null;
		ResponseNode response = null;
		try {
			if(inputstr.equals(" ")) {
				throw new InvalidPermutationInputException("Input is empty !!");
			}
			if(!checkIsInteger(inputstr)) {
				throw new InvalidPermutationInputException("Input is not an Integer!!");
			}
			final Integer input = Integer.parseInt(inputstr);
			final List<PermutationNode> resultList = new ArrayList<>();
			final List<Integer> inputs = new ArrayList<>();
			inputs.add(input);
			final List<Integer> result = process.findPermutaionOfGivenInteger(input);
			final PermutationNode permNode = new PermutationNode(input,result);
			resultList.add(permNode);			
			final PermutationListNode permListNode = new PermutationListNode(resultList.size(),inputs,resultList);			
			response = new ResponseNode(true,permListNode);
		}catch (InvalidPermutationInputException ex) {
			response = new ResponseNode(false,ex.getMessage());
			return  new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
		}catch(NumberFormatException ex) {
			response = new ResponseNode(false,"Input integer is not with In  range or not a valid Integer " + ex.toString());
			return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
		}
		responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		return responseEntity;
	}

	/*
	 * Method to check whether given input is a valid Integer or not
	 */
	private boolean checkIsInteger(final String input) {		
		int positiveInt = 0;
		boolean result = true;
		if (input.charAt(0) == NEGATIVE_SIGN) {
			positiveInt = 1;
		}
		for (int j = positiveInt; j < input.length(); j++) {
			if (!Character.isDigit(input.charAt(j))) {
				result = false;
			}				
		}

		return result;
	}
	
	
	
	
}
