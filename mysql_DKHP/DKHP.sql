create database DangKiHocPhan
use DangKihocPhan
drop database DangKiHocPhan

create table SinhVien(
id int auto_increment primary key,
maSinhVien char(10),
tenSinhVien varchar(50) charset utf8mb4,
gioiTinh varchar(5) charset utf8mb4,
ngaySinh date,
diaChi varchar(50) charset utf8mb4,
idLop int not null, 
taiKhoan char(10),
matKhau char(10),
unique(taiKhoan,maSinhVien)
)

create table GiaoVu(
id int auto_increment primary key,
maGiaoVu char(10),
tenGiaoVu varchar(50) charset utf8mb4,
gioiTinh varchar(5) charset utf8mb4,
ngaySinh date,
diaChi varchar(50) charset utf8mb4, 
taiKhoan char(10),
matKhau char(10),
unique(taiKhoan,maGiaoVu)
)

create table LopHoc(
id int auto_increment primary key,
maLop char(10),
tenLop varchar(10),
maGVCN char(10),
unique(maGVCN)
)

create table GiaoVien(
id int auto_increment primary key,
maGiaoVien char(10),
tenGiaoVien varchar(50) charset utf8mb4, 
gioiTinh varchar(5) charset utf8mb4,
ngaySinh date,
diaChi varchar(50) charset utf8mb4, 
idMonHoc int not null,
unique(maGiaoVien)
)

create table MonHoc(
id int auto_increment primary key,
maMonHoc char(10),
tenMonHoc varchar(50) charset utf8mb4, 
soTinChi int
)

create table HocPhanMo(
id int auto_increment primary key,
idMonHoc int not null,
idThoiGianDKHP int not null,
maGVLT char(10),
tenHocPhan varchar(50) charset utf8mb4, 
tenPhongHoc varchar(10) charset utf8mb4, 
thu varchar(10) charset utf8mb4,
ca int,
soLuong int
)

create table SinhVien_HocPhan(
id int auto_increment primary key,
idSinhVien int not null,
idHocPhanMo int not null,
ngayDangKi date
)

create table HocKi (
id int auto_increment primary key,
tenHocKi char(10),
namHoc int, 
ngayBatDau date,
ngayKetThuc date
)

create table ThoiGianDKHP(
id int auto_increment primary key,
idKi int not null,
ngayBatDau date,
ngayKetThuc date
)

alter table SinhVien add constraint FK_SV_LOP foreign key(idLop) references LopHoc(id)

alter table SinhVien_HocPhan add constraint FK_SV_HP foreign key(idSinhVien) references SinhVien(id)
alter table SinhVien_HocPhan add constraint FK_HP_SV foreign key(idHocPhanMo) references HocPhanMo(id)

alter table GiaoVien add constraint FK_GV_MH foreign key(idMonHoc) references MonHoc(id)

alter table HocPhanMo add constraint FK_HP_MH foreign key(idMonHoc) references MonHoc(id)
alter table HocPhanMo add constraint FK_HP_TGDKHP foreign key(idThoiGianDKHP) references ThoiGianDKHP(id)

alter table ThoiGianDKHP add constraint FK_TGDKHP_HK foreign key(idKi) references HocKi(id)

insert into GiaoVu(maGiaoVu,tenGiaoVu,gioiTinh,ngaySinh,diaChi,taiKhoan,matKhau) values
('10120001','H??? Tu???n Thanh','Nam','1980-01-01','TP HCM','10120001','10120001'),
('10120002','Nguy???n V??n Khi???t','Nam', '1975-02-01', 'Gia Lai','10120002','10120002'),
('10120003','Mai Tu???n Anh','Nam','1985-03-01','B??nh Ph?????c','10120003','10120003')

insert into MonHoc(maMonHoc,tenMonHoc,soTinChi) values
('CSC0001','Nh???p M??n L???p Tr??nh',4),
('CSC0002','K?? Thu???t L???p Tr??nh',4),
('CSC0003','L???p Tr??nh H?????ng ?????i T?????ng',4),
('CSC0004','C?? S??? D??? Li???u',4),
('CSC0005','M???ng M??y T??nh',4)

insert into GiaoVien(maGiaoVien,tenGiaoVien,gioiTinh,ngaySinh,diaChi,idMonHoc) values
('10120001','H??? Tu???n Thanh','Nam','1980-01-01','TP HCM',1),
('10120002','Nguy???n V??n Khi???t','Nam','1975-02-01','Gia Lai',2),
('10120003','Mai Tu???n Anh','Nam','1985-03-01','B??nh Ph?????c',3),
('10120004','Cao Xu??n Nam','Nam','1984-03-01','TP HCM',4),
('10120005','L?? Qu???c H??a','Nam','1987-04-01','H?? T??nh',5)

insert into LopHoc(maLop,tenLop,maGVCN) values
('19CNTN','19CNTN','10120001'),
('19CTT1','19CTT1','10120002'),
('19CTT2','19CTT2','10120003'),
('19CTT3','19CTT3','10120004'),
('19CTT4','19CTT4','10120005')

insert into HocKi(tenHocKi,namHoc,ngayBatDau,ngayKetThuc) values
('HK1', 2019, '2019-08-01', '2020-01-31'),
('HK2', 2019, '2020-02-01', '2020-05-31'),
('HK3', 2019, '2020-06-01', '2020-07-31'),
('HK1', 2020, '2020-08-01', '2021-01-31'),
('HK2', 2020, '2021-02-01', '2021-05-31'),
('HK3', 2020, '2021-06-01', '2021-07-31'),
('HK1', 2021, '2021-08-01', '2022-01-31'),
('HK2', 2021, '2022-02-01', '2022-05-31'),
('HK3', 2021, '2022-06-01', '2022-07-31')

insert into ThoiGianDKHP(idKi,ngayBatDau,ngayKetThuc) values
(1,'2019-07-01', '2019-07-31'),
(2,'2020-01-01', '2020-01-31'),
(3,'2020-05-01', '2020-05-31'),
(4,'2020-07-01', '2020-07-31'),
(5,'2021-01-01', '2021-01-31'),
(6,'2021-05-01', '2021-05-31'),
(7,'2021-07-01', '2021-07-31'),
(8,'2022-01-01', '2022-01-31'),
(9,'2022-05-01', '2022-05-31')

insert into HocPhanMo(idMonHoc,idThoiGianDKHP,maGVLT,tenHocPhan,tenPhongHoc,thu,ca,soLuong) values
(1,1,'10120001','Nh???p M??n L???p Tr??nh 1','E201','Th??? 2',1,150),
(1,1,'10120001','Nh???p M??n L???p Tr??nh 2','E203','Th??? 2',3,150),
(1,1,'10120001','Nh???p M??n L???p Tr??nh 3','F201','Th??? 6',1,150),
(2,2,'10120002','K?? Thu???t L???p Tr??nh 1','E202','Th??? 3',2,150),
(2,2,'10120002','K?? Thu???t L???p Tr??nh 2','G202','Th??? 7',1,150),
(2,2,'10120002','K?? Thu???t L???p Tr??nh 3','E204','Th??? 4',2,150),
(3,4,'10120003','L???p Tr??nh H?????ng ?????i T?????ng 1','E103','Th??? 4',1,150),
(3,4,'10120003','L???p Tr??nh H?????ng ?????i T?????ng 2','E303','Th??? 5',3,150),
(3,4,'10120003','L???p Tr??nh H?????ng ?????i T?????ng 3','F103','Th??? 6',1,150),
(4,5,'10120004','C?? S??? D??? Li???u 1','E301','Th??? 5',1,150),
(4,5,'10120004','C?? S??? D??? Li???u 2','F301','Th??? 6',3,150),
(4,5,'10120004','C?? S??? D??? Li???u 2','G301','Th??? 7',2,150),
(5,5,'10120005','M???ng M??y T??nh 1','D201','Th??? 4',1,150),
(5,5,'10120005','M???ng M??y T??nh 2','D201','Th??? 5',3,150),
(5,5,'10120005','M???ng M??y T??nh 3','E201','Th??? 6',2,150)

insert into SinhVien(maSinhVien,tenSinhVien,gioiTinh,ngaySinh,diaChi,idLop,taiKhoan,matKhau) values
('19120001','L?? H???ng Qu??n','Nam','2001-04-24','?????c L???c',1,'19120001','19120001'),
('19120002','Nguy???n Phan L?? Nh??n','N???','2001-05-07','B??nh Thu???n',1,'19120002','19120002'),
('19120003','??o??n Ng???c Nguy??n','Nam','2001-01-01','Gia Lai',2,'19120003','19120003'),
('19120004','Nguy???n H???u Ph????ng','Nam','2001-02-02','B??nh Ph?????c',3,'19120004','19120004'),
('19120005','Nguy???n Anh Qu???c','Nam','2001-03-03','B??nh ?????nh',4,'19120005','19120005'),
('19120006','????o Th??? Thi???n T??m','N???','2001-04-04','B???n Tre',4,'19120006','19120006'),
('19120007','Nguy???n H???u Ph??','Nam','2001-05-05','?????c L???c',5,'19120007','19120007')

insert into SinhVien_HocPhan(idSinhVien,idHocPhanMo,ngayDangKi) values
(1,1,'2019-07-05'),
(1,4,'2020-01-05'),
(1,7,'2020-07-05'),
(2,1,'2019-07-07'),
(2,1,'2020-01-05')

alter table hocki
add column setHocKi int after ngayKetThuc;
