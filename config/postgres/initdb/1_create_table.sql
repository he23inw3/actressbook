-- Project Name : noname
-- Date/Time    : 2022/04/02 14:28:32
-- Author       : ma7k5
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
*/

-- 女優_SNSテーブル
--* BackupToTempTable
drop table if exists TBL_ACTRESS_SNS cascade;

--* RestoreFromTempTable
create table TBL_ACTRESS_SNS (
  ACTRESS_ID character varying not null
  , TWITTER_URL character varying
  , INSTAGRAM_URL character varying
  , CREATED_DATE date not null
  , UPDATED_DATE date
  , constraint TBL_ACTRESS_SNS_PKC primary key (ACTRESS_ID)
) ;

-- システム属性テーブル
--* BackupToTempTable
drop table if exists TBL_GENERIC_ATTR cascade;

--* RestoreFromTempTable
create table TBL_GENERIC_ATTR (
  KEY character varying
  , VALUE character varying
) ;

-- 女優テーブル
--* BackupToTempTable
drop table if exists TBL_ACTRESS cascade;

--* RestoreFromTempTable
create table TBL_ACTRESS (
  ACTRESS_ID character varying not null
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

comment on table TBL_ACTRESS_SNS is '女優_SNSテーブル';
comment on column TBL_ACTRESS_SNS.ACTRESS_ID is '女優ID';
comment on column TBL_ACTRESS_SNS.TWITTER_URL is 'ツイッターURL';
comment on column TBL_ACTRESS_SNS.INSTAGRAM_URL is 'インスタグラムURL';
comment on column TBL_ACTRESS_SNS.CREATED_DATE is '作成日付';
comment on column TBL_ACTRESS_SNS.UPDATED_DATE is '更新日付';

comment on table TBL_GENERIC_ATTR is 'システム属性テーブル:システム情報を管理するテーブル';
comment on column TBL_GENERIC_ATTR.KEY is 'キー';
comment on column TBL_GENERIC_ATTR.VALUE is '値';

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
