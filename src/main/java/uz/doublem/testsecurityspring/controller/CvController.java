package uz.doublem.testsecurityspring.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import uz.doublem.testsecurityspring.entity.*;
import uz.doublem.testsecurityspring.payload.CvDto;
import uz.doublem.testsecurityspring.payload.EducationDto;
import uz.doublem.testsecurityspring.payload.ResponseTemplate;
import uz.doublem.testsecurityspring.service.CvService;

import java.util.List;

@Controller
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CvController {

    private final CvService cvService;

    @GetMapping("/{id}")
    public String cv(@PathVariable Integer id, Model model) {
        List<CvDto> cvListDto = cvService.getAllCvDtoById(id);
        model.addAttribute("cvListDto", cvListDto);
        model.addAttribute("userId",id);
        return "main-page";
    }

    @GetMapping("/show/{id}")
    public String showCvById(@PathVariable Integer id, Model model) {
       Cv cv = cvService.getCvByCvId(id);
       model.addAttribute("cv", cv);
       return "cv-show";
    }

    @GetMapping("/create/{id}")
    public String create(@PathVariable Integer id, Model model) {
        Cv newCv = cvService.newCreateDefaultCv(id);
        model.addAttribute("cv", newCv);
        return "cv-create";
    }

    @GetMapping("create/process/{id}")
    public String createProcess(@PathVariable Integer id, Model model) {
//        Integer i = Integer.valueOf(id);
        Cv cv = cvService.getCvByCvId(id);
        model.addAttribute("cv", cv);
        return "cv-create";
    }

    @GetMapping("/show-edit/{id}")
    public String showEdit(@PathVariable Integer id,Model model) {
        Cv cvByCvId = cvService.getCvByCvId(id);
        model.addAttribute("cv", cvByCvId);
        return "cv-show-edit";
    }



    @PostMapping("/create/education/{id}")
    public String createEducation(@PathVariable Integer id, @ModelAttribute("education") EducationDto education, Model model) {
        cvService.saveEducationToCv(id,education);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/education/{id}/delete")
    public String deleteEducation(@RequestParam("educationId") Integer educationId,@PathVariable Integer id, Model model) {
        cvService.deleteEducationById(educationId);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/experiences/{id}/delete")
    public String deleteExperience(@RequestParam("experienceId") Integer experienceId,@PathVariable Integer id, Model model) {
        cvService.deleteExperienceById(experienceId);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }
    @PostMapping("/create/skills/{id}/delete")
    public String deleteSkills(@RequestParam("skillId") Integer skillId,@PathVariable Integer id, Model model) {
        cvService.deleteSkillsById(skillId);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }
    @PostMapping("/create/socialLinks/{id}/delete")
    public String deleteSocialLinks(@RequestParam("socialLinkId") Integer socialLinksId,@PathVariable Integer id, Model model) {
        cvService.deleteSocialLinkById(socialLinksId);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }
    @PostMapping("/create/languages/{id}/delete")
    public String deleteLanguage(@RequestParam("languageId") Integer languageId,@PathVariable Integer id, Model model) {
        cvService.deleteLanguageById(languageId);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/inform/{id}")
    public String createInform(@PathVariable Integer id, @ModelAttribute("cv") Cv cv, Model model) {
        cvService.saveInformToCv(id,cv);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }


    @PostMapping("/create/experience/{id}")
    public String createExperience(@PathVariable Integer id, @ModelAttribute("experience") Experiences experiences, Model model) {
        cvService.saveExperiencesById(id,experiences);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/skills/{id}")
    public String createSkills(@PathVariable Integer id, @ModelAttribute("skills") Skills skills, Model model) {
        cvService.saveSkillsById(id,skills);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/social-links/{id}")
    public String createSocialLinks(@PathVariable Integer id, @ModelAttribute("social-links") SocialLinks socialLinks, Model model) {
        cvService.saveSocialLinksById(id,socialLinks);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }

    @PostMapping("/create/language/{id}")
    public String createLanguage(@PathVariable Integer id, @ModelAttribute("languages")Languages language, Model model) {
        cvService.saveLanguageById(id,language);
        model.addAttribute("cvId", id);
        return String.format("redirect:/cv/create/process/%d",id);
    }










}
