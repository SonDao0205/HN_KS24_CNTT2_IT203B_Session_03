package BTTH.model;

import java.time.LocalDate;

public record User(String id, String email, String password, boolean verified, LocalDate createdAt) {}
