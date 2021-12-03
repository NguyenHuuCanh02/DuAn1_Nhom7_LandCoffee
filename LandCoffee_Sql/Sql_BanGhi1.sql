select *from sanpham
select *from khachhang
select *from hoadon
select *from hoadonchitiet
insert into NHANVIEN values('NV001',N'Nguyễn Hữu Cảnh','HN','0968411582',0,100000)
insert into TAIKHOAN values('TK001','001',0,'NV001')
insert into SANPHAM values ('SP001',N'Bạc xỉu',35000,'d','NV001')
insert into SANPHAM values ('SP002',N'Cà phê sữa',25000,'d','NV001')
insert into SANPHAM values ('SP003',N'Cà phê cốt dừa',30000,'d','NV001')
insert into SANPHAM values ('SP004',N'Cà phê trứng',30000,'d','NV001')
insert into KHACHHANG values ('Khách hàng 1','HN','0968411582',0,'NV001')
insert into KHACHHANG values ('Khách hàng 2','HN','0968411582',0,'NV001')
insert into hoadon values
(150000,2,'TK001'),
(90000,1,'TK001')
insert into hoadonchitiet values 
('SP002',9,150000,1,'11/10/2021'),
('SP003',9,150000,2,'11/10/2021'),
('SP004',9,150000,2,'11/10/2021')
insert into hoadonchitiet values 
('SP002',3,90000,1,'11/10/2021'),
('SP003',3,90000,1,'11/10/2021'),
('SP004',3,90000,1,'11/10/2021')
