package co.binoofactory.bmq.botbinoo.vo;

import co.binoofactory.bmq.commons.CommonVO;

/**
 * @Class Name : MenuVO
 * @Description : Menu-bar Values Object.
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

public class MenuVO extends CommonVO{
	
	private static final long serialVersionUID = -3525289148482267063L;
	
	/* In menu elements */
	private Integer seq;							/* seq. */
	private String menuTitle;						/* title. */
	private Integer menuCode;						/* code. */
	private Integer menuHits;						/* hits. */
	private String menuURL;							/* Newer. */
	
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public Integer getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(Integer menuCode) {
		this.menuCode = menuCode;
	}
	public Integer getMenuHits() {
		return menuHits;
	}
	public void setMenuHits(Integer menuHits) {
		this.menuHits = menuHits;
	}
	public String getMenuURL() {
		return menuURL;
	}
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
