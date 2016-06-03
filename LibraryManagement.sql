create database LibraryManagement
use LibraryManagement

create table Account(
	Username varchar(25),
	[Password] varchar(20)
)

create table Book(
	ID varchar(7) primary key,
	BookName varchar(50),
	AuthorName varchar(50),
	Publisher varchar(100),
	[Status] int
)

create table BorrowList(
	BorrowID varchar(7) primary key,
	BorrowerID int foreign key references Borrower(BorrowerID),
    IDBook varchar(7) foreign key references Book(ID),
	BorrowDate date,
	ReturnDate date
)

create table Borrower(
	BorrowerID int identity primary key,
	BorrowerName varchar(50),
	PhoneNumber varchar(15),
	[Address] varchar(500),
	Email varchar(100)
)

select TenSach, Tomtat, TenLoai, TenNXB, Tentacgia 
from Sach 
inner join LoaiSach on Sach.MaLoai = LoaiSach.MaLoai
inner join NhaXB on Sach.MaNXB = NhaXB.MaNXB
inner join TacGia on Sach.MaTG = TacGia.MaTG

insert into Account values ('admin', '123456')

insert into Book values('BK01','Tieng Viet lop 1','Nguyen Trai','Kim Dong',0)
insert into Book values('BK02','Day hoc tot toan 12','Mai Anh Hung','Bo giao duc va dao tao',0)
insert into Book values('BK03','Than thoai Hy Lap','Le Ba Tran Phuong','Nha XB Tre',0)

insert into Borrower values ('Chu Tien Tai', '0123456789','Gia Lam - Ha Noi','tientai@gmail.com')
insert into Borrower values ('Dam Duy Huong', '0122123456','Hung Yen - Ha Noi','damhuong@gmail.com')


insert into BorrowList values ('TK01', 1,'BK01','2016-05-02','1998-06-02')
insert into BorrowList values ('TK02', 2,'BK03','2016-05-22','1998-06-22')

select count(*) as totalTicket from BorrowList

select * from Book
select * from Borrower
select * from Account where username = 'admin'

create procedure signIn(
	@username varchar(100)
)as
begin
select * from Account where username = @username
end

create procedure searchBook(
	@id varchar(10)
)as 
begin
Select * from Book where ID like '%' +  @id + '%' or BookName like '%' +  @id + '%'
end

create procedure searchBorrower(
	@id varchar(10)
)as 
begin
Select * from Borrower where BorrowerID like '%' +  @id + '%' or BorrowerName like '%' +  @id + '%'
end

--drop table Sach
--drop table NhaXB
--drop table LoaiSach
--drop table TacGia
