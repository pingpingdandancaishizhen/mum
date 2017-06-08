package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.CalendarEvent;
import cn.sunfit.risk.buz.api.service.corp.CalendarEventService;
import cn.sunfit.risk.buz.server.dao.corp.CalendarEventDAO;

@Service("risk.calendarEventService")
public class CalendarEventServiceImpl implements CalendarEventService {

    @Autowired
    CalendarEventDAO calendarEventDAO;

    @Override
    public void addCalendarEvent(CalendarEvent calendarEvent) {
        calendarEventDAO.insert(calendarEvent);
    }

    @Override
    public void updateCalendarEvent(CalendarEvent calendarEvent) {
        calendarEventDAO.updateByPrimaryKey(calendarEvent);
    }

    @Override
    public void deleteCalendarEvent(String id) {
        calendarEventDAO.deleteCalendarEvent(id);
    }

    @Override
    public List<CalendarEvent> seleteCalendarEvent(String uid) {
        return calendarEventDAO.seleteCalendarEvent(uid);
    }

}
