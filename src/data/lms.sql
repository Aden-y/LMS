create table if not exists Campus(
    CampusNo int  not null primary key auto_increment,
    CampusName varchar (100) not null unique key
);
create table if not exists Student (
    StudentNumber varchar (15) primary  key not null ,
    FirstName varchar (50) not null ,
    LastName varchar (50) not null ,
    Phone varchar (15) not null ,
    Email varchar (100) not null ,
    Sex varchar (20),
    DateOfBirth date not null ,
    BorrowerId int auto_increment not null,
    CampusNo int not null ,
    Department varchar(50) not null ,
    Password varchar (50) not null,
    foreign key (CampusNo) references Campus(CampusNo)
);

create table if not exists  Professor(
    EmploymentId varchar (15) primary  key not null ,
    FirstName varchar (50) not null ,
    LastName varchar (50) not null ,
    Phone varchar (50) not null ,
    Email varchar (100) not null ,
    Department varchar(50) not null ,
    EmploymentYear int(4) not null ,
    Password varchar (50) not null
);

create table if not exists Staff (
    UserId int  primary  key  auto_increment not null ,
    FirstName varchar (50) not null ,
    LastName varchar (50) not null ,
    Phone varchar (50) not null ,
    Email varchar (100) not null ,
    IsAdmin boolean default false not null ,
    CampusNo int not null ,
    Password varchar (50) not null,
    foreign key (CampusNo) references Campus(CampusNo)
);

create table if not exists BookCategory(
    CategoryId int primary key not null auto_increment,
    CategoryName varchar (100) not null unique key
);

create table if not exists Binding(
    BindingId int primary key auto_increment,
    BindingName varchar(50) not null
);

create table if not exists Shelf(
    ShelfId int primary key  null null auto_increment,
    ShelfNo int not null ,
    FloorNo int not null,
    CampusNo int not null ,
    foreign key (CampusNo) references Campus(CampusNo)
);

create table if not exists Book(
    ISBNCode int primary key not null auto_increment ,
    Title varchar (100) not null ,
    Author varchar (100) not null ,
    Language varchar (100) not null ,
    BindingId int not null ,
    CopiesActual int not null ,
    CopiesAvailable int not null ,
    CategoryId int not null ,
    PublicationYear int not null,
    ShelfId int not null ,
    foreign key (CategoryId) references BookCategory(CategoryId),
    foreign key (BindingId) references Binding(BindingId),
    foreign key (ShelfId) references Shelf(ShelfId)
);

create table if not exists Borrower(
    BorrowerId int primary key not null ,
    BookId int not null,
    BorrowedFrom date not null ,
    BorrowedTo date not null,
    ReturnDate date,
    Issuer varchar (15) not null ,
    foreign key (BorrowerId) references Student(BorrowerId),
    foreign key (BookId) references Book(ISBNCode),
    foreign key (Issuer) references Staff(UserId)
);

create table if not exists Billing(
    BorrowerId int primary key not null ,
    Days int not null default 1,
    TotalAmount double not null default 10.0,
    foreign key (BorrowerId) references Borrower(BorrowerId)
);

create table if not exists EBook(
    ISBNCode int primary key not null auto_increment ,
    Title varchar (100) not null ,
    Language varchar (100) not null ,
    CategoryId int not null ,
    Author varchar (100) not null ,
    PublicationYear int not null,
    FilePath varchar (255) not  null unique  key
);

create table if not exists BookRequest(
    RequestId int not null  primary key auto_increment,
    BorrowerId int not null ,
    ISBNCode int not null ,
    foreign key (BorrowerId) references Borrower(BorrowerId),
    foreign key (ISBNCode) references Book(ISBNCode)
);

