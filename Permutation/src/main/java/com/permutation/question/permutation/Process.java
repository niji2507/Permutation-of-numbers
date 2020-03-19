package com.permutation.question.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.permutation.question.permutation.permutationjpa.Outputval;
import com.permutation.question.permutation.permutationjpa.Permutation;
import com.permutation.question.permutation.permutationjpa.PermutationJpaRepo;

/*
 * Process class to implement permutation method
 */
@Component
public class Process {
	
	Process() {
		
	}
	
	//Permutation repository instance
	@Autowired
	PermutationJpaRepo permJpaRepo;
	/*
	 * Calculate permutation for given
	 */
	List<Integer> findPermutaionOfGivenInteger(Integer input) {		
		boolean negativeNumber = false;
		List<Integer> result = new ArrayList<>();
		if (permJpaRepo.existsById(input)) {
			Permutation perm = permJpaRepo.findById(input).get();
			Set<Outputval> resultVal = perm.getPermval();
			for (Outputval val : resultVal) {
				result.add(val.getCombination());
			}
		} else {
			if (input < 0) {
				input = -input;
				negativeNumber = true;
			}
			String strInput = Integer.toString(input);
			findPermutation(strInput, 0, strInput.length() - 1, result, negativeNumber);
			Permutation perm = new Permutation();
			perm.setInput(input);
			Set<Outputval> outputVallist = new HashSet<>();
			for (Integer ip : result) {
				Outputval value = new Outputval();
				value.setCombination(ip);
				value.setPermutation(perm);
				outputVallist.add(value);
			}
			perm.setPermval(outputVallist);
			permJpaRepo.save(perm);			
		}

		return result;
	}

	private void findPermutation(String strInput, int low, int high,List<Integer> result,boolean isNegativeNumber) {
		if (low == high) {
			if (isNegativeNumber) {
				Integer num = Integer.parseInt(strInput);
				result.add(-num);
			} else {
				result.add(Integer.parseInt(strInput));
			}

		} else {
			for (int i = low; i <= high; i++) {
				strInput = swap(strInput, low, i);
				findPermutation(strInput, low + 1, high, result, isNegativeNumber);
				strInput = swap(strInput, low, i);
			}
		}		
	}

	private String swap(String strInput, int low, int high) {
		char temp; 
        char[] charArray = getCharacterArrayOfString(strInput); 
        temp = charArray[low] ; 
        charArray[low] = charArray[high]; 
        charArray[high] = temp; 
        return String.valueOf(charArray); 
	}

	private char[] getCharacterArrayOfString(String strInput) {
		int length = strInput.length();
		char[] charArr = new char[length];
		for(int i=0; i<length;i++) {			
			charArr[i] = strInput.charAt(i);
		}
		return charArr;
	}

}
