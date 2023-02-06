package com.service.todo;

import com.dao.TodoDao;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {
    private final TodoDao todoDao;
    private final EncryptionService encryptionService;
}
