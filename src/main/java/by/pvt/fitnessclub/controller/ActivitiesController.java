package by.pvt.fitnessclub.controller;

import by.pvt.fitnessclub.entity.Activities;
import by.pvt.fitnessclub.service.ActivitiesService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivitiesController {
    private final ActivitiesService activitiesService;

    @ModelAttribute
    public void initAttribute(Model model) {
        model.addAttribute("activitiesModel", new Activities());
    }

    @GetMapping("/activities")
    public String activitiesPage() {
        return "activities/activities";
    }

    @GetMapping("/getActivities")
    public ModelAndView getActivities() {
        var activities = activitiesService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        ModelMap modelMap = new ModelMap();
        Map<String, Collection<Activities>> activitiesMap = new HashMap<>();
        activitiesMap.put("activities1", activities);
        modelMap.addAllAttributes(activitiesMap);
        modelAndView.addAllObjects(modelMap);
        modelAndView.setViewName("activities/activities");
        return modelAndView;
    }

    @PostMapping("/addActivities")
    public ModelAndView addActivities(Activities activities, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activities/activities");
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getAllErrors().get(0));
            modelAndView.setViewName("error");
            return modelAndView;
        }
        model.addAttribute("activity", activities);
        var activity = activitiesService.save(activities);
        modelAndView.addObject("newActivity", activity);
        return modelAndView;
    }

    @PostMapping("/deleteActivities")
    public ModelAndView deleteActivities(Long id) {
        activitiesService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activities/activities");
        return modelAndView;
    }

    @GetMapping("/getActivity")
    public ModelAndView getActivity(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activities/activities");
        var activityById = activitiesService.findById(id);
        modelAndView.addObject("activityResponse", activityById);
        return modelAndView;
    }

    @PostMapping("/updateActivities")
    public ModelAndView updateActivities(@Validated Activities activities) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("activities/activities");
    var activity = activitiesService.save(activities);
    modelAndView.addObject("updateActivity", activity);
    return modelAndView;
    }
}
