package app.personaltargets.controller;

import app.personaltargets.dto.HabitDto;
import app.personaltargets.model.HabitModel;
import app.personaltargets.service.HabitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping("/AllByUserId/{id}")
    public ResponseEntity<List<HabitModel>> getAllByUserId(@PathVariable Long id){
        return ResponseEntity.ok(habitService.getAllByUserId(id));
    }

    @PostMapping("/addNew")
    public ResponseEntity<HabitModel> createHabit(@Valid @RequestBody HabitDto habit){
        return ResponseEntity.ok(habitService.createNewHabit(habit));
    }

}
