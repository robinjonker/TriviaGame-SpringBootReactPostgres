package com.example.demo.log_trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> getLog() {
        return logRepository.findAll();
    }

    public  List<Log> getLogStudent(Long studentId) {
        return logRepository.findAllByStudent_id(studentId);
    }

    public void addNewLog(Log log) {
        logRepository.save(log);
    }
}