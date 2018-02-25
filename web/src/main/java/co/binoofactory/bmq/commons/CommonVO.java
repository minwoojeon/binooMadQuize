package co.binoofactory.bmq.commons;

import java.io.Serializable;

/**
 * @Class Name : CommonVO
 * @Description : Common Values Object.
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

public class CommonVO extends Object implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/* Using DB search, in common elements */
	private String searchKeyword;						/* keyword. */
	private Integer searchKeycode;						/* keycode. */
	private String searchType;							/* type. */
	
	/* Page elements */
	private Integer currentPage = 1;					/* currentPage. */
	private Integer oncePagesView = 10;					/* How many items to get list of once: default 10 */
	private Integer maxPages = 0;						/* maxPages. */

	/* Processing DB, every client check this data */
	private String sessionKey;							/* encrypt mode. */
	private String sessionMacIp;						/* access ip. */
	private String sessionTime;							/* access time. */
	private String sessionWhatToWant;					/* why they access db. */
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public Integer getSearchKeycode() {
		return searchKeycode;
	}
	public void setSearchKeycode(Integer searchKeycode) {
		this.searchKeycode = searchKeycode;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getSessionMacIp() {
		return sessionMacIp;
	}
	public void setSessionMacIp(String sessionMacIp) {
		this.sessionMacIp = sessionMacIp;
	}
	public String getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}
	public String getSessionWhatToWant() {
		return sessionWhatToWant;
	}
	public void setSessionWhatToWant(String sessionWhatToWant) {
		this.sessionWhatToWant = sessionWhatToWant;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getOncePagesView() {
		return oncePagesView;
	}
	public void setOncePagesView(Integer oncePagesView) {
		this.oncePagesView = oncePagesView;
	}
	public Integer getMaxPages() {
		return maxPages;
	}
	public void setMaxPages(Integer maxPages) {
		this.maxPages = maxPages;
	}
}
