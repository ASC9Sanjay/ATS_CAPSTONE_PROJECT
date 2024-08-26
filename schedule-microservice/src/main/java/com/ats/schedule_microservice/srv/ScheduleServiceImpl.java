package com.ats.schedule_microservice.srv;

import com.ats.schedule_microservice.enty.Schedule;
import com.ats.schedule_microservice.mdl.ScheduleDTO;
import com.ats.schedule_microservice.repo.ScheduleRepo;
import com.ats.schedule_microservice.utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepo scheduleRepo;

    public ScheduleServiceImpl(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDetailsFromUser) {

        Schedule schedule = Schedule.getInstance();
        schedule.setPlaneId(scheduleDetailsFromUser.getPlaneId());
        schedule.setDepartureTime(scheduleDetailsFromUser.getDepartureTime());
        schedule.setArrivalTime(scheduleDetailsFromUser.getArrivalTime());
        schedule.setSourceAirportId(scheduleDetailsFromUser.getSourceAirportId());
        schedule.setDestinationAirportId(scheduleDetailsFromUser.getDestinationAirportId());
        Schedule response = scheduleRepo.save(schedule);
        scheduleDetailsFromUser.setScheduleId(response.getScheduleId());
        return scheduleDetailsFromUser;
    }

    @Override
    public ScheduleDTO getScheduleById(String scheduleById) {
        Schedule scheduleDataFromDB = scheduleRepo.findById(scheduleById).get();
        return convertEntityToDTO(scheduleDataFromDB);
    }

    @Override
    public List<ScheduleDTO> displayAllSchedule() {
        List<Schedule> scheduleDataFromDB = scheduleRepo.findAll();
        return scheduleDataFromDB.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO udpateSchedule(ScheduleDTO updatedScheduleDetailsFromUser) {
        Schedule scheduleDataFromDB = scheduleRepo.findById(updatedScheduleDetailsFromUser.getScheduleId()).get();
        scheduleDataFromDB.setArrivalTime(updatedScheduleDetailsFromUser.getArrivalTime());
        scheduleDataFromDB.setDepartureTime(updatedScheduleDetailsFromUser.getDepartureTime());
        Schedule schedule = scheduleRepo.save(scheduleDataFromDB);
        updatedScheduleDetailsFromUser.setScheduleId(schedule.getScheduleId());
        return updatedScheduleDetailsFromUser;
    }

    @Override
    public ScheduleDTO deleteSchedule(String scheduleId) {
        Schedule schedule = scheduleRepo.findById(scheduleId).get();
        scheduleRepo.delete(schedule);
        return convertEntityToDTO(schedule);
    }

    public ScheduleDTO getScheduleBySrcDestDate(String source , String destination){
        Schedule schedule = scheduleRepo.findBySourceAirportIdAndDestinationAirportId(source,destination);
        return convertEntityToDTO(schedule);
    }

    public ScheduleDTO selectLastEntityFromDB(){
        return convertEntityToDTO(scheduleRepo.selectLastEntity());
    }

    private ScheduleDTO convertEntityToDTO(Schedule scheduleDetailsFromDB){
        ScheduleDTO scheduleDTO = ScheduleDTO.getInstance();
        scheduleDTO.setScheduleId(scheduleDetailsFromDB.getScheduleId());
        scheduleDTO.setPlaneId(scheduleDetailsFromDB.getPlaneId());
        scheduleDTO.setArrivalTime(scheduleDetailsFromDB.getArrivalTime());
        scheduleDTO.setDepartureTime(scheduleDetailsFromDB.getDepartureTime());
        scheduleDTO.setSourceAirportId(scheduleDetailsFromDB.getSourceAirportId());
        scheduleDTO.setDestinationAirportId(scheduleDetailsFromDB.getDestinationAirportId());
        return scheduleDTO;
    }



}
