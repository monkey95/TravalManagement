create database LibraryManagement
use LibraryManagement

create table Account(
	Username varchar(25),
	[Password] varchar(20)
)

create table Book(
	ID varchar(7) primary key,
	BookName varchar(50),
	authorID varchar(7) foreign key references Author(authorID),
	publisherID varchar(7) foreign key references Publisher(publisherID),
	[Status] int
)

create table Author(
	authorID varchar(7) primary key,
	authorName varchar(50),
	authorPhone varchar(12),
	authorAddress varchar(500),
	authorEmail varchar(100),
	authorStatus int
)

create table Publisher(
	publisherID varchar(7) primary key,
	publisherName varchar(50),
	publisherPhone varchar(12),
	publisherAddress varchar(500),
	publisherEmail varchar(100),
	publisherStatus int
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
	ActualReturnDate date,
	ReturnDate date,
	ticketStatus int
)

insert into Account values ('admin', '123456')

insert into Author values('AT01','Le Ba Tran Phuong','0123475698','Ha Noi','teacher@hocmai.vn',0)
insert into Author values('AT02','Ha Anh Minh','0166389189','TP. Ho Chi Minh','anhminh@gmail.com',0)
insert into Author values('AT03','Mai Anh Hung','0976189165','Ha Noi','maianhhung@gmail.com',0)

insert into Publisher values('PB01','NXB Tre','0438443360','Ha Noi','nxbtre@gmail.com',0)
insert into Publisher values('PB02','NXB Kim Dong','0437612955','Ha Noi','nxbkimdong@gmail.com',0)

insert into Book values('BK01','Tieng Viet lop 1','AT03','PB02',1)
insert into Book values('BK02','Day hoc tot toan 12','AT02','PB02',0)
insert into Book values('BK03','Tu hoc Excel','AT01','PB01',1)
insert into Book values('BK04','Tu hoc PowerPoint','AT01','PB01',0)
insert into Book values('BK05','Tu hoc Word','AT01','PB01',0)
insert into Book values('BK06','Tu hoc Android','AT01','PB01',0)
insert into Book values('BK07','Tieng Anh lop 9','AT03','PB01',0)
insert into Book values('BK08','Van hoc Viet Nam','AT01','PB01',0)
insert into Book values('BK09','Sach day nau an','AT01','PB01',0)
insert into Book values('BK010','Tu sua chua may tinh','AT01','PB02',0)

insert into Borrower values ('Chu Tien Tai', '0123456789','Gia Lam - Ha Noi','tientai@gmail.com')
insert into Borrower values ('Dam Duy Huong', '0122123456','Hung Yen - Ha Noi','damhuong@gmail.com')

insert into BorrowList values ('TK01', 1,'BK01','2016-05-02','2016-05-15','2016-06-02',1)
insert into BorrowList values ('TK02', 2,'BK03','2016-05-22','2016-06-02','2016-06-06',1)

select count(*) as totalTicket from BorrowList

select * from Book
select * from Borrower
select * from BorrowList
select * from Author
select * from Publisher
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

create procedure searchAuthor(
	@id varchar(10)
)as 
begin
Select * from Author where authorStatus=0 and (authorID like '%' +  @id + '%' or authorName like '%' +  @id + '%')
end

create procedure searchPublisher(
	@id varchar(10)
)as 
begin
Select * from Publisher where publisherStatus=0 and (publisherID like '%' +  @id + '%' or publisherName like '%' +  @id + '%')
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
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ActualReturnDate ,BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate > GETDATE() 
end

create procedure getExpiredBorrowList
as
begin
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate < GETDATE() and ticketStatus = 1
end

create procedure getUnexpiredBorrowList
as
begin
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate, BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate < GETDATE() and ticketStatus = 0
end

create procedure getReturnedBorrowList
as
begin
SELECT        BorrowList.BorrowID, Book.ID, Book.BookName, Borrower.BorrowerName, Borrower.PhoneNumber, BorrowList.BorrowDate,BorrowList.ActualReturnDate ,BorrowList.ReturnDate
FROM            Book INNER JOIN
                         BorrowList ON Book.ID = BorrowList.IDBook INNER JOIN
                         Borrower ON BorrowList.BorrowerID = Borrower.BorrowerID where ReturnDate < GETDATE() and ticketStatus = 2
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

