package com.permutation.question.permutation.permutationjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermutationJpaRepo extends JpaRepository<Permutation,Integer> {

}
