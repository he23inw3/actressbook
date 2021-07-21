-- Project Name : noname
-- Date/Time    : 2021/07/21 22:41:57
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
  , CREATE_DATE date
  , UPDATE_DATE date
) ;

-- 女優テーブル
--* BackupToTempTable
drop table if exists TBL_ACTRESS cascade;

--* RestoreFromTempTable
create table TBL_ACTRESS (
  ACTRESS_ID bigserial not null
  , NAME character varying not null
  , RUBY character varying not null
  , HEIGHT integer not null
  , BUST integer not null
  , WEST integer not null
  , HIP integer not null
  , IMAGE_URL character varying not null
  , INFO_URL character varying not null
  , BIRTHDAY date not null
  , CREATE_DATE date
  , UPDATE_DATE date
  , constraint TBL_ACTRESS_PKC primary key (ACTRESS_ID)
) ;

create unique index ACTRESS_INDEX1
  on TBL_ACTRESS(NAME);

comment on table TBL_MANAGEMENT is '管理テーブル';
comment on column TBL_MANAGEMENT.MANAGEMENT_ID is '管理ID';
comment on column TBL_MANAGEMENT.MANAGEMET_STATUS is '管理ステータス:1: 通常、2: メンテナンス';
comment on column TBL_MANAGEMENT.CREATED_DATE is '作成日付';
comment on column TBL_MANAGEMENT.UPDATED_DATE is '更新日付';

comment on table TBL_NICE is 'ナイステーブル';
comment on column TBL_NICE.ACTRESS_ID is '女優ID';
comment on column TBL_NICE.USER_ID is '利用者ID';
comment on column TBL_NICE.CREATE_DATE is '作成日付';
comment on column TBL_NICE.UPDATE_DATE is '更新日付';

comment on table TBL_ACTRESS is '女優テーブル';
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
comment on column TBL_ACTRESS.CREATE_DATE is '作成日付';
comment on column TBL_ACTRESS.UPDATE_DATE is '更新日付';
