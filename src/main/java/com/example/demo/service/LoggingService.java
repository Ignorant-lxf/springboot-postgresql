package com.example.demo.service;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Service;

//@Service
public interface LoggingService {
  Account selectByUsername(String username);
}
