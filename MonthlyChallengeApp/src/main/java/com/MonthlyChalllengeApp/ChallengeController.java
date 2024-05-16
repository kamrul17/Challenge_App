package com.MonthlyChalllengeApp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
private ChallengeService challengeService;

	public ChallengeController(ChallengeService challengeService) {
	super();
	this.challengeService = challengeService;
}

	@GetMapping
	public ResponseEntity< List<Challenge>>getAllChallenges(){
		return new ResponseEntity<> (challengeService.getAllChallenges(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity< Challenge> getChallengeById(@PathVariable Long id){
		Challenge getChal= challengeService.getChallengeById(id);
		if (getChal!=null) {
			return new ResponseEntity<>(getChal,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public  ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
		Boolean isAdded= challengeService.addChallenge(challenge);
		if (isAdded) {
			return new ResponseEntity<>("Challenge Added successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Challenge Not Added ",HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	
	public  ResponseEntity<String> deleteChallenge(@PathVariable Long id){
		Boolean isDeleted= challengeService.deleteChallenge(id);
		if (isDeleted) {
			return new ResponseEntity<>("Challenge deleted successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Challenge Not deleted ",HttpStatus.NOT_FOUND);
		}
	}
@PutMapping("/{id}")
	
	public  ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge challenge){
	Boolean isUpdatedch=challengeService.updateChallenge(id,challenge);
	if (isUpdatedch) {
		return new ResponseEntity<>("Challenge Updated successfully",HttpStatus.OK);
	} else {
		return new ResponseEntity<>("Challenge Not Updated ",HttpStatus.NOT_FOUND);
	}
	}
	
	
}
