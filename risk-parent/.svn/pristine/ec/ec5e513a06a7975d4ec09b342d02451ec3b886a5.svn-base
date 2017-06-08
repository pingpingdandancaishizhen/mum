package cn.sunfit.risk.web.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CalendarEvent;
import cn.sunfit.risk.buz.api.service.corp.CalendarEventService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/calEvent")
public class CalendarEventController extends BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(CalendarEventController.class);

    @Autowired
    private CalendarEventService calendarEventService;

    /**
     * 
     * @Title: queryAllCalEvent
     * @Description: 查询所有事件
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月22日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllCalEvent", method = RequestMethod.GET)
    public Resp queryAllCalEvent() {
        List<CalendarEvent> list = calendarEventService.seleteCalendarEvent(getCurrentUser().getId());
        return new Resp(list);
    }

    /**
     * 新增事件
     * @Title: addCalEvent
     * @Description: TODO
     * @param @param calendarEvent
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月23日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/addCalEvent", method = RequestMethod.POST)
    public Resp addCalEvent(CalendarEvent calendarEvent) {
        calendarEvent.setUid(getCurrentUser().getId());
        calendarEventService.addCalendarEvent(calendarEvent);
        return new Resp();
    }

    /**
     * 更新事件
     * @Title: updateCalEvent
     * @Description: TODO
     * @param @param calendarEvent
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月23日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/updateCalEvent", method = RequestMethod.POST)
    public Resp updateCalEvent(CalendarEvent calendarEvent) {
        calendarEvent.setUid(getCurrentUser().getId());
        calendarEventService.updateCalendarEvent(calendarEvent);
        return new Resp();
    }

    /**
     * 删除事件
     * @Title: deleteCalEvent
     * @Description: TODO
     * @param @param calendarEvent
     * @param @return   
     * @return Resp 
     * @author XJ 2016年12月23日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCalEvent", method = RequestMethod.POST)
    public Resp deleteCalEvent(String id) {
        calendarEventService.deleteCalendarEvent(id);
        return new Resp();
    }

}
