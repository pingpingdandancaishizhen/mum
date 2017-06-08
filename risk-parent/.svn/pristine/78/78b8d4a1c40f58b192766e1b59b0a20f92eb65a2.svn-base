package cn.sunfit.risk.buz.server.service.p2p.activiti;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @Title: SpecialTaskService.java
 * @Package cn.sunfit.risk.buz.server.service.solution
 * @Description: 自由跳转流程的处理类
 * @author XFL
 * @date 2017年2月4日 下午5:34:49
 * @version V1.0
 */
@Service("specialTaskService")
public class SpecialTaskService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;

    private Object clone(final Object value) throws IOException, ClassNotFoundException {
        // 字节数组输出流，暂存到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(value);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        // 反序列化
        return ois.readObject();
    }

    /** 
     * 通过指定目标节点，实现任务的跳转 
     * @param taskId 任务ID 
     * @param destNodeIds 跳至的目标节点ID 
     * @param vars 流程变量 
     */
    public void completeTask(String taskId, String[] destNodeIds) {
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();

        String curNodeId = task.getTaskDefinitionKey();
        String actDefId = task.getProcessDefinitionId();

        Map<String, Object> activityMap = prepare(actDefId, curNodeId, destNodeIds);
        try {
            taskService.complete(taskId);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            // 恢复
            restore(activityMap);
        }
    }

    /** 
     * 将节点之后的节点删除然后指向新的节点。  
     * @param actDefId   流程定义ID 
     * @param nodeId   流程节点ID 
     * @param aryDestination 需要跳转的节点 
     * @return Map<String,Object> 返回节点和需要恢复节点的集合。 
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    private Map<String, Object> prepare(String actDefId, String nodeId, String[] aryDestination) {
        Map<String, Object> map = new HashMap<String, Object>();

        // 修改流程定义
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(actDefId);

        ActivityImpl curAct = processDefinition.findActivity(nodeId);
        List<PvmTransition> outTrans = curAct.getOutgoingTransitions();
        try {
            List<PvmTransition> cloneOutTrans = (List<PvmTransition>) clone(outTrans);
            map.put("outTrans", cloneOutTrans);
        } catch (Exception ex) {

        }

        /** 
         * 解决通过选择自由跳转指向同步节点导致的流程终止的问题。 
         * 在目标节点中删除指向自己的流转。 
         */
        // for (Iterator<PvmTransition> it = outTrans.iterator(); it.hasNext();) {
        // PvmTransition transition = it.next();
        // PvmActivity activity = transition.getDestination();
        //
        // List<PvmTransition> inTrans = activity.getIncomingTransitions();
        // try {
        // map.put("Income_" + activity.getId(), clone(inTrans));
        // } catch (Exception ex) {
        //
        // }
        // for (Iterator<PvmTransition> itIn = inTrans.iterator(); itIn.hasNext();) {
        // PvmTransition inTransition = itIn.next();
        // if (inTransition.getSource().getId().equals(curAct.getId())) {
        // itIn.remove();
        // }
        // }
        //
        // }

        curAct.getOutgoingTransitions().clear();

        if (aryDestination != null && aryDestination.length > 0) {
            for (String dest : aryDestination) {
                // 创建一个连接
                ActivityImpl destAct = processDefinition.findActivity(dest);
                TransitionImpl transitionImpl = curAct.createOutgoingTransition();
                transitionImpl.setDestination(destAct);
            }
        }

        map.put("activity", curAct);

        return map;

    }

    /** 
     * 将临时节点清除掉，加回原来的节点。 
     * @param map  
     * void 
     */
    @SuppressWarnings("unchecked")
    private void restore(Map<String, Object> map) {
        ActivityImpl curAct = (ActivityImpl) map.get("activity");
        List<PvmTransition> outTrans = (List<PvmTransition>) map.get("outTrans");
        curAct.getOutgoingTransitions().clear();
        curAct.getOutgoingTransitions().addAll(outTrans);
        // for (Iterator<PvmTransition> it = outTrans.iterator(); it.hasNext();) {
        // // 回复删除的INCOMING
        // PvmTransition transition = it.next();
        // PvmActivity activity = transition.getDestination();
        // List<PvmTransition> incomes = (List<PvmTransition>) map.get("Income_" + activity.getId());
        // activity.getIncomingTransitions().clear();
        // activity.getIncomingTransitions().addAll(incomes);
        // }
    }
}
