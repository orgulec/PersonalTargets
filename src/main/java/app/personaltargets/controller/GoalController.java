package app.personaltargets.controller;

import app.personaltargets.model.GoalModel;
import app.personaltargets.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/target")
@RequiredArgsConstructor
public class TargetController {

    private final GoalService goalService;
    @GetMapping("/allById/{id}")
    public ResponseEntity<List<GoalModel>> getById(@PathVariable Long id){
        return ResponseEntity.ok(goalService.getByUserId(id));
    }

    @PostMapping("/addNew")
    public ResponseEntity<GoalModel> addNewTarget(@RequestBody GoalModel target){
        return ResponseEntity.ok(goalService.addTarget(target));
    }

}
