package com.rewards.rest.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.rewards.rest.model.Transaction;


@Service
public class RewardsPointsService implements RewardsService
{
	public Map<String, Integer> calculateRewardPoints(List<Transaction> transactions) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Set<Integer> monthSet = new HashSet<Integer>();
		Integer totalPoints = 0;
		
		for(Transaction t : transactions) {
			monthSet.add(t.getMonth());
		}
		
		
		for(Object month : monthSet) {
			
			List<Transaction> filterList = transactions.stream().filter(t-> t.getMonth() == (Integer) month).collect(Collectors.toList());	
			Integer monthTransactAmount = 0;
			for(Transaction t : filterList) {
				monthTransactAmount += t.getTransactionValue();
			}
			Integer monthRewardPoint = 0;
			if(monthTransactAmount > 100) {
				monthRewardPoint = (monthTransactAmount - 100)*2 + 50;
			}else if(monthTransactAmount > 50) {
				monthRewardPoint = (monthTransactAmount - 50);
			}
			result.put(month+"", monthRewardPoint);
			totalPoints += monthRewardPoint;
		}
		result.put("totalpoints", totalPoints);
		return result;
	}

}
