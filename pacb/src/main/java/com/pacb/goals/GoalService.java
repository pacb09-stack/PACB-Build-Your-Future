package com.pacb.goals;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal goal) {
        goal.setCompleted(false);
        return goalRepository.save(goal);
    }

    @Transactional(readOnly = true)
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public long countGoals() {
        return goalRepository.count();
    }
}
