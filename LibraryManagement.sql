create database LibraryManagement
use LibraryManagement

create table Account(
	Username varchar(50),
	[Password] varchar(20)
)

create table Book(
	ID int identity primary key,
	IDType int foreign key references BookType(IDType),
	BookName varchar(50),
	AuthorId int foreign key references Author(AuthorID),
	PublisherID int foreign key references Publisher(PublisherID), 
	[Status] int
)

create table BookType(
	IDType int identity primary key,
	TypeName varchar(50),
)

create table Publisher(
	PublisherID int identity primary key,
	PublisherName varchar(100),
	PublisherAddress varchar(100),
	PublisherPhone varchar(12)
)

create table Author(
	AuthorID int identity primary key,
	AuthorName varchar(50),
	AuthorAddress varchar(100),
	AuthorPhone varchar(12)
)

create table BorrowList(
	BorrowerName varchar(50),
	PhoneNumber varchar(15),
    IDBook int foreign key references Book(ID),
	BorrowDate datetime,
	ReturnDate datetime
)

select TenSach, Tomtat, TenLoai, TenNXB, Tentacgia 
from Sach 
inner join LoaiSach on Sach.MaLoai = LoaiSach.MaLoai
inner join NhaXB on Sach.MaNXB = NhaXB.MaNXB
inner join TacGia on Sach.MaTG = TacGia.MaTG

insert into Account values ('admin', '123456')

insert into BookType values('co tich'),('hoc tot')
insert into BookType values('SGK'),('truyen tranh')

insert into Publisher values('Kim Dong','55 Quang Trung, Ha Noi','0439434730')
insert into Publisher values('Bo giao duc va dao tao','23 Quang Trung, Ha Noi','0439421429')
insert into Publisher values('Nha XB Tre','209 Giang Vo','0437734544')

insert into Author values('Bo GD & DT','23 Quang Trung, Ha Noi','0439421429')
insert into Author values('Nhieu Tac Gia','Ha Noi','0438339999')
insert into Author values('Nhieu Tac Gia','Ha Noi','0437777777')

insert into Book values(3,'Tieng Viet lop 1',1,2, 0)
insert into Book values(2,'Day hoc tot toan 12',3,3, 0)
insert into Book values(4,'Than thoai Hy Lap',2,3, 0)

select * from Book
select * from Publisher
select * from Author
select * from BookType
select * from Account where username = 'admin'

create procedure signIn(
	@username varchar(100)
)as
begin
select * from Account where username = @username
end

--drop table Sach
--drop table NhaXB
--drop table LoaiSach
--drop table TacGia
