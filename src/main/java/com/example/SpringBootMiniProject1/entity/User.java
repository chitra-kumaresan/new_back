package com.example.SpringBootMiniProject1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;



    @ManyToMany(fetch =FetchType.EAGER,cascade =CascadeType.ALL)
        @JoinTable(name="users_roles",
                joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="roles_id",referencedColumnName = "id"))
        private Set<Role> roles;

}
