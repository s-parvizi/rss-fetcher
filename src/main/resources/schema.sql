create table if not exists Feed_Message
(
   id varchar(50) not null,
   link varchar(255) ,
   title varchar(255) not null,
   html_desc clob not null,
   text_desc clob not null,
   source varchar(255) ,
   item_time timestamp ,
   fetch_time timestamp not null,
   primary key(id)
);
