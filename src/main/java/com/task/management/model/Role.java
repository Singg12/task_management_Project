package com.task.management.model;

import java.util.Set;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.task.management.model.PermissionEnum.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Role {
    ADMIN(Set.of(TASK_READ,TASK_DELETE,TASK_UPDATE,TASK_WRITE,USER_READ,USER_WRITE,USER_UPDATE,USER_DELETE)),
    USER(Set.of(TASK_READ));

    private Set<PermissionEnum> permission;

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> grantedAuthorities = this.permission.stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getDescription()))
            .collect(Collectors.toSet());
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_"+ this.name());
        grantedAuthorities.add(role);

        return grantedAuthorities;
    }
}
