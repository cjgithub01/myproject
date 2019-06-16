package mp.test.controllers;

import mp.test.entities.StudentInfo;
import mp.test.service.StudentsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/studentInfo")
public class PublicController {
    @Autowired
    private StudentsInfoService studentsInfoService;

    @RequestMapping("insertInfo")
    public  Map getStudentsInfo(StudentInfo studentInfo){
        Map map = new HashMap();
        String id = studentsInfoService.submitInfo(studentInfo);
        map.put("msg","success");
        map.put("studentInfoId",id);
        return map;
    }

    @RequestMapping("toIndex")
    public String toIndex(String id, Model model){
        model.addAttribute("id",id);
        return "/common/index";
    }
    @RequestMapping("login")
    public String login(){
        return  "/index";
    }

}
