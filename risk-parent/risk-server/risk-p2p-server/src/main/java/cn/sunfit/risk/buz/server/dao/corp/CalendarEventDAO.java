package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CalendarEvent;

@Repository
public interface CalendarEventDAO {

    void insert(CalendarEvent record);

    CalendarEvent selectByPrimaryKey(String id);

    int updateByPrimaryKey(CalendarEvent calendarEvent);

    void deleteCalendarEvent(@Param("id") String id);

    List<CalendarEvent> seleteCalendarEvent(String uid);

}
