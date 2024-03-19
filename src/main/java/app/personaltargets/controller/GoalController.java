package app.personaltargets.controller;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.service.GoalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    @GetMapping("/getById/{id}")
    public ResponseEntity<GoalModel> getById(@PathVariable Long id){
       return ResponseEntity.ok(goalService.getById(id));
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<List<GoalModel>> getAllByUserId(@PathVariable Long id){
       return ResponseEntity.ok(goalService.getAllByUserId(id));
    }

    @PostMapping("/addNew")
    public ResponseEntity<GoalModel> addNewGoal(@Valid @RequestBody GoalDto goal){
        return ResponseEntity.ok(goalService.addGoal(goal));
    }
    @PutMapping("/modifyById/{id}")
    public ResponseEntity<GoalModel> changeGoal(@PathVariable Long id, @Valid @RequestBody GoalDto goal){
        return ResponseEntity.ok(goalService.updateGoalById(id, goal));
    }


}
