package com.test.brillo.repository;

import com.test.brillo.bean.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Booking,Long> {
}
