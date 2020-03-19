package com.permutation.question.permutation.test

import static org.junit.Assert.assertTrue
import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity

import org.springframework.http.HttpStatus

import com.permutation.question.permutation.PermutationApplication
import com.permutation.question.permutation.Process
import com.permutation.question.permutation.nodes.PermutationListNode
import com.permutation.question.permutation.nodes.ResponseNode
import com.permutation.question.permutation.permutationjpa.Outputval
import com.permutation.question.permutation.permutationjpa.Permutation
import com.permutation.question.permutation.permutationjpa.PermutationJpaRepo

import groovy.transform.AutoClone
import javax.activation.DataSource
import spock.lang.Specification
import spock.lang.Stepwise


@AutoConfigureMockMvc
@Stepwise
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PermutationTestController extends Specification {	
 
	@Autowired
	TestRestTemplate restTemplate;
	
	def '/permutation/123 should suceess as true'() {
		when:
		def entity = restTemplate.getForEntity('/permutation/permutations/123',ResponseNode.class)
		then:
		entity.statusCode == HttpStatus.ACCEPTED
		entity.body.success == true	
		
	}
	
	def '/permutation/test should suceess as false'() {
		when:
		def entity = restTemplate.getForEntity('/permutation/permutations/test',ResponseNode.class)
		then:
		entity.statusCode == HttpStatus.PRECONDITION_FAILED
		entity.body.success == false
		
	}
	
	def '/permutation/473145632456324 should suceess as false'() {
		when:
		def entity = restTemplate.getForEntity('/permutation/permutations/473145632456324',ResponseNode.class)
		then:
		entity.statusCode == HttpStatus.PRECONDITION_FAILED
		entity.body.success == false
		
	}
	
	def '/permutation/-123 should suceess as true'() {
		when:
		def entity = restTemplate.getForEntity('/permutation/permutations/-123',ResponseNode.class)
		then:
		entity.statusCode == HttpStatus.ACCEPTED
		entity.body.success == true
		
	}
	
	def '/permutation/ should suceess as false'() {
		when:
		def entity = restTemplate.getForEntity('/permutation/permutations/ ',ResponseNode.class)
		then:
		entity.statusCode == HttpStatus.PRECONDITION_FAILED
		entity.body.success == false
		
	}
	
	def '/permutations/list should suceess as true'() {		
		List<Integer> inputs = new ArrayList<>();
		inputs.add(123);
		inputs.add(456);
		PermutationListNode listNode = new PermutationListNode();
		listNode.setInput(inputs);
		
		when:
		def entity = restTemplate.postForEntity("/permutation/permutations/list",listNode,ResponseNode.class )
		then:
		entity.statusCode == HttpStatus.ACCEPTED
		entity.body.success == true		
		
	}
	
	def '/permutations/list should suceess as false'() {
		List<Integer> inputs = new ArrayList<>();
		PermutationListNode listNode = new PermutationListNode();
		listNode.setInput(inputs);
		
		when:
		def entity = restTemplate.postForEntity("/permutation/permutations/list",listNode,ResponseNode.class )
		then:
		entity.statusCode == HttpStatus.PRECONDITION_FAILED
		entity.body.success == false
		
	}
	
	def '/permutations/list without payload should suceess as false'() {	
		PermutationListNode listNode = new PermutationListNode();
		when:
		def entity = restTemplate.postForEntity("/permutation/permutations/list",listNode,ResponseNode.class )
		then:
		entity.statusCode == HttpStatus.PRECONDITION_FAILED
		entity.body.success == false		
	}
	
	def 'Set and get value of an permutation combination should work properly'() {
		//given
        final Outputval opVal = new Outputval();
        when:
        opVal.setCombination(1);
		then:
        assertEquals(opVal.getCombination(),1);
	}
	
	def 'Set and get value of an evnt id should work properly'() {
		//given
		final Outputval opVal = new Outputval();
		when:
		opVal.setEventId(1);
		then:
		assertEquals(opVal.getEventId(),1);
	}
	
	def 'Set and get value of permutation object should work properly'() {
		//given
		final Outputval opVal = new Outputval();
		opVal.setEventId(1);
		opVal.setCombination(1);
		Set<Outputval> opValset = new HashSet<>();
		opValset.add(opVal);		
		
		when:
		
		final Permutation perm= new Permutation(1,opValset);
		
		then:
		assertEquals(perm.getInput(),1);
	}
	
	def 'Set and get value of Output val object should work properly'() {
		//given
		
		final Permutation perm= new Permutation();
		perm.setInput(1);
		
		when:
		final Outputval opVal = new Outputval(perm,1);	
		opVal.setCombination(1);	
		
		then:
		assertEquals(opVal.getCombination(),1);
	}
	
	def 'Set and get value of Permuatation in outputval object should work properly'() {
		//given
		
		final Permutation perm= new Permutation();
		perm.setInput(1);
		
		when:
		final Outputval opVal = new Outputval();
		opVal.setPermutation(perm);
		
		then:
		assertEquals(opVal.getPermutation().getInput(),1);
	}
	
	def 'Check for main method is executed properly!!'() {
		when:
		PermutationApplication.main("hello");
		then:
		assertTrue(true);
	}
	
}
