package br.com.ada.adatask.domain;

import java.time.LocalDateTime;

public record Task(String title, String description, LocalDateTime deadline) {
}
