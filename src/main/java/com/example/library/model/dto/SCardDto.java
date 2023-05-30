package com.example.library.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class SCardDto {
    private long bookId;
    private long librarianId;
    private long studentId;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;

}
