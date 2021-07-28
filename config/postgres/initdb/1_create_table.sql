-- Project Name : noname
-- Date/Time    : 2021/07/28 22:02:15
-- Author       : ma7k5
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- 管理テーブル
--* BackupToTempTable
drop table if exists TBL_MANAGEMENT cascade;

--* RestoreFromTempTable
create table TBL_MANAGEMENT (
  MANAGEMENT_ID serial not null
  , AGENT_ID varchar not null
  , MANAGEMET_STATUS character default 1 not null
  , CREATED_DATE date
  , UPDATED_DATE date
  , constraint TBL_MANAGEMENT_PKC primary key (MANAGEMENT_ID)
) ;

-- ナイステーブル
--* BackupToTempTable
drop table if exists TBL_NICE cascade;

--* RestoreFromTempTable
create table TBL_NICE (
  ACTRESS_ID integer not null
  , USER_ID integer not null
  , POINT integer not null
  , CREATED_DATE date
  , UPDATED_DATE date
) ;

-- ナイステーブルWK
--* BackupToTempTable
drop table if exists TBL_NICE_WK cascade;

--* RestoreFromTempTable
create table TBL_NICE_WK (
  ACTRESS_ID integer not null
  , USER_ID integer not null
  , POINT integer not null
  , CREATED_DATE date
  , UPDATED_DATE date
) ;

-- 利用者テーブル
--* BackupToTempTable
drop table if exists TBL_USER cascade;

--* RestoreFromTempTable
create table TBL_USER (
  USER_ID serial not null
  , NAME varchar not null
  , MAIL_ADDRESS varchar
  , PASSWORD varchar not null
  , ACTRESS_ID varchar not null
  , DELETE_FLG char default 0 not null
  , CREATED_DATE date default CURRENT_DATE
  , UPDATED_DATE date default CURRENT_DATE
  , constraint TBL_USER_PKC primary key (USER_ID)
) ;

-- 女優テーブル
--* BackupToTempTable
drop table if exists TBL_ACTRESS cascade;

--* RestoreFromTempTable
create table TBL_ACTRESS (
  ACTRESS_ID serial not null
  , NAME character varying not null
  , RUBY character varying not null
  , HEIGHT integer not null
  , BUST integer not null
  , WEST integer not null
  , HIP integer not null
  , IMAGE_URL character varying not null
  , INFO_URL character varying not null
  , BIRTHDAY date not null
  , CREATED_DATE date
  , UPDATED_DATE date
  , constraint TBL_ACTRESS_PKC primary key (ACTRESS_ID)
) ;

create unique index ACTRESS_INDEX1
  on TBL_ACTRESS(NAME);

-- エージェントテーブル
--* BackupToTempTable
drop table if exists TBL_AGENT cascade;

--* RestoreFromTempTable
create table TBL_AGENT (
  AGENT_ID varchar not null
  , AGENT_NAME varchar not null
  , ROLE char default 1 not null
  , CREATED_DATE date not null
  , UPDATED_DATE date
  , constraint TBL_AGENT_PKC primary key (AGENT_ID)
) ;

create unique index TBL_AGENT_IX1
  on TBL_AGENT(AGENT_NAME);

comment on table TBL_MANAGEMENT is '管理テーブル:アプリ管理情報を格納';
comment on column TBL_MANAGEMENT.MANAGEMENT_ID is '管理ID';
comment on column TBL_MANAGEMENT.AGENT_ID is 'エージェントID';
comment on column TBL_MANAGEMENT.MANAGEMET_STATUS is '管理ステータス:1: 通常、2: メンテナンス';
comment on column TBL_MANAGEMENT.CREATED_DATE is '作成日付';
comment on column TBL_MANAGEMENT.UPDATED_DATE is '更新日付';

comment on table TBL_NICE is 'ナイステーブル:前日までのナイスを格納';
comment on column TBL_NICE.ACTRESS_ID is '女優ID';
comment on column TBL_NICE.USER_ID is '利用者ID';
comment on column TBL_NICE.POINT is 'ポイント';
comment on column TBL_NICE.CREATED_DATE is '作成日付';
comment on column TBL_NICE.UPDATED_DATE is '更新日付';

comment on table TBL_NICE_WK is 'ナイステーブルWK:当日までのナイスを格納';
comment on column TBL_NICE_WK.ACTRESS_ID is '女優ID';
comment on column TBL_NICE_WK.USER_ID is '利用者ID';
comment on column TBL_NICE_WK.POINT is 'ポイント';
comment on column TBL_NICE_WK.CREATED_DATE is '作成日付';
comment on column TBL_NICE_WK.UPDATED_DATE is '更新日付';

comment on table TBL_USER is '利用者テーブル:利用者情報を格納';
comment on column TBL_USER.USER_ID is '利用者ID:利用者ID';
comment on column TBL_USER.NAME is '利用者名:利用者名';
comment on column TBL_USER.MAIL_ADDRESS is 'メールアドレス:メールアドレス';
comment on column TBL_USER.PASSWORD is 'パスワード:パスワード';
comment on column TBL_USER.ACTRESS_ID is '女優ID:好きな女優のID';
comment on column TBL_USER.DELETE_FLG is '削除フラグ:削除フラグ 1: TRUE 0: FALSE';
comment on column TBL_USER.CREATED_DATE is '作成日付:作成日付';
comment on column TBL_USER.UPDATED_DATE is '更新日付:更新日付';

comment on table TBL_ACTRESS is '女優テーブル:女優情報を格納';
comment on column TBL_ACTRESS.ACTRESS_ID is '女優ID';
comment on column TBL_ACTRESS.NAME is '女優名';
comment on column TBL_ACTRESS.RUBY is '女優名（読み仮名）';
comment on column TBL_ACTRESS.HEIGHT is '身長';
comment on column TBL_ACTRESS.BUST is 'バスト';
comment on column TBL_ACTRESS.WEST is 'ウェスト';
comment on column TBL_ACTRESS.HIP is 'ヒップ';
comment on column TBL_ACTRESS.IMAGE_URL is 'イメージ画像URL';
comment on column TBL_ACTRESS.INFO_URL is '詳細情報URL';
comment on column TBL_ACTRESS.BIRTHDAY is '生年月日';
comment on column TBL_ACTRESS.CREATED_DATE is '作成日付';
comment on column TBL_ACTRESS.UPDATED_DATE is '更新日付';

comment on table TBL_AGENT is 'エージェントテーブル:アプリ管理者情報を格納';
comment on column TBL_AGENT.AGENT_ID is 'エージェントID:エージェントID';
comment on column TBL_AGENT.AGENT_NAME is 'エージェント名:エージェント名';
comment on column TBL_AGENT.ROLE is '役割:1:  一般、2: 管理者';
comment on column TBL_AGENT.CREATED_DATE is '作成日付:作成日付';
comment on column TBL_AGENT.UPDATED_DATE is '更新日付:更新日付';
