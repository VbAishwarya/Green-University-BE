package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.DailyTip;
import org.example.repository.DailyTipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTipService {

    private static final Logger logger = LoggerFactory.getLogger(DailyTipService.class);

    @Autowired
    private DailyTipRepository dailyTipRepository;

    // Get all tips
    public List<DailyTip> getAllTips() {
        logger.info("retrieving all the tips from the database");
        return dailyTipRepository.findAll();
    }

    // Get a random tip
    public DailyTip getRandomTip() {
        logger.info("retrieving a tip from the database");
        List<DailyTip> tips = dailyTipRepository.findAll();
        if (!tips.isEmpty()) {
            return tips.get((int) (Math.random() * tips.size()));
        }
        logger.info("No tip found");
        throw new ResourceNotFoundException("No tip found");
    }

    // Add a new tip
    public DailyTip addTip(DailyTip tip) {
        logger.info("Adding a new tip");
        return dailyTipRepository.save(tip);
    }

}
