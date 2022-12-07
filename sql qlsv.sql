Create DataBase QLSV
Create Table MonHoc
 (
   MaMH char(5) primary key,
   TenMH nvarchar(30) not null,
   Sotinchi int not null check ( (Sotinchi>0)and (Sotinchi<9) )
 )

--- Tao Bang Khoa Hoc ---
Create Table KhoaHoc
 (
   MaKhoaHoc char(5) primary key,
   TenKhoaHoc nvarchar(20) not null
 )
--- Tao Bang Khoa --
Create Table Khoa
 (
   MaKhoa char(5) primary key,
   TenKhoa nvarchar(30) not null,
   DienThoai varchar(20) not null
 )
-- Tao Bang Lop ---
Create Table Lop
 (
   MaLop char(15) primary key,
   TenLop nvarchar(30) not null,
   MaKhoa char(5) foreign key references Khoa (MaKhoa),
   MaKhoaHoc char(5) foreign key references KhoaHoc (MaKhoaHoc),
 )
--- Tao Bang Sinh Vien ---
Create Table SinhVien
 (
   MaSV char(15) primary key,
   TenSV nvarchar(20) ,
   GioiTinh nvarchar(5),
   NgaySinh nvarchar(30) ,
   QueQuan nvarchar(50) ,
   MaLop char(15) foreign key references Lop(MaLop),
   MaKhoa char(5) foreign key references Khoa(MaKhoa)
 )
--- Tao Bang Diem ---
Create Table Diem
 (
   MaSV char(15) foreign key references SinhVien(MaSV),
   MaMH char(5) foreign key references MonHoc (MaMH),
   HocKy int check(HocKy>0) not null,
   Diemhocphan int ,
   Diemthi int
)
create table account(
	MaSV char(15) foreign key references SinhVien(MaSV),
	Matkhau char(15)
)
create table Ram(
	MaSV char(15) foreign key references SinhVien(MaSV),
	sosanh int
)