package cn.sunfit.risk.buz.api.beans.p2p.order;

import orj.worf.core.model.BaseObject;
/**
 * 附件表
 * create by kevin han at 20170328
 * @author kevin
 *
 */
public class LoanInfoAttachment extends BaseObject{
	
	private static final long serialVersionUID = 13453453L;
	private Long id;
	private String loanInfoId;
	private String attachOldName;
	private String attachNewName;
	private String attachType;
	private String attachPath;
	private String attachSize;
	private String createTime;
	private String createUser;
	private String attachGroup;
	private String fullPath;
	
	public String getAttachGroup() {
		return attachGroup;
	}
	public void setAttachGroup(String attachGroup) {
		this.attachGroup = attachGroup;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoanInfoId() {
		return loanInfoId;
	}
	public void setLoanInfoId(String loanInfoId) {
		this.loanInfoId = loanInfoId;
	}
	public String getAttachOldName() {
		return attachOldName;
	}
	public void setAttachOldName(String attachOldName) {
		this.attachOldName = attachOldName;
	}
	public String getAttachNewName() {
		return attachNewName;
	}
	public void setAttachNewName(String attachNewName) {
		this.attachNewName = attachNewName;
	}
	public String getAttachType() {
		return attachType;
	}
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	public String getAttachSize() {
		return attachSize;
	}
	public void setAttachSize(String attachSize) {
		this.attachSize = attachSize;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
}
