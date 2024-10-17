package uz.doublem.testsecurityspring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    private String photoName;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String jobTitle;
    private String address;
    private String websiteLink;
    private String yourBio;
    @Builder.Default
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Education> education;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Experiences> experiences;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Skills> skills;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SocialLinks> socialLinks;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Languages> languages;

}
