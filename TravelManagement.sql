create database TravelManagement
go
use TravelManagement
go
create table Account(
	username varchar(50) primary key,
	[password] varchar(50)
)

create table Customer(
	CustomerID int primary key identity(1,1),
	CustomerName varchar(50),
	CustomerAddress varchar(100),
	CustomerAge int,
	CustomerPhoneNumber varchar(15),
	CustomerEmailAddress varchar(50)
)

create table Location(
	LocationID int primary key identity (1, 1),
	LocationName varchar(100),
	LocationAddress varchar(100)
)

create table Tour(
	TourID int primary key identity(1,1),
	TourName varchar(100),
	TourLocation int foreign key references Location(LocationID),
	TourStart datetime,
	TourEnd datetime
)

create table CustomerOfTour(
	TourID int foreign key references Tour(TourID),
	CutomerID int foreign key references Customer(CustomerID)
)