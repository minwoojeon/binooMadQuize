-- since 2018.02.26
-- last 2018.02.26

CREATE DATABASE IF NOT EXISTS web_project;
USE web_project;

-- �޴� ���̺� : botbinoo
-- ���� ���� ������ �ϴ� �κ�����, �� ���¸� ���� �ٸ� �����ڰ� �����ο� Ŀ���͸���¡ �ϱ⸦ ���մϴ�.
-- seq, menuCode, menuTitle, menuURL
drop table IF EXISTS TB_MENU;
create table if not exists TB_MENU(
	seq int(10) auto_increment not null,		-- �޴� ����Ű
	menuCode int(10) default 0,					-- �޴� �ڵ� (���� 0x0~0x100 / ���� 0x101~0x200)
	menuTitle varchar(50) not null,				-- �޴� ��
	menuURL varchar(500),						-- �޴� ��ũ
	regtime datetime default now(),				-- �����ð�
	primary key(seq)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- ����� ���̺� : jungwon
-- ����� �α����� ���� ����.
drop table IF EXISTS TB_USERS;

-- ����� ��������(�α���/��α��� ���) ���̺� : botbinoo
-- ����� �����������/��ŷ���ݿ� ���� ������ �����, ��ȣȭ Ű/�ø��� �ѹ��� ���� �ǽð� ��ȣ ������(������)
drop table IF EXISTS TB_USERS_ACCESS;

-- ���� �Խ��� ���̺� : byungjun
-- ����ڰ� ������ ������ ������ �� �ֵ��� ���� ����(�μ�Ʈ), ����(�˻�), ����, ���� ���� �����Ѵ�.
drop table IF EXISTS TB_QUEST_BBS;

-- ���� ���̺� : botbinoo
-- ���� ������� �ø��� Ű�� �����ּҳ� �α��� ������ ���� ����� ���� Ǯ�� ����� �����Ѵ�. �ߺ��� �����ϴ�.
drop table IF EXISTS TB_QUEST_RESULT;

-- ���� ��� ���̺� : byungjun
-- ������ ������ ���Ͽ� ������ �����ο� ��(����ۼ�)�� �̷���� �� �ִ�. �Ϲ� ��� ��ɿ� �� �ϳ� �� Į���� �߰��Ѵ�.
drop table IF EXISTS TB_QUEST_REPLY;

-- ���� ������
-- �׽�Ʈ�� ���� �Ǵ� ���� ������ ������ ���� ��� ��� �꿡 �����մϴ�.
-- �޴� �׽�Ʈ ������
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x00, '������ ���̵�', '/bmq/design/guide');
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x01, '������ ����', '/bmq/design/main');
insert into TB_MENU(menuCode, menuTitle, menuURL) values(0x02, '������ ��', '/bmq/design/contents');

-- ������ Ȯ��
-- �˻����� �ۼ��մϴ�.
select seq, menuCode, menuTitle, menuURL
from TB_MENU;