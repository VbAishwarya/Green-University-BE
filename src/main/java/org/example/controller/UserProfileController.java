package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.model.UserProfile;
import org.example.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    @Autowired
    private UserProfileService userProfileService;

    @Operation(summary = "to create a user profile", description = "to create a user profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PostMapping
    public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfile userProfile) {
        logger.info("creating a user profile");
        UserProfile createdProfile = userProfileService.createProfile(userProfile);
        return ResponseEntity.ok(createdProfile);
    }

    @Operation(summary = "get user profile by id", description = "get user profile by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved by id successfully"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable Long id) {
        logger.info("retrieving a user profile by id");
        UserProfile userProfile = userProfileService.getProfile(id);
        return ResponseEntity.ok(userProfile);
    }

    @Operation(summary = "get all user profiles", description = "get all user profiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All user profiles retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllProfiles() {
        logger.info("retrieving all user profile");
        List<UserProfile> profiles = userProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @Operation(summary = "update user profiles", description = "update user profiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User profiles updated successfully"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable Long id,@RequestBody UserProfile userProfile) {
        logger.info("updating user profile by id");
        UserProfile updatedProfile = userProfileService.updateProfile(id, userProfile);
        return ResponseEntity.ok(updatedProfile);
    }
}
