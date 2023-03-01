package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    List<Grade> studentGrades = Arrays.asList(
        new Grade("Harry", "Potions", "C-"), 
        new Grade("Hermoine", "Bitchcraft", "A+"),
        new Grade("Chad", "Charms", "A++")

    );

    @GetMapping("/grades")
    public String getGrades(Model model){
        // Grade grade = new Grade("Harry", "Potions", "C-");
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}
