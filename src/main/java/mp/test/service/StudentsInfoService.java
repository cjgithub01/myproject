package mp.test.service;

import mp.test.entities.StudentInfo;
import mp.test.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsInfoService {

    @Autowired
    private StudentRepository studentRepository;

    public String submitInfo(StudentInfo studentInfo) {

        studentRepository.save(studentInfo);
        return studentInfo.getId().toString();
    }

}
