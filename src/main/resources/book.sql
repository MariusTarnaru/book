create schema if not exists books;
create table books.book (
    id bigint unsigned unique not null auto_increment,
    title varchar(120),
    author varchar(120)
)
