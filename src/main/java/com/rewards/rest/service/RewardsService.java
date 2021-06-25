package com.rewards.rest.service;

import java.util.List;
import java.util.Map;

import com.rewards.rest.model.Transaction;

public interface RewardsService {

/* Looks up all [Challenge] associated with
 an interview identified by id and returns
 as a List.
*/
Map<String, Integer> calculateRewardPoints(List<Transaction> transactions);
}
