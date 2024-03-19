package app.personaltargets.controller;

import app.personaltargets.model.ReminderModel;
import app.personaltargets.service.ReminderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reminder")
@RequiredArgsConstructor
public class ReminderController {

    private final ReminderService reminderService;

    @GetMapping("/allByUser/{id}")
    public ResponseEntity<List<ReminderModel>> getAllByUserId(@PathVariable Long id){
        return ResponseEntity.ok(reminderService.getAllByUserId(id));
    }

    @PostMapping("/addNewReminder")
    public ResponseEntity<ReminderModel> createReminder(@Valid @RequestBody ReminderModel reminder){
        return ResponseEntity.ok(reminderService.createNewReminder(reminder));
    }
    @PutMapping("/modifyById/{id}")
    public ResponseEntity<ReminderModel> changeReminder(@PathVariable Long id, @Valid @RequestBody ReminderModel reminder){
        return ResponseEntity.ok(reminderService.updateReminder(id, reminder));
    }

}
