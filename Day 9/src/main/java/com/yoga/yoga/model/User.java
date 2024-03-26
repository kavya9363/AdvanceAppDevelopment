package com.yoga.yoga.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yoga.yoga.model.enumerate.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
  
    @Column(nullable = false)
    private String confirmPassword;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    private Academy academy;

    // @CreatedDate
    // @Temporal(TemporalType.TIMESTAMP)
    // @Column(nullable = false, updatable = false)
    // private Date createdAt;

    // @LastModifiedDate
    // @Temporal(TemporalType.TIMESTAMP)
    // @Column(nullable = true)
    // private Date updatedAt;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ManyToMany(mappedBy = "users")
    private Set<Course> courses;

    @ManyToMany(mappedBy = "users")
    private Set<Academy> academies;
    
    // @PrePersist
    // protected void onCreate() {
    //     createdAt = new Date();
    // }

    // @PreUpdate
    // protected void onUpdate() {
    //     updatedAt = new Date();
    // }
}
