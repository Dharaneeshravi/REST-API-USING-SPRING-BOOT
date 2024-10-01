package com.Dharaneesh.REST.API.College;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CollegeController {

    private CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/college")
    public ResponseEntity<List<College>> getCollege()
    {
        return new ResponseEntity<>(collegeService. getCollege(),HttpStatus.OK);
    }

    @PostMapping("/college")
    public ResponseEntity<String> createCollege(@RequestBody College college)
    {
        collegeService.createCollege(college);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/college/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id)
    {
        College college=collegeService.getCollegeById(id);

        if(college!=null)
        {
            return new ResponseEntity<>(college,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/college/{id}")
    public ResponseEntity<String> updateCollegeById(@PathVariable Long id,@RequestBody College college)
    {
        boolean res=collegeService.updateCollegeById(id,college);

        if(res)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/college/{id}")
    public ResponseEntity<String> deleteCollegeById(@PathVariable Long id)
    {
        boolean res=collegeService.deleteCollegeById(id);

        if(res)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
