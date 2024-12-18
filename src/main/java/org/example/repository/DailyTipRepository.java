package org.example.repository;

import org.example.model.DailyTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTipRepository extends JpaRepository<DailyTip, Long> {
}
