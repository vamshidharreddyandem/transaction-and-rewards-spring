package com.rewards.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.rest.model.Transaction;
import com.rewards.rest.service.RewardsPointsService;

@RestController
@RequestMapping(path = "/rewardPoints")
public class RewardsPointsController 
{
    @Autowired
    private RewardsPointsService rewardsService;
    
	
	  @PostMapping(path="/calculateRewardPoints", produces = "application/json")
	  public Map<String, Integer> calculateRewardPoints(@RequestBody List<Transaction> transactions) {
		  return rewardsService.calculateRewardPoints(transactions); 
	  }
	 
    
	
}
