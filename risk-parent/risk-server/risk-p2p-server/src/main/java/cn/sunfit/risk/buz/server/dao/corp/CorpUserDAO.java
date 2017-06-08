package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserQuery;
import cn.sunfit.risk.buz.api.vo.corp.SameDeptUserResp;
import cn.sunfit.risk.buz.api.vo.corp.UserQueryReq;

@Repository
public interface CorpUserDAO {
    long countUserByAccount(CorpUserDTO dto);

    int countUserByDeptIdAndStatus(@Param("deptId") String deptId, @Param("status") String[] status);

    void deleteUserDataRole(CorpUserDTO corpUserDTO);

    void deleteUserRole(CorpUserDTO corpUserDTO);

    int insert(CorpUserDTO record);

    void insertCorpUserDataRole(CorpUserDTO corpUserDTO);

    void insertCorpUserRole(CorpUserDTO corpUserDTO);

    CorpUser selectByPrimaryKey(String id);

    CorpUserDTO selectCorpUserByDto(CorpUserDTO dto);

    CorpUserDTO selectCorpUserByIdOrCode(CorpUserDTO corpUserDTO);

    List<String> selectCorpUserDataRoleIds(CorpUserDTO corpUserDTO);

    List<String> selectCorpUserRoleIds(CorpUserDTO corpUserDTO);

    List<SameDeptUserResp> selectUserByBpId(SameDeptUserQuery req);

    List<String> selectUserByDeptId(@Param("deptIds") List<String> deptIds);

    List<CorpUserDTO> selectUserList(UserQueryReq req, RowBounds rowBounds);

    int updateByPrimaryKey(CorpUser record);
    
    List<CorpUserDTO> selectUserListByDeptId(@Param("deptId") String deptId);
}