
package com.pacb.goals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/goals")
    public String showGoals(Model model) {
        model.addAttribute("goals", goalService.getAllGoals());
        model.addAttribute("goal", new Goal());
        return "goals";
    }

    @PostMapping("/goals")
    public String createGoal(@ModelAttribute Goal goal) {
        goalService.createGoal(goal);
        return "redirect:/goals";
    }
}
