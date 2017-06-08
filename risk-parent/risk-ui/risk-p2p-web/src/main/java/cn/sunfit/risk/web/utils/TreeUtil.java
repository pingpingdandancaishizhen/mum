package cn.sunfit.risk.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.vo.DTree;
import cn.sunfit.risk.web.dto.TreeDTO;

/**
 * 
 * @Title: TreeUtil.java
 * @Package com.rjs.rjr.util
 * @Description: 组装树的工具类
 * @author yanlei
 * @date 2016年7月16日 上午10:15:19
 * @version V1.0
 */
public class TreeUtil {

    /**
     * 
     * @Title: resetTreeByDeptNo
     * @Description: 根据id查询所有包含本身子节点数据
     * @param @param treeList
     * @param @param id
     * @param @return   
     * @return List<String> 
     * @author yanlei 2016年7月16日 
     * @throws
     */
    public static List<DTree> getAllSubEle(List<DTree> dtreeList, String id) {
        List<DTree> treeList = new ArrayList<DTree>();
        for (DTree dTree : dtreeList) {
            if (dTree.getId().equals(id)) {
                if (!treeList.contains(dTree)) {
                    treeList.add(dTree);
                    treeList = getSubEle(treeList, dtreeList, dTree);
                }
            }
        }
        return treeList;
    }

    /**
     * 
     * @Title: getDTree
     * @Description: 循环遍历组装成需要的树结构
     * @param @param dTreeList
     * @param @param treeDTO
     * @param @return   
     * @return List<DTree> 
     * @author yanlei 2016年7月16日 
     * @throws
     */
    public static List<DTree> getDTree(List<DTree> dTreeList, TreeDTO treeDTO) {
        DTree dTree = new DTree();
        dTree.setId(treeDTO.getId());
        dTree.setParentId(treeDTO.getParentId());
        dTree.setName(treeDTO.getName());
        dTreeList.add(dTree);
        List<TreeDTO> treeDTOList = treeDTO.getChildrenList();
        for (TreeDTO t : treeDTOList) {
            dTreeList = getDTree(dTreeList, t);
        }
        return dTreeList;
    }

    private static List<DTree> getParentEle(List<DTree> treeList, List<DTree> dtreeList, DTree dTree) {
        for (DTree d : dtreeList) {
            if (d.getId().equals(dTree.getParentId())) {
                if (!treeList.contains(d)) {
                    treeList.add(d);
                    treeList = getParentEle(treeList, dtreeList, d);
                }
                break;
            }
        }

        return treeList;
    }

    private static List<DTree> getSubEle(List<DTree> treeList, List<DTree> dtreeList, DTree dTree) {
        for (DTree d : dtreeList) {
            if (d.getParentId().equals(dTree.getId())) {
                if (!treeList.contains(d)) {
                    treeList.add(d);
                    treeList = getSubEle(treeList, dtreeList, d);
                }
            }
        }

        return treeList;
    }

    /**
     * 
     * @Title: resetTreeByDeptNo
     * @Description: 根据名称重新组装返回所有父节点
     * @param @param treeList
     * @param @param deptNo
     * @param @return   
     * @return List<DTree> 
     * @author yanlei 2016年7月16日 
     * @throws
     */
    public static List<DTree> resetTreeByDeptNo(List<DTree> dtreeList, String name) {
        List<DTree> treeList = new ArrayList<DTree>();

        if (StringUtils.isEmpty(name))
            treeList = dtreeList;
        else {
            for (DTree dTree : dtreeList) {
                if (dTree.getName().contains(name)) {
                    if (!treeList.contains(dTree)) {
                        treeList.add(dTree);
                        treeList = getParentEle(treeList, dtreeList, dTree);
                    }
                }
            }
        }
        return treeList;
    }

}
