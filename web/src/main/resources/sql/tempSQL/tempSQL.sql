-- since 2018.02.26
-- last 2018.02.26

CREATE DATABASE IF NOT EXISTS web_project;
USE web_project;

-- 메뉴 테이블 : botbinoo
-- 가장 먼저 만들어야 하는 부분이자, 이 형태를 보고 다른 개발자가 자유로운 커스터마이징 하기를 원합니다.
-- seq, menuCode, menuTitle, menuURL
drop table IF EXISTS TB_MENU;
create table if not exists TB_MENU(
	seq int(10) auto_increment not null,		-- 메뉴 고유키
	menuCode int(10) default 0,					-- 메뉴 코드 (국문 0x0~0x100 / 영문 0x101~0x200)
	menuTitle varchar(50) not null,				-- 메뉴 명
	menuURL varchar(500),						-- 메뉴 링크
	regtime datetime default now(),				-- 생성시간
	primary key(seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 사용자 테이블 : jungwon
-- 사용자 로그인을 위해 개발.
drop table IF EXISTS TB_USERS;

-- 사용자 접근정보(로그인/비로그인 모두) 테이블 : botbinoo
-- 사용자 디비접근정보/해킹공격에 대한 내역을 남기고, 암호화 키/시리얼 넘버를 통해 실시간 암호 재조합(구상중)
drop table IF EXISTS TB_USERS_ACCESS;

-- 문제 게시판 테이블 : byungjun
-- 사용자가 누구나 문제를 출제할 수 있도록 문제 제시(인서트), 출제(검색), 수정, 삭제 등을 제공한다.
drop table IF EXISTS TB_QUEST_BBS;

-- 성적 테이블 : botbinoo
-- 개별 사용자의 시리얼 키와 접근주소나 로그인 정보를 통해 저장된 문제 풀이 결과를 저장한다. 중복이 가능하다.
drop table IF EXISTS TB_QUEST_RESULT;

-- 문제 댓글 테이블 : byungjun
-- 생성된 문제에 대하여 누구나 자유로운 평가(댓글작성)가 이루어질 수 있다. 일반 댓글 기능에 단 하나 평가 칼럼을 추가한다.
drop table IF EXISTS TB_QUEST_REPLY;

-- 임의 데이터
-- 테스트를 위해 또는 실제 데이터 공유를 위해 몇개씩 적어서 깃에 공유합니다.
-- 메뉴 테스트 데이터
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x00, '디자인 가이드', '/bmq/design/guide');
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x01, '디자인 메인', '/bmq/design/main');
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x02, '디자인 상세', '/bmq/design/contents');

-- 데이터 확인
-- 검색문을 작성합니다.
select seq, menuCode, menuTitle, menuURL
from TB_MENU;