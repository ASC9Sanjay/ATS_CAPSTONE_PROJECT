package com.ats.schedule_microservice.repo;
import com.ats.schedule_microservice.enty.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,String> {

    @Query(value = "SELECT * FROM schedule ORDER BY id DESC LIMIT 1",nativeQuery = true)
    Schedule selectLastEntity();

    @Query(value = "SELECT * FROM schedule WHERE source_airport_id = :source_airport_id AND destination_airport_id = :destination_airport_id ", nativeQuery = true)
    Schedule findBySourceAirportIdAndDestinationAirportId(@Param("source_airport_id") String src , @Param("destination_airport_id") String dest);
}
