select 'CREATE SEQUENCE ' || REPLACE(TABLE_NAME,'TB_','SEQ_') || ' INCREMENT BY 1 START WITH 1;' SEQ from SYS.USER_TABLES where Table_Name like 'TB_%';

