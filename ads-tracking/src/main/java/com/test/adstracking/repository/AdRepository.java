package com.test.adstracking.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.adstracking.model.Ad;

/**
 * Repostory interface to handle the transaction DB for the Ads.
 * 
 * @author Mohamed El Boutahiri
 *
 */

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {
	
	List<Ad> findByScoreGreaterThanEqualOrderByScoreDesc(int score, Pageable page);
	
	List<Ad> findByScoreLessThanOrderByScoreDesc(int score, Pageable page);

}
