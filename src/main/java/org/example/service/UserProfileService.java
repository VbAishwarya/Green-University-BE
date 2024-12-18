package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.UserProfile;
import org.example.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getProfile(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public List<UserProfile> getAllProfiles() {
        return userProfileRepository.findAll();
    }

    public UserProfile updateProfile(Long id, UserProfile userProfile) {
        UserProfile existingProfile = userProfileRepository.findById(id).orElse(null);
        if (existingProfile != null) {
            if (userProfile.getFirstName() != null) {
                existingProfile.setFirstName(userProfile.getFirstName());
            }
            if (userProfile.getLastName() != null) {
                existingProfile.setLastName(userProfile.getLastName());
            }
            if (userProfile.getEmail() != null) {
                existingProfile.setEmail(userProfile.getEmail());
            }
            if (userProfile.getProfilePicture() != null) {
                existingProfile.setProfilePicture(userProfile.getProfilePicture());
            }
            return userProfileRepository.save(existingProfile);
        }
        throw new ResourceNotFoundException("User profile not found with id " + id);
    }

}
