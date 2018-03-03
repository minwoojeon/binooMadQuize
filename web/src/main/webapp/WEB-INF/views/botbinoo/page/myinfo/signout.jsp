<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglib/commons.jsp"%>

<%-- 
/**
 * @Class Name : signout.jsp
 * @Description : user sign-out pages
 * @author botbinoo@naver.com
 * @since 2018.03.03
 * @version 1
 * Copyright (C) by botbinoo's All right reserved.
 */ 
 --%>
<!-- sign out -->
<div id="main">
	<div class="inner">

		<h1>Sign-out</h1>
		<span class="image main"> <%-- <img
			src="&lt;c:url value='/resources/img/if_dialog-error_118938.svg'/&gt;"
			alt="not found(오류)"> --%>
		</span>

		<p>저희 사이트를 방문해 주셔서 감사드립니다. 앞으로는 더 좋은 곳이 되기 위하여 정진하겠습니다.</p>
		<p></p>
		<h2>개인정보 처리방침</h2>
		<ul>
			<li>회원 서비스 탈퇴 신청시, 즉시 개인정보 삭제</li>
			<li>* 복구가 불가능하니 신중한 선택 바랍니다.</li>
		</ul>
		<p></p>

		<a href="javascript:$('#pessoninfo').toggle();" class="button fit">
		개인정보 처리 방침/정책확인</a>

		<!-- 회원가입할래요를 누르면 활성화(닫으면 비활성화) -->
		<section id="sign-up">
			<form:form commandName="userVO" name="frm" id="frm" method="post">
				<div class="row uniform">
					<!-- 약관 (접었다폈다 가능/ 필수) -->
					<div class="12u$">
						<div id="pessoninfo" style="display: none;">
						<h2>정책&amp;약관</h2>
							<p>
								1. 개인정보의 처리 목적 <br> (‘BMQ project’이하 ‘BinooFactory’) 은(는)
								다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지 않습니다. - 고객 가입의사
								확인, 고객에 대한 서비스 제공에 따른 본인 식별.인증, 회원자격 유지.관리, 물품 또는 서비스 공급에 따른 금액
								결제, 물품 또는 서비스의 공급.배송 등)
							</p>

							<p>
								2. 개인정보의 처리 및 보유 기간 <br>① (‘BMQ project’이하 ‘BinooFactory’)
								은(는) 정보주체로부터 개인정보를 수집할 때 동의 받은 개인정보 보유․이용기간 또는 법령에 따른 개인정보
								보유․이용기간 내에서 개인정보를 처리․보유합니다. <br>② 구체적인 개인정보 처리 및 보유 기간은 다음과
								같습니다. <br>☞ 아래 예시를 참고하여 개인정보 처리업무와 개인정보 처리업무에 대한 보유기간 및 관련
								법령, 근거 등을 기재합니다.(예시)- 고객 가입 및 관리 : 서비스 이용계약 또는 회원가입 해지시까지, 다만
								채권․채무관계 잔존시에는 해당 채권․채무관계 정산시까지- 전자상거래에서의 계약․청약철회, 대금결제, 재화 등
								공급기록 : 5년 <br>고객 가입 및 관리 : 서비스 이용계약 또는 회원가입 해지신청시 즉시처리.
							</p>

							<p>
								3. 개인정보의 제3자 제공에 관한 사항 <br>① ('BMQ project'이하
								'BinooFactory')은(는) 정보주체의 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조 및 제18조에
								해당하는 경우에만 개인정보를 제3자에게 제공합니다. <br>② ('BMQ project')은(는)
								개인정보를 제3자에게 제공하고 있지 않습니다.
							</p>

							<p>
								4. 개인정보처리 위탁 <br>① ('BinooFactory')은(는) 원활한 개인정보 업무처리를 위하여
								개인정보 처리업무를 위탁하고 있지 않습니다. <br>② ('BMQ project'이하
								'BinooFactory')은(는) 위탁계약 체결시 개인정보 보호법 제25조에 따라 위탁업무 수행목적 외 개인정보
								처리금지, 기술적․관리적 보호조치, 재위탁 제한, 수탁자에 대한 관리․감독, 손해배상 등 책임에 관한 사항을 계약서
								등 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다. <br>③ 위탁업무의
								내용이나 수탁자가 변경될 경우에는 지체없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.
							</p>

							<p>
								5. 정보주체와 법정대리인의 권리·의무 및 그 행사방법 이용자는 개인정보주체로써 다음과 같은 권리를 행사할 수
								있습니다. <br>① 정보주체는 BinooFactory(‘BMQ project’이하
								‘BinooFactory) 에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다. <br>1.
								개인정보 열람요구 2. 오류 등이 있을 경우 정정 요구 3. 삭제요구 4. 처리정지 요구
							</p>

							<p>
								6. 처리하는 개인정보의 항목 작성 <br>① ('BMQ project'이하
								'BinooFactory')은(는) 다음의 개인정보 항목을 처리하고 있습니다. <br>1
								<!--[CDATA[<웹어플 사용에 있어 활용하는 데이터-->
								]]&gt; - 필수항목 : 이메일, 닉네임, 접속로그(세션) - 선택항목 : 전화번호.
							</p>

							<p>
								7. 개인정보의 파기('BinooFactory')은(는) 원칙적으로 개인정보 처리목적이 달성된 경우에는 지체없이
								해당 개인정보를 파기합니다. 파기의 절차, 기한 및 방법은 다음과 같습니다. <br>-파기절차이용자가
								입력한 정보는 목적 달성 후 별도의 DB에 옮겨져(종이의 경우 별도의 서류) 내부 방침 및 기타 관련 법령에 따라
								일정기간 저장된 후 혹은 즉시 파기됩니다. 이 때, DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 다른
								목적으로 이용되지 않습니다. <br>-파기기한이용자의 개인정보는 개인정보의 보유기간이 경과된 경우에는
								보유기간의 종료일로부터 5일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그
								개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일 이내에 그 개인정보를
								파기합니다.
							</p>

							<p>
								8. 개인정보 자동 수집 장치의 설치•운영 및 거부에 관한 사항 <br>BinooFactory 은
								정보주체의 이용정보를 저장하고 수시로 불러오는 ‘쿠키’를 사용하지 않습니다.
							</p>

							<p>
								9. 개인정보 보호책임자 작성 <br>① BinooFactory(‘BMQ project’이하
								‘BinooFactory) 은(는) 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한
								정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다. <br>
								<br>▶ 개인정보 보호책임자 <br>성명 :전민우 <br>직책 :개인 <br>직급
								:개인 <br>연락처 :01077564321, botbinoo@naver.com, <br>※
								개인정보 보호 담당부서로 연결됩니다. <br> <br>② 정보주체께서는
								BinooFactory(‘BMQ project’이하 ‘BinooFactory) 의 서비스(또는 사업)을 이용하시면서
								발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로
								문의하실 수 있습니다. BinooFactory(‘BMQ project’이하 ‘BinooFactory) 은(는)
								정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.
							</p>

							<p>
								10. 개인정보 처리방침 변경 <br>①이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른
								변경내용의 추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.
							</p>

							<p>
								11. 개인정보의 안전성 확보 조치 ('BinooFactory')은(는) 개인정보보호법 제29조에 따라 다음과 같이
								안전성 확보에 필요한 기술적/관리적 및 물리적 조치를 하고 있습니다. <br>1. 정기적인 자체 감사 실시
								개인정보 취급 관련 안정성 확보를 위해 정기적(분기 1회)으로 자체 감사를 실시하고 있습니다. <br>2.
								내부관리계획의 수립 및 시행 개인정보의 안전한 처리를 위하여 내부관리계획을 수립하고 시행하고 있습니다. <br>3.
								비인가자에 대한 출입 통제 개인정보를 보관하고 있는 물리적 보관 장소를 별도로 두고 이에 대해 출입통제 절차를
								수립, 운영하고 있습니다.
							</p>
						</div>
					</div>
					<div class="12u$">
						<h2>개인 정보 재 확인</h2>
					</div>

					<!-- 이메일 아이디 (중복확인/ 필수) -->
					<div class="12u$ row uniform">
						<div class="6u 12u$(xsmall)">
							<input type="text" name="userid" id="userid" value=""
								placeholder="Email@email.net">
						</div>
						<div class="6u 12u$(xsmall)">아이디를 입력해주세요.</div>
					</div>

					<div class="12u$ row uniform">
						<div class="6u 12u$(xsmall)">
							<input type="text" name="userpw" id="userpw" value="" placeholder="password">
						</div>
						<div class="6u 12u$(xsmall)">비밀번호를 입력해주세요.</div>
					</div>
					
					<h2>탈퇴 사유</h2>
					<div class="12u$ row uniform">
						<div class="6u 12u$(xsmall)">
							<div class="select-wrapper">
								<select name="areacode" id="areacode">
									<option value="">- 탈퇴 사유 -</option>
									<option value="1">재가입</option>
									<option value="2">서비스에 만족하지 못해서</option>
									<option value="3">운영에 만족하지 못해서</option>
									<option value="4">더 이상 서비스를 활용할 이유가 없으므로</option>
									<option value="5">기타</option>
								</select>
							</div>
						</div>

						<div class="6u 12u$(xsmall)">(선택) 회원 탈퇴 사유를 작성해주시면, 적극 반영할 수 있도록 하겠습니다.</div>
					</div>
					<div class="12u$ row uniform">
						<div class="6u 12u$(xsmall)">
						<input type="text" name="reason" id="reason" value=""
								placeholder="(선택) 탈퇴하게된 간단한 이유(reason)">
						</div>
						
					</div>
					
					<div class="12u$">
						<a href="javascript:validation.chk();" class="button special fit">탈퇴하기</a>
					</div>
				</div>
			</form:form>
		</section>
	</div>
</div>

<script>
// validation 체크
var validation = {
		chk:function(){
			// 입력값체크
			validation.out();
		}, out:function(){
			$.ajax({
	            url:'/bmq/user/confirm/sign-out/{key}',
	            type:'post',
	            data:$('frm').serialize(),
	            success:function(data){
	            	if(data[0]=="s"){
	            		alert("회원탈퇴에 성공하였습니다.");
	            		document.location.replace("/bmq");
	            	} else {
	            		alert("정보를 다시한번 확인해주세요.");
	            	}
	            },
	            error:function(e){
	            }
	        });
		}
};
</script>