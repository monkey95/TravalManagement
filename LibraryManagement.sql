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

create table Borrower(
	BorrowerID int identity primary key,
	BorrowerName varchar(50),
	PhoneNumber varchar(15),
	[Address] varchar(500),
	Email varchar(100)
)

create table BorrowList(
	BorrowID varchar(7) primary key,
	BorrowerID int foreign key references Borrower(BorrowerID),
    IDBook varchar(7) foreign key references Book(ID),
	BorrowDate date,
	ReturnDate date,
	ticketStatus int
)

insert into Account values ('admin', '123456')

insert into Book values('BK01','Tieng Viet lop 1','Nguyen Trai','Kim Dong',1)
insert into Book values('BK02','Day hoc tot toan 12','Mai Anh Hung','Bo giao duc va dao tao',0)
insert into Book values('BK03','Tu hoc Excel','Le Ba Tran Phuong','Nha XB Tre',1)
insert into Book values('BK04','Tu hoc PowerPoint','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK05','Tu hoc Word','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK06','Tu hoc Android','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK07','Tieng Anh lop 9','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK08','Van hoc Viet Nam','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK09','Sach day nau an','Le Ba Tran Phuong','Nha XB Tre',0)
insert into Book values('BK010','Tu sua chua may tinh','Le Ba Tran Phuong','Nha XB Tre',0)

insert into Borrower values ('Chu Tien Tai', '0123456789','Gia Lam - Ha Noi','tientai@gmail.com')
insert into Borrower values ('Dam Duy Huong', '0122123456','Hung Yen - Ha Noi','damhuong@gmail.com')

insert into BorrowList values ('TK01', 1,'BK01','2016-05-02','1998-06-02',1)
insert into BorrowList values ('TK02', 2,'BK03','2016-05-22','1998-06-22',1)

select count(*) as totalTicket from BorrowList

select * from Book
select * from Borrower
select * from BorrowList
select * from Account where username = 'admin'

create procedure returnBook(
	@ticketID varchar(10),
	@bookID varchar(10)
)as
begin
update BorrowList set ticketStatus = 0 where BorrowID = @ticketID
update Book set [Status] = 0 where ID = @bookID
end

create procedure searchBorrowTicket(
	@id varchar(10)
)as 
begin
SELECT        BorrowList.BorrowID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ticketStatus = 1 and BorrowID like '%' + @id +'%'
end

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
Select * from Book where [Status]=0 and (ID like '%' +  @id + '%' or BookName like '%' +  @id + '%')
end

create procedure searchBorrower(
	@id varchar(10)
)as 
begin
Select * from Borrower where BorrowerID like '%' +  @id + '%' or BorrowerName like '%' +  @id + '%'
end

create procedure getBorrowList
as
begin
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate > GETDATE() and ticketStatus = 1
end

create procedure getExpiredBorrowList
as
begin
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate < GETDATE() and ticketStatus = 1
end

create procedure AddTicket(
	@ticketID varchar(10),
	@borrowerID varchar(10),
	@bookID varchar(10),
	@borrowDate date,
	@returnDate date
)as
begin
insert into BorrowList values (@ticketID, @borrowerID, @bookID, @borrowDate, @returnDate,1)
update Book set [Status] = 1 where ID=@bookID
end

drop procedure AddTicket

