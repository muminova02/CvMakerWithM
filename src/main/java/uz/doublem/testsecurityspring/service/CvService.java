package uz.doublem.testsecurityspring.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.doublem.testsecurityspring.entity.*;
import uz.doublem.testsecurityspring.exception.CustomException;
import uz.doublem.testsecurityspring.exception.ResourceNotFoundException;
import uz.doublem.testsecurityspring.payload.CvDto;
import uz.doublem.testsecurityspring.payload.EducationDto;
import uz.doublem.testsecurityspring.payload.ResponseTemplate;
import uz.doublem.testsecurityspring.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CvService
{
    private final CvRepository cvRepository;
    private final UserRepository userRepository;
    private final EducationRepository educationRep;
    private final ExperiencesRepository experiencesRep;
    private final SkillsRepository skillsRep;
    private final LanguagesRepository languagesRep;
    private final SocialLinksRepository socialLinksRep;


    public List<CvDto> getAllCvDtoById(Integer userId){
       List<Cv> cvList = cvRepository.getAllCvByUserId(userId);
        List<CvDto> cvDtoList = new ArrayList<>();
        cvList.forEach(cv -> {
            CvDto cvDto = new CvDto();
            cvDto.setId(cv.getId());
            cvDto.setPhotoName(cv.getPhotoName());
            cvDto.setFullName(cv.getFullName());
            cvDto.setJobTitle(cv.getJobTitle());
            cvDtoList.add(cvDto);
        });
        return cvDtoList;
    }

    public Cv getCvByCvId(Integer cvId) {
        return cvRepository.findById(cvId).orElse(null);
    }

    public ResponseTemplate saveCvWithDto(CvDto cvDto) {
        return null;
    }

    public Cv newCreateDefaultCv(Integer id) {
        Cv cv = new Cv();
        Optional<User> byId = userRepository.findById(id);
        byId.ifPresent(cv::setUser);
        return cvRepository.save(cv);
    }

    @Transactional
    public void saveEducationToCv(Integer id, EducationDto education) {
        try {
            Cv cv = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            Education education1 = Education.builder()
                    .universityName(education.getUniversityName())
                    .degree(education.getDegree())
                    .fieldStudy(education.getFieldStudy())
                    .fromYear(education.getFromYear())
                    .toYear(education.getToYear())
                    .cv(cv)
                    .build();

            educationRep.save(education1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving education to cv", e);
        }

    }
    @Transactional
    public void saveInformToCv(Integer id, Cv cv) {
        try {
            Cv cv1 = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            cv1.setFullName(cv.getFullName());
            cv1.setAddress(cv.getAddress());
            cv1.setEmail(cv.getEmail());
            cv1.setPhotoName(cv.getPhotoName());
            cv1.setJobTitle(cv.getJobTitle());
            cv1.setPhoneNumber(cv.getPhoneNumber());
            cv1.setWebsiteLink(cv.getWebsiteLink());
            cv1.setYourBio(cv.getYourBio());
            cvRepository.save(cv1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving education to cv", e);
        }
    }

    @Transactional
    public void deleteEducationById(Integer educationId) {
        educationRep.delete(educationId);
    }

    @Transactional
    public void deleteExperienceById(Integer experienceId) {
        experiencesRep.delete(experienceId);
    }

    @Transactional
    public void deleteSkillsById(Integer skillId) {
        skillsRep.delete(skillId);
    }

    @Transactional
    public void deleteSocialLinkById(Integer socialLinkId) {
        socialLinksRep.delete(socialLinkId);
    }

    @Transactional
    public void deleteLanguageById(Integer languageId) {
        languagesRep.delete(languageId);
    }


    @Transactional
    public void saveExperiencesById(Integer id, Experiences experiences) {
        try {
            Cv cv = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            Experiences experiences1 = Experiences.builder()
                    .title(experiences.getTitle())
                    .company(experiences.getCompany())
                    .description(experiences.getDescription())
                    .toYear(experiences.getToYear())
                    .fromYear(experiences.getFromYear())
                    .cv(cv)
                    .build();

            experiencesRep.save(experiences1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving experiences to cv", e);
        }

    }

    @Transactional
    public void saveSkillsById(Integer id, Skills skills) {
        try {
            Cv cv = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            Skills skills1 = Skills.builder()
                    .skill(skills.getSkill())
                    .proficiency(skills.getProficiency())
                    .cv(cv)
                    .build();
            skillsRep.save(skills1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving skills to cv", e);
        }
    }

    @Transactional
    public void saveSocialLinksById(Integer id, SocialLinks socialLinks) {
        try {
            Cv cv = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            SocialLinks socialLinks1 = SocialLinks.builder()
                    .link(socialLinks.getLink())
                    .name(socialLinks.getName())
                    .cv(cv)
                    .build();
            socialLinksRep.save(socialLinks1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving socialLinks to cv", e);
        }

    }

    @Transactional
    public void saveLanguageById(Integer id, Languages languages) {
        try {
            Cv cv = cvRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Cv not found with id: " + id));

            Languages languages1 = Languages.builder()
                    .language(languages.getLanguage())
                    .level(languages.getLevel())
                    .cv(cv)
                    .build();
            languagesRep.save(languages1);

        } catch (Exception e) {
            throw new CustomException("Error occurred while saving languages to cv", e);
        }
    }
}
