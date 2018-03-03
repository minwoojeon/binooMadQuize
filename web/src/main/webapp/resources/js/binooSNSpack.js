/**
 * @JS Name : binooSNSpack
 * @Description : binooFacktory sns tools
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */

var snspack = {
		winWidth:300, winHeight:600,
		facebook : function(){
			// facebook
			window.open(
					'https://www.facebook.com/sharer/sharer.php?u=' +
					encodeURIComponent(document.URL)+
					'&t='+encodeURIComponent(document.title), 
					'facebooksharedialog', 
					'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height='
					+snspack.winWidth+',width='+snspack.winHeight
					);
		}, googleplus : function(){
			// googleplus
			window.open('https://plus.google.com/share?url=' +
					encodeURIComponent(document.URL), 
					'googleplussharedialog',
					'menubar=no,toolbar=no,resizable=yes, scrollbars=yes,height='+snspack.winWidth+',width='+snspack.winHeight
					);
		}, tweeter : function(){
			// tweeter
			window.open(
					'https://twitter.com/intent/tweet?text=[%EA%B3%B5%EC%9C%A0]%20' +
					encodeURIComponent(document.URL)+
					'%20-%20'+encodeURIComponent(document.title), 
					'twittersharedialog', 
					'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height='+
					snspack.winWidth+',width='+snspack.winHeight
					);
		}, kakaostory : function(){
			// kakaostory
			window.open('https://story.kakao.com/s/share?url=' +
					encodeURIComponent(document.URL), 
					'kakaostorysharedialog', 
					'menubar=no,toolbar=no,resizable=yes,scrollbars=yes, height='+
					snspack.winWidth+',width='+snspack.winHeight);
		}, naverblog : function(){
			// naverblog
			window.open('http://share.naver.com/web/shareView.nhn?url=' +
					encodeURIComponent(document.URL)+'&title='+
					encodeURIComponent(document.title), 
					'naversharedialog', 
					'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height='+
					snspack.winWidth+',width='+snspack.winHeight);
		}, waybo : function(){
			// waybo
			// 웨이보 전송 부분 알게되면 알려주세요 ㅠㅠ 중국어가 어려워서
		}, line : function(){
			// line
			window.open('http://line.me/R/msg/text/?[%EA%B3%B5%EC%9C%A0]%20' +
					encodeURIComponent(document.URL)+'%20-%20'+
					encodeURIComponent(document.title), 
					'linesharedialog', 
					'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height='+
					snspack.winWidth+',width='+snspack.winHeight);
		}
};