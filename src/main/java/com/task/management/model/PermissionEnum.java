package com.task.management.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PermissionEnum {
    TASK_READ("task:read"),
    TASK_WRITE("task:write"),
    TASK_UPDATE("task:update"),
    TASK_DELETE("task:delete"),
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");
    


    private String description;

}
