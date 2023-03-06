package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;
// import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model){
        // Grade grade = new Grade("Harry", "Potions", "C-");
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        Grade grade;
        if (getGradeIndex(id) == -1000){
            grade = new Grade();
        } else {
            grade = studentGrades.get(getGradeIndex(id));
        }
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result){
        if (result.hasErrors()){
            return "form";
        }
        if (getGradeIndex(grade.getId()) == -1000){
            studentGrades.add(grade);
        }
        else {
            studentGrades.set(getGradeIndex(grade.getId()), grade);
        }
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String id){
        for(int i = 0;i<studentGrades.size();i++){
            if (studentGrades.get(i).getId().equals(id)) return i;
        }
        return -1000;
    }
}
