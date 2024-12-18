package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.model.DailyTip;
import org.example.service.DailyTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
public class DailyTipController {

    private static final Logger logger = LoggerFactory.getLogger(DailyTipController.class);

    @Autowired
    DailyTipService dailyTipService;

    @Operation(summary = "get all the tips", description = "get all the tips")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tips are successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Tips not found")
    })
    @GetMapping
    public List<DailyTip> getAllTips() {
        logger.info("Retrieving all the tips");
        return dailyTipService.getAllTips();
    }

    @Operation(summary = "get random tips", description = "get random tips")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tips successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Tips not found")
    })
    @GetMapping("/random")
    public DailyTip getRandomTip() {
        logger.info("Retrieving random tips");
        return dailyTipService.getRandomTip();
    }

    @Operation(summary = "to add a tip", description = "to add a tip")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tips added successfully"),
            @ApiResponse(responseCode = "404", description = "Tips not found")
    })
    @PostMapping
    public DailyTip addTip(@RequestBody DailyTip tip) {
        logger.info("Adding a tip");
        return dailyTipService.addTip(tip);
    }
}
