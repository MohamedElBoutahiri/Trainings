package com.test.adstracking.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.test.adstracking.model.Ad;
import com.test.adstracking.repository.AdRepository;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	private AdRepository adRepository;

	@Autowired
	private ScoreService scoreService;

	@Override
	public List<Ad> getAdsByScoreGreaterThanEqual(int score, int nPage) {

		int first = nPage * 100;
		int end = first + 100;
		Pageable pageWith100Elements = PageRequest.of(first, end);

		return adRepository.findByScoreGreaterThanEqualOrderByScoreDesc(40, pageWith100Elements);

	}

	@Override
	public List<Ad> getAdsByScoreLessThan(int score, int nPage) {

		int first = nPage * 100;
		int end = first + 100;
		Pageable pageWith100Elements = PageRequest.of(first, end);
		adRepository.findAll();

		return adRepository.findByScoreLessThanOrderByScoreDesc(40, pageWith100Elements);

	}

	/*
	 * NOTES: Optimization, normally we don't need to calculate all the scores, just
	 * the ones has been modified. We could save the lastExecutionDate of this
	 * method, and then calculate the score of the ads that were created after In
	 * this case, we iterate over all the ads.
	 * 
	 * We should check all the nullpointerexceptions, we don't execute a code if we
	 * have nothing to execute.
	 * 
	 * We should also do some logging. We could use AOP, to centralize the loggins.
	 * 
	 * In a real scenario, we should do all these actions. We note them here, to
	 * state that we are aware of it, because of it time cannot treat as a real
	 * project.
	 */
	@Override
	public void calculateScore() {

		adRepository.findAll().forEach(ad -> {
			int score = scoreService.calculateScorePerAd(ad);
			ad.setScore(score);
			ad.setLastDateUpdate(new Date());
			adRepository.save(ad);
		});

	}

}
