package net.javaguides.todo.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
