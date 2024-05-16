package com.MonthlyChalllengeApp;

import java.util.List;

public interface ChallengeService {
List<Challenge>getAllChallenges();

Boolean addChallenge( Challenge challenge);

Challenge getChallengeById(Long id);

Boolean deleteChallenge(Long id);

Boolean updateChallenge(Long id, Challenge challenge);
}
