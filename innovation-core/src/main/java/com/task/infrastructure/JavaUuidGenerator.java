package com.task.infrastructure;

import com.task.domain.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
