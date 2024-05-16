package com.MonthlyChalllengeApp;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class ChallengeServiceimpl implements ChallengeService {
	private ChallengeRepository challengeRepository;
	
//	List<Challenge>challenges=new ArrayList<>();
//	private Long nextId=2L;

//	 public ChallengeServiceimpl() {
//	        // Add sample challenges to the list
//	        challenges.add(new Challenge( 1L, "jan","Description of Challenge 1"));
//	        challenges.add(new Challenge( 2L,"feb", "Description of Challenge 2"));
//	        // Add more challenges as needed
//	    }


	public ChallengeServiceimpl(ChallengeRepository challengeRepository) {
		super();
		this.challengeRepository = challengeRepository;
	}


	@Override
	public List<Challenge> getAllChallenges() {
		
		return challengeRepository.findAll();
	}


	@Override
	public Boolean addChallenge( Challenge challenge) {
		
		Challenge challnge= challengeRepository.save(challenge);

		if (challnge!=null) {
			return true;
		} else {
return false;
		}
	
	}


	@Override
	public Challenge getChallengeById(Long id) {
		Optional<Challenge> challnge=challengeRepository.findById(id);
		
			return challnge.orElse(null);
		
		
//		for (Challenge challenge : challenges) {
//			if(challenge.getId().equals(id)) {
//				return challenge;
//			}
//		}
//		return null;
	}


	@Override
	public Boolean deleteChallenge(Long id) {
		
		Optional<Challenge> challnge=challengeRepository.findById(id);
		if (challnge.isPresent()) {
			
			challengeRepository.deleteById(id);
			return true;
		} else {
return false;
		}
		
		
//		Challenge challnge=challengeRepository.findById(id).get();
//		if (challnge!=null) {
//			challengeRepository.delete(challnge);
//			return true;
//		} else {
//return false;
//		}
//		for (Challenge challenge : challenges) {
//			if(challenge.getId().equals(id)) {
//			challenges.remove(challenge);
//			return true;
//			}
//		}
//		
//		return false;
	}


	@Override
	public Boolean updateChallenge(Long id, Challenge challenge) {
		
		Optional<Challenge> challnge=challengeRepository.findById(id);
		if (challnge.isPresent()) {
			Challenge chalnge=challnge.get();
			chalnge.setMonth(challenge.getMonth());
			chalnge.setDescription(challenge.getDescription());
			challengeRepository.save(chalnge);
			return true;
		} else {
return false;
		}
		
		
		
//		for (Challenge challng : challenges) {
//			if(challng.getId().equals(id)) {
//				
//				challng.setMonth(challenge.getMonth());
//				challng.setDescription(challenge.getDescription());
//				
//			return challng;
//			}
		
				
	}

}
