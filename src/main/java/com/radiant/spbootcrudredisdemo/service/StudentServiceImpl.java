package com.radiant.spbootcrudredisdemo.service;

import com.radiant.spbootcrudredisdemo.entity.Student;
import com.radiant.spbootcrudredisdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with the given id: " + id));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student s = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with the given id: " + id));

        s.setName(student.getName());
        s.setDateOfBirth(student.getDateOfBirth());
        s.setAddress(student.getAddress());
        s.setAge(student.getAge());
        s.setSalary(student.getSalary());
        s.setPercentage(student.getPercentage());
        s.setEmail(student.getEmail());
        s.setPhone(student.getPhone());
        s.setBranch(student.getBranch());
        s.setIsMonitor(student.getIsMonitor());

        return studentRepository.save(s);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with the given id: " + id));

        studentRepository.delete(student);
    }
}
