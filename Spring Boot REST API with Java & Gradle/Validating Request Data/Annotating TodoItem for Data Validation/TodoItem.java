package com.codesignal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TodoItem {

    // TODO: Add @NotBlank and @Size annotations for title
    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, message = "Title must be at least 3 characters")
    private String title;

    // TODO: Add @NotBlank and @Size annotations for description
        @NotBlank(message = "Description is mandatory")
    @Size(max = 256, message = "Description must not exced 256 characters")
    private String description;

    // TODO: Add @NotBlank and @Pattern annotations for status
    @NotBlank(message = "Status is mandatory")
    @Pattern(regexp = "^(PENDING|COMPLETED)$", message = "Status must be either PENDING or COMPLETED")
    private String status;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}