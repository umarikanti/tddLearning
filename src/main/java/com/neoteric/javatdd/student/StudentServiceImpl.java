package com.neoteric.javatdd.student;

import com.neoteric.javatdd.student.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public int add(int a, int b) {
        return  a + b;
    }
}
