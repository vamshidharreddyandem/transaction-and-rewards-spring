package com.rewards.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rewards.rest.model.Transaction;
import com.rewards.rest.service.RewardsPointsService;



@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class SpringBootTransactionApplicationTests {
	@Autowired
	private RewardsPointsService TransactionService;
	
private static List<Transaction> list = new ArrayList<Transaction>();
    
    static 
    {
        list.add(new Transaction(1,  "A,B", 200, 1, 2021));
        list.add(new Transaction(2,  "C,D", 300, 2, 2021));
        list.add(new Transaction(1,  "E,F", 500, 3, 2021));
    }
	
	@SuppressWarnings("deprecation")
	@Test
	public void TransactionTest() {
		Map<String, Integer> points = TransactionService.calculateRewardPoints(list);
		Map<String, Integer> testPoints = new HashMap<String, Integer>();
		testPoints.put("1", 250);
		testPoints.put("2", 450);
		testPoints.put("3", 850);
		testPoints.put("totalpoints", 1550);
	    Assert.assertEquals(points, testPoints);
	 }

}
