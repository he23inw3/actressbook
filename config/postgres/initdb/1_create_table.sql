-- Project Name : noname
-- Date/Time    : 2021/08/04 22:56:57
-- Author       : ma7k5
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- お気に入りテーブル
--* BackupToTempTable
drop table if exists TBL_FAVORITE cascade;

--* RestoreFromTempTable
create table TBL_FAVORITE (
  USER_ID varchar not null
  , ACTRESS_ID integer not null
  , CREATED_DATE date
  , constraint TBL_FAVORITE_PKC primary key (USER_ID,ACTRESS_ID)
) ;

-- ナイステーブル
--* BackupToTempTable
drop table if exists TBL_NICE cascade;

--* RestoreFromTempTable
create table TBL_NICE (
  ACTRESS_ID integer not null
  , USER_ID varchar not null
  , AVAILABLE_FLAG char default 1 not null
  , CREATED_DATE date
  , UPDATED_DATE date
  , constraint TBL_NICE_PKC primary key (ACTRESS_ID,USER_ID)
) ;

-- 利用者テーブル
--* BackupToTempTable
drop table if exists TBL_USER cascade;

--* RestoreFromTempTable
create table TBL_USER (
  USER_ID varchar not null
  , NAME varchar not null
  , MAIL_ADDRESS varchar
  , PASSWORD varchar not null
  , ROLE char default 1 not null
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

comment on table TBL_FAVORITE is 'お気に入りテーブル';
comment on column TBL_FAVORITE.USER_ID is '利用者ID';
comment on column TBL_FAVORITE.ACTRESS_ID is '女優ID';
comment on column TBL_FAVORITE.CREATED_DATE is '作成日付';

comment on table TBL_NICE is 'ナイステーブル:前日までのナイスを格納';
comment on column TBL_NICE.ACTRESS_ID is '女優ID';
comment on column TBL_NICE.USER_ID is '利用者ID';
comment on column TBL_NICE.AVAILABLE_FLAG is '有効フラグ:1: 有効 0: 無効';
comment on column TBL_NICE.CREATED_DATE is '作成日付';
comment on column TBL_NICE.UPDATED_DATE is '更新日付';

comment on table TBL_USER is '利用者テーブル:利用者情報を格納';
comment on column TBL_USER.USER_ID is '利用者ID:利用者ID';
comment on column TBL_USER.NAME is '利用者名:利用者名';
comment on column TBL_USER.MAIL_ADDRESS is 'メールアドレス:メールアドレス';
comment on column TBL_USER.PASSWORD is 'パスワード:パスワード';
comment on column TBL_USER.ROLE is '役割:1: 一般 2: 管理者';
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
