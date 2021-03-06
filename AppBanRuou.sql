create database QLBANRUOU
go
USE [QLBANRUOU]
GO
/****** Object:  Table [dbo].[ADMIN]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ADMIN](
	[UserAdmin] [varchar](30) NOT NULL,
	[PassAdmin] [varchar](30) NULL,
	[Hoten] [nvarchar](50) NULL,
 CONSTRAINT [PK_ADMIN] PRIMARY KEY CLUSTERED 
(
	[UserAdmin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CHITIETDONTHANG]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETDONTHANG](
	[MaDH] [int] NOT NULL,
	[Maruou] [int] NOT NULL,
	[Soluong] [int] NULL,
	[Dongia] [decimal](18, 0) NULL,
 CONSTRAINT [PK_CTDatHang] PRIMARY KEY CLUSTERED 
(
	[MaDH] ASC,
	[Maruou] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DONDATHANG]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DONDATHANG](
	[MaDH] [int] IDENTITY(1,1) NOT NULL,
	[Dathanhtoan] [bit] NULL,
	[Tinhtranggiaohang] [bit] NULL,
	[Ngaydat] [datetime] NULL,
	[Ngaygiao] [datetime] NULL,
	[MaKH] [int] NULL,
 CONSTRAINT [PK_DonDatHang] PRIMARY KEY CLUSTERED 
(
	[MaDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[TaiKhoan] [varchar](50) NULL,
	[MatKhau] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
	[DiaChiKH] [nvarchar](200) NULL,
	[DienThoaiKH] [varchar](50) NULL,
	[NgaySinh] [datetime] NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NHACUNGCAP]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NHACUNGCAP](
	[MaNCC] [int] IDENTITY(1,1) NOT NULL,
	[TenNCC] [nvarchar](100) NULL,
	[DiaChi] [nvarchar](100) NULL,
	[DienThoai] [varchar](15) NULL,
 CONSTRAINT [PK_NHACUNGCAP] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PHANLOAI]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHANLOAI](
	[MaLoaiRuou] [int] IDENTITY(1,1) NOT NULL,
	[Loairuou] [nvarchar](50) NULL,
 CONSTRAINT [PK_PHANLOAI] PRIMARY KEY CLUSTERED 
(
	[MaLoaiRuou] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RUOU]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RUOU](
	[MaRuou] [int] IDENTITY(1,1) NOT NULL,
	[TenRuou] [nvarchar](100) NULL,
	[Giaban] [decimal](18, 0) NULL,
	[Mota] [nvarchar](max) NULL,
	[AnhRuou] [varchar](50) NULL,
	[NgayCapNhat] [smalldatetime] NULL,
	[SoLuongTon] [int] NULL,
	[MaXXu] [int] NULL,
	[MaNCC] [int] NULL,
	[MaLoaiRuou] [int] NULL,
 CONSTRAINT [PK_RUOU] PRIMARY KEY CLUSTERED 
(
	[MaRuou] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[XUATXU]    Script Date: 06/24/2020 9:22:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XUATXU](
	[MaXXu] [int] IDENTITY(1,1) NOT NULL,
	[TenXXu] [nvarchar](50) NULL,
 CONSTRAINT [PK_XUATXU] PRIMARY KEY CLUSTERED 
(
	[MaXXu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ADMIN] ([UserAdmin], [PassAdmin], [Hoten]) VALUES (N'admin', N'123456', N'Lord')
INSERT [dbo].[ADMIN] ([UserAdmin], [PassAdmin], [Hoten]) VALUES (N'user', N'123456', N'Shift')
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (1, 33, 1, CAST(100000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (2, 33, 2, CAST(100000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (3, 39, 1, CAST(510000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (3, 40, 1, CAST(610000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (4, 37, 1, CAST(320000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (4, 39, 1, CAST(510000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (4, 40, 2, CAST(610000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (5, 40, 1, CAST(610000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (6, 39, 1, CAST(510000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (6, 40, 1, CAST(610000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (7, 35, 2, CAST(399000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (8, 38, 1, CAST(420000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (9, 29, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (9, 30, 1, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (10, 32, 4, CAST(600000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (10, 62, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (11, 39, 1, CAST(510000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (11, 60, 1, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (11, 62, 2, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (11, 65, 1, CAST(350000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (12, 60, 1, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (12, 62, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (12, 64, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (13, 32, 1, CAST(600000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (13, 39, 1, CAST(510000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (18, 62, 2, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (18, 64, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (19, 61, 4, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (19, 62, 2, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (19, 64, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (20, 60, 1, CAST(300000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (21, 61, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (22, 62, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (23, 61, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (23, 64, 1, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (24, 62, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (25, 29, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (25, 81, 2, CAST(1000000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (26, 29, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (27, 62, 1, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (28, 29, 2, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (1028, 62, 2, CAST(150000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (1028, 64, 2, CAST(500000 AS Decimal(18, 0)))
INSERT [dbo].[CHITIETDONTHANG] ([MaDH], [Maruou], [Soluong], [Dongia]) VALUES (1029, 60, 2, CAST(300000 AS Decimal(18, 0)))
SET IDENTITY_INSERT [dbo].[DONDATHANG] ON 

INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (1, 0, 0, CAST(N'2019-03-07 18:21:21.220' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 5)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (2, 0, 0, CAST(N'2019-03-07 18:23:20.113' AS DateTime), CAST(N'2018-04-12 00:00:00.000' AS DateTime), 5)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (3, 0, 0, CAST(N'2018-03-14 14:05:44.537' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (4, 0, 0, CAST(N'2019-03-14 17:51:50.283' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (5, 0, 0, CAST(N'2019-03-15 19:57:12.840' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (6, 0, 0, CAST(N'2019-03-16 07:32:45.647' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (7, 0, 0, CAST(N'2019-03-16 22:05:17.987' AS DateTime), CAST(N'2018-04-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (8, 0, 0, CAST(N'2019-03-30 11:52:38.000' AS DateTime), CAST(N'2018-05-20 00:00:00.000' AS DateTime), 7)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (9, 0, 0, CAST(N'2019-04-01 17:18:36.800' AS DateTime), CAST(N'2018-05-05 00:00:00.000' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (10, 0, 0, CAST(N'2018-04-01 18:46:25.037' AS DateTime), CAST(N'2018-05-10 00:00:00.000' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (11, 0, 0, CAST(N'2018-04-01 21:29:29.753' AS DateTime), CAST(N'2018-05-04 21:29:29.753' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (12, 0, 0, CAST(N'2018-04-01 22:15:02.513' AS DateTime), CAST(N'2018-05-04 22:15:02.513' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (13, 0, 0, CAST(N'2018-04-01 22:47:57.000' AS DateTime), CAST(N'2018-05-04 22:47:57.000' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (16, 0, 0, CAST(N'2018-04-01 23:15:55.423' AS DateTime), CAST(N'2018-05-04 23:15:55.423' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (17, 0, 0, CAST(N'2018-04-01 23:19:26.127' AS DateTime), CAST(N'2018-05-04 23:19:26.127' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (18, 0, 0, CAST(N'2018-04-01 23:21:36.803' AS DateTime), CAST(N'2018-05-04 23:21:36.803' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (19, 0, 0, CAST(N'2018-04-01 23:24:44.633' AS DateTime), CAST(N'2018-05-04 23:24:44.633' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (20, 0, 0, CAST(N'2018-04-01 23:28:32.730' AS DateTime), CAST(N'2018-05-04 23:28:32.730' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (21, 0, 0, CAST(N'2018-04-02 13:47:55.133' AS DateTime), CAST(N'2018-05-05 13:47:55.133' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (22, 0, 0, CAST(N'2018-04-02 15:22:06.737' AS DateTime), CAST(N'2018-05-05 15:22:06.740' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (23, 0, 0, CAST(N'2018-04-02 18:17:16.343' AS DateTime), CAST(N'2018-05-05 18:17:16.343' AS DateTime), 10)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (24, 0, 0, CAST(N'2018-04-02 18:27:05.367' AS DateTime), CAST(N'2018-05-05 18:27:05.367' AS DateTime), 8)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (25, 0, 0, CAST(N'2019-04-08 15:55:10.937' AS DateTime), CAST(N'2019-04-11 15:55:10.937' AS DateTime), 11)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (26, 0, 0, CAST(N'2019-04-09 17:48:26.103' AS DateTime), CAST(N'2019-04-12 17:48:26.103' AS DateTime), 12)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (27, 0, 0, CAST(N'2019-04-09 21:18:18.043' AS DateTime), CAST(N'2019-04-12 21:18:18.043' AS DateTime), 11)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (28, 0, 0, CAST(N'2019-04-13 09:59:21.060' AS DateTime), CAST(N'2019-04-16 09:59:21.060' AS DateTime), 11)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (1028, 0, 0, CAST(N'2019-09-12 17:44:50.473' AS DateTime), CAST(N'2019-09-15 17:44:50.473' AS DateTime), 12)
INSERT [dbo].[DONDATHANG] ([MaDH], [Dathanhtoan], [Tinhtranggiaohang], [Ngaydat], [Ngaygiao], [MaKH]) VALUES (1029, 0, 0, CAST(N'2020-05-31 14:14:52.430' AS DateTime), CAST(N'2020-06-03 14:14:52.430' AS DateTime), 12)
SET IDENTITY_INSERT [dbo].[DONDATHANG] OFF
SET IDENTITY_INSERT [dbo].[KHACHHANG] ON 

INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (5, N'a', N'a', N'1', N'abc@abc.com', N'82 nguyễn xí', N'0979123456', CAST(N'1898-01-24 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (6, N'b', N'b', N'1', N'abc@abc.com', N'sdfge', N'quedd13d', CAST(N'1975-04-04 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (7, N'c', N'c', N'123', N'abc@abc.com', N'67 XVNT', N'0123456789', CAST(N'1998-06-24 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (8, N'ahuhu', N'd', N'123', N'abc@abc.com', N'82 nguyễn xí', N'01233216978', CAST(N'2019-03-25 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (9, N'ban', N'e', N'123', N'abc@abc.com', N'23 D5', N'0123456789', CAST(N'2019-04-02 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (10, N'ahihi', N'f', N'123', N'abc@abc.com', N'88 D2', N'01233214567', CAST(N'2019-04-08 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (11, N'Bậc Mã Ôn', N'tethiendaithanh', N'123456', N'abc@abc.com', N'fffff', N'19001906', CAST(N'2019-04-08 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (12, N'Cần Hút Cỏ', N'demmautrangtrongconmo', N'123456', N'abc@abc.com', N'asd', N'19001906', CAST(N'1998-04-09 00:00:00.000' AS DateTime))
INSERT [dbo].[KHACHHANG] ([MaKH], [HoTen], [TaiKhoan], [MatKhau], [Email], [DiaChiKH], [DienThoaiKH], [NgaySinh]) VALUES (13, N'khánh', N'qwe', N'qwe', N'ahihu@gmail.com', N'3asdố 6 P.Bình Trưng Tây Q2', N'222222222', CAST(N'2020-01-01 00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[KHACHHANG] OFF
SET IDENTITY_INSERT [dbo].[NHACUNGCAP] ON 

INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [DienThoai]) VALUES (1, N'CNHH Sài Gòn', N'TP.HCM', N'0123456789')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [DienThoai]) VALUES (2, N'CNHH Bình Định', N'Tỉnh Bình Định', N'01233216789')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [DienThoai]) VALUES (3, N'CNHH Hà Nội', N'Thủ đô Hà Nội', N'09790746789')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [DienThoai]) VALUES (4, N'CNHH Hải Phòng', N'TP Hải Phòng', N'01233214567')
INSERT [dbo].[NHACUNGCAP] ([MaNCC], [TenNCC], [DiaChi], [DienThoai]) VALUES (5, N'CNHH Đà Nẵng', N'TP Đà Nẵng', N'01234566543')
SET IDENTITY_INSERT [dbo].[NHACUNGCAP] OFF
SET IDENTITY_INSERT [dbo].[PHANLOAI] ON 

INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (28, N'Ruou Vang')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (29, N'Rượu Brandy')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (30, N'Rượu Rum')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (31, N'Rượu Sâm panh')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (32, N'Rượu Bàu Đá')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (33, N'Rượu Đế')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (34, N'Rượu Cần')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (35, N'Rượu Sake')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (36, N'Rượu Gò Đen')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (37, N'Rượu Nếp')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (38, N'Rượu Shochu')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (39, N'Rượu Hoàng Tửu')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (40, N'Rượu Bạch Tửu')
INSERT [dbo].[PHANLOAI] ([MaLoaiRuou], [Loairuou]) VALUES (42, N'Rượu Sake')
SET IDENTITY_INSERT [dbo].[PHANLOAI] OFF
SET IDENTITY_INSERT [dbo].[RUOU] ON 

INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (29, N'Ruou Brandy', CAST(150000 AS Decimal(18, 0)), N'Brandy là tên gọi chung của các loại rượu mạnh được chế biến từ sự chưng cất của rượu vang hoặc từ trái cây nghiền nát rồi ủ lâu trong thùng gỗ một thời gian (ít nhất là hai năm). Sau đó được làm giảm nồng độ rượu bằng cách pha thêm nước cất.', N'BrandSTXO.jpg', CAST(N'2018-05-02 20:02:00' AS SmallDateTime), 50, 8, 2, 40)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (30, N'Rượu Rum', CAST(300000 AS Decimal(18, 0)), N'Rượu Rum là một đồ uống có cồn được chưng cất từ mía với sản phẩm như mật đường, hoặc trực tiếp từ nước mía, một quá trình lên men và chưng cất. Chưng cất, một chất lỏng rõ ràng, thường là sau đó độ tuổi trong thùng gỗ sồi. Rum có thể được gọi tên theo các mô tả như "ron Viejo" ("rum cũ") và "ron añejo" ("rum có tuổi").', N'Rumbarcadi-jpeg.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 20, 4, 3, 30)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (31, N'Rượu Sâm panh', CAST(400000 AS Decimal(18, 0)), N'Sâm banh (bắt nguồn từ tiếng Pháp: champagne)[1], còn gọi là sâm panh, là một dạng vang nổ được sản xuất bằng cách tạo ra sự lên men thứ cấp trong chai chứa rượu vang để thực hiện sự cacbonat hóa. Nó được đặt tên theo khu vực Champagne của Pháp. Trong khi thuật ngữ "champagne" (sâm panh) thông thường được các nhà sản xuất vang nổ tại các khu vực khác trên thế giới sử dụng để chỉ sản phẩm của mình thì có nhiều ý kiến cho rằng nó nên được sử dụng một cách chính xác để chỉ tới các loại rượu vang được sản xuất tại khu vực Champagne. Nguyên tắc này được coi trọng tại Liên minh châu Âu bằng quan hệ pháp lý của tên gọi được bảo hộ về nguồn gốc (PDO).', N'ruou-sam-banh-10-dong-tien.png', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 10, 8, 4, 31)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (32, N'Rượu Bàu Đá', CAST(600000 AS Decimal(18, 0)), N'Tên gọi của rượu là do được nấu chủ yếu từ làng Cù Lâm thuộc xã Nhơn Lộc, huyện An Nhơn, tỉnh Bình Định. Bàu Đá là tên của một bàu nước ngày xưa cả làng dùng chung, là nguồn nước để chưng cất rượu Bàu Đá. Bàu nước cổ này ngày nay (2010s) đã cạn nước, nguồn nước chủ yếu để ủ men, cất rượu bây giờ là từ những mạch nước giếng của làng.', N'Bau-da.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 60, 1, 5, 32)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (33, N'Rượu Đế', CAST(100000 AS Decimal(18, 0)), N'Rượu trắng, rượu đế, rượu ngang, rượu gạo, rượu chưng, rượu cuốc lủi hay rượu quốc lủi đều là cách gọi của loại rượu chưng cất từ ngũ cốc lên men được làm một cách thủ công trong dân gian, rất thịnh hành trong ẩm thực Việt Nam.', N'Ruou-de.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 70, 6, 1, 33)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (34, N'Rượu Cần', CAST(450000 AS Decimal(18, 0)), N'Rượu cần là cách gọi của người Việt đối với loại rượu đặc sản được một số dân tộc thiểu số Việt Nam ủ men trong hũ/bình/ché/chóe/ghè, không qua chưng cất, khi đem ra uống phải dùng các cần làm bằng tre/trúc đục thông lỗ để hút rượu.', N'ruou-can.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 80, 1, 2, 34)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (35, N'Rượu Sake', CAST(399000 AS Decimal(18, 0)), N'Sake (phiên âm tiếng Việt sa kê) theo cách hiểu phổ biến trên thế giới là một thứ rượu nhẹ truyền thống nấu từ gạo qua nhiều công đoạn lên men mà người Nhật gọi là Nihonshu (日本酒 | Rượu Nhật Bản) hoặc Luật Thuế Rượu của Nhật Bản gọi là Seishu.', N'ruou-nhat-ban-sake.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 90, 3, 3, 35)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (36, N'Rượu Gò Đen', CAST(270000 AS Decimal(18, 0)), N'Rượu đế Gò Đen, thường được gọi tắt là Đế Gò Đen, là tên một loại rượu trắng (rượu đế) nổi tiếng của Việt Nam. Đây là một loại rượu được nấu từ gạo, hoặc nếp mỡ, nếp than, theo phương pháp cổ truyền, sản xuất ở địa danh Gò Đen, Bến Lức, tỉnh Long An.', N'ruou-go-den-1-400.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 56, 9, 4, 36)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (37, N'Rượu Nếp', CAST(320000 AS Decimal(18, 0)), N'Rượu nếp là một loại rượu truyền thống của Việt nam được làm từ nguyên liệu gạo nếp lên men và được đem đi chưng cất để lấy rượu.', N'ruou-nep-nga-son1.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 23, 1, 5, 37)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (38, N'Rượu Shochu', CAST(420000 AS Decimal(18, 0)), N'Shochu (燒酒,  しょうちゅう) là một thứ rượu trắng của Nhật Bản, được lên men rồi chưng cất từ lúa mạch, khoai và gạo. Thứ rượu này lại có nhiều loại với độ cồn khác nhau.', N'shou-chu.png', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 78, 10, 3, 38)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (39, N'Rượu Hoàng Tửu', CAST(510000 AS Decimal(18, 0)), N'Hoàng Tửu là rượu được làm ra từ Gạo ủ lên men sau đó ngâm với rượu nếp, được chứa trong chum sành và hạ thổ tối thiểu 3 tháng 10 ngày (Bách Nhật).', N'Hoang-tuu.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 65, 7, 2, 39)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (40, N'Rượu Bạch Tửu', CAST(610000 AS Decimal(18, 0)), N'Cũng như nhiều dân tộc khác ở vào vùng khí hậu lạnh, dân tộc Trung Hoa thường thích rượu. Khái niệm rượu đã được người xưa kết hợp với khái niệm lễ, không có rượu không thành lễ nghi (vô tửu bất thành lễ). Rượu là thức uống kích thích niềm sảng khoái, và cũng được dùng trong y dược Trung Hoa như một chất xúc tác', N'Baekju-bach-tuu.jpg', CAST(N'2014-10-25 00:00:00' AS SmallDateTime), 78, 7, 5, 40)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (60, N'Rượu vang Le', CAST(300000 AS Decimal(18, 0)), N'Rượu vang có một lịch sử phong phú hàng ngàn năm, với việc sản xuất rượu vang sớm nhất cho đến nay được phát hiện đã xảy ra khoảng 6000 TCN ở Georgia.[5][6][7] Kỹ năng sản xuất rượu vang đã xuất hiện ở khu vực Balkan khoảng 4500 TCN. Rượu vang đã được uống để ăn mừng ở Hy Lạp cổ đại và La Mã cổ đại.', N'ruou-vang-le-petit-haut-lafitte-trang-1.jpg', CAST(N'2018-05-01 18:14:00' AS SmallDateTime), 50, 6, 1, 28)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (61, N'Passion', CAST(500000 AS Decimal(18, 0)), N'Rượu vang có một lịch sử phong phú hàng ngàn năm, với việc sản xuất rượu vang sớm nhất cho đến nay được phát hiện đã xảy ra khoảng 6000 TCN ở Georgia.[5][6][7] Kỹ năng sản xuất rượu vang đã xuất hiện ở khu vực Balkan khoảng 4500 TCN. Rượu vang đã được uống để ăn mừng ở Hy Lạp cổ đại và La Mã cổ đại.', N'gia-ruou-vang-Passion.jpg', CAST(N'2018-05-01 18:22:00' AS SmallDateTime), 50, 8, 2, 40)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (62, N'Ba Kích', CAST(150000 AS Decimal(18, 0)), N'Rượu trắng, rượu đế, rượu ngang, rượu gạo, rượu chưng, rượu cuốc lủi hay rượu quốc lủi đều là cách gọi của loại rượu chưng cất từ ngũ cốc lên men được làm một cách thủ công trong dân gian, rất thịnh hành trong ẩm thực Việt Nam.', N'ruou-ba-kich.JPG', CAST(N'2018-05-01 18:23:00' AS SmallDateTime), 100, 8, 2, 40)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (63, N'Vodka', CAST(50000 AS Decimal(18, 0)), N'Rượu trắng, rượu đế, rượu ngang, rượu gạo, rượu chưng, rượu cuốc lủi hay rượu quốc lủi đều là cách gọi của loại rượu chưng cất từ ngũ cốc lên men được làm một cách thủ công trong dân gian, rất thịnh hành trong ẩm thực Việt Nam.', N'ruou-vodka-bay-air-club-300x300.png', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 100, 1, 4, 33)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (64, N'Strawberry', CAST(500000 AS Decimal(18, 0)), N'Sâm banh (bắt nguồn từ tiếng Pháp: champagne)[1], còn gọi là sâm panh, là một dạng vang nổ được sản xuất bằng cách tạo ra sự lên men thứ cấp trong chai chứa rượu vang để thực hiện sự cacbonat hóa. Nó được đặt tên theo khu vực Champagne của Pháp. Trong khi thuật ngữ "champagne" (sâm panh) thông thường được các nhà sản xuất vang nổ tại các khu vực khác trên thế giới sử dụng để chỉ sản phẩm của mình thì có nhiều ý kiến cho rằng nó nên được sử dụng một cách chính xác để chỉ tới các loại rượu vang được sản xuất tại khu vực Champagne. Nguyên tắc này được coi trọng tại Liên minh châu Âu bằng quan hệ pháp lý của tên gọi được bảo hộ về nguồn gốc (PDO).', N'Strawberry-Wine.jpg', CAST(N'2018-05-01 18:23:00' AS SmallDateTime), 100, 8, 2, 40)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (65, N'macallan', CAST(350000 AS Decimal(18, 0)), N'Rượu vang có một lịch sử phong phú hàng ngàn năm, với việc sản xuất rượu vang sớm nhất cho đến nay được phát hiện đã xảy ra khoảng 6000 TCN ở Georgia.[5][6][7] Kỹ năng sản xuất rượu vang đã xuất hiện ở khu vực Balkan khoảng 4500 TCN. Rượu vang đã được uống để ăn mừng ở Hy Lạp cổ đại và La Mã cổ đại.', N'macallan-gold.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 100, 2, 3, 28)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (66, N'mercurey', CAST(200000 AS Decimal(18, 0)), N'Rượu vang có một lịch sử phong phú hàng ngàn năm, với việc sản xuất rượu vang sớm nhất cho đến nay được phát hiện đã xảy ra khoảng 6000 TCN ở Georgia.[5][6][7] Kỹ năng sản xuất rượu vang đã xuất hiện ở khu vực Balkan khoảng 4500 TCN. Rượu vang đã được uống để ăn mừng ở Hy Lạp cổ đại và La Mã cổ đại.', N'ruou-vang-mercurey.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 70, 5, 5, 28)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (67, N'finca rose', CAST(200000 AS Decimal(18, 0)), N'Sake (phiên âm tiếng Việt sa kê) theo cách hiểu phổ biến trên thế giới là một thứ rượu nhẹ truyền thống nấu từ gạo qua nhiều công đoạn lên men mà người Nhật gọi là Nihonshu (日本酒 | Rượu Nhật Bản) hoặc Luật Thuế Rượu của Nhật Bản gọi là Seishu.', N'finca-flichman-rose.png', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 10, 3, 5, 35)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (68, N'WINE', CAST(400000 AS Decimal(18, 0)), N'Brandy là tên gọi chung của các loại rượu mạnh được chế biến từ sự chưng cất của rượu vang hoặc từ trái cây nghiền nát rồi ủ lâu trong thùng gỗ một thời gian (ít nhất là hai năm). Sau đó được làm giảm nồng độ rượu bằng cách pha thêm nước cất.', N'WINE-10-1-300x300.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 50, 8, 4, 29)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (69, N'Suntory', CAST(700000 AS Decimal(18, 0)), N'Sâm banh (bắt nguồn từ tiếng Pháp: champagne)[1], còn gọi là sâm panh, là một dạng vang nổ được sản xuất bằng cách tạo ra sự lên men thứ cấp trong chai chứa rượu vang để thực hiện sự cacbonat hóa. Nó được đặt tên theo khu vực Champagne của Pháp. Trong khi thuật ngữ "champagne" (sâm panh) thông thường được các nhà sản xuất vang nổ tại các khu vực khác trên thế giới sử dụng để chỉ sản phẩm của mình thì có nhiều ý kiến cho rằng nó nên được sử dụng một cách chính xác để chỉ tới các loại rượu vang được sản xuất tại khu vực Champagne. Nguyên tắc này được coi trọng tại Liên minh châu Âu bằng quan hệ pháp lý của tên gọi được bảo hộ về nguồn gốc (PDO).', N'Ruou-Suntory-old-whisky-300x300.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 68, 9, 4, 31)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (70, N'argen', CAST(400000 AS Decimal(18, 0)), N'Rượu Rum là một đồ uống có cồn được chưng cất từ mía với sản phẩm như mật đường, hoặc trực tiếp từ nước mía, một quá trình lên men và chưng cất. Chưng cất, một chất lỏng rõ ràng, thường là sau đó độ tuổi trong thùng gỗ sồi. Rum có thể được gọi tên theo các mô tả như "ron Viejo" ("rum cũ") và "ron añejo" ("rum có tuổi").', N'argen-300x300.png', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 90, 4, 4, 30)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (71, N'belnor', CAST(600000 AS Decimal(18, 0)), N'Brandy là tên gọi chung của các loại rượu mạnh được chế biến từ sự chưng cất của rượu vang hoặc từ trái cây nghiền nát rồi ủ lâu trong thùng gỗ một thời gian (ít nhất là hai năm). Sau đó được làm giảm nồng độ rượu bằng cách pha thêm nước cất.', N'images (15).jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 120, 5, 5, 29)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (72, N'Giesen', CAST(350000 AS Decimal(18, 0)), N'Sake (phiên âm tiếng Việt sa kê) theo cách hiểu phổ biến trên thế giới là một thứ rượu nhẹ truyền thống nấu từ gạo qua nhiều công đoạn lên men mà người Nhật gọi là Nihonshu (日本酒 | Rượu Nhật Bản) hoặc Luật Thuế Rượu của Nhật Bản gọi là Seishu.', N'Giesen-Sauvignon-Blanc.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 45, 4, 2, 35)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (74, N'Lumen.jpg', CAST(550000 AS Decimal(18, 0)), N'Rượu vang có một lịch sử phong phú hàng ngàn năm, với việc sản xuất rượu vang sớm nhất cho đến nay được phát hiện đã xảy ra khoảng 6000 TCN ở Georgia.[5][6][7] Kỹ năng sản xuất rượu vang đã xuất hiện ở khu vực Balkan khoảng 4500 TCN. Rượu vang đã được uống để ăn mừng ở Hy Lạp cổ đại và La Mã cổ đại.', N'Lumen.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 54, 4, 2, 28)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (75, N'Suntory', CAST(450000 AS Decimal(18, 0)), N'Sake (phiên âm tiếng Việt sa kê) theo cách hiểu phổ biến trên thế giới là một thứ rượu nhẹ truyền thống nấu từ gạo qua nhiều công đoạn lên men mà người Nhật gọi là Nihonshu (日本酒 | Rượu Nhật Bản) hoặc Luật Thuế Rượu của Nhật Bản gọi là Seishu.', N'suntory-royal.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 68, 9, 5, 35)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (76, N'danzo', CAST(150000 AS Decimal(18, 0)), N'Brandy là tên gọi chung của các loại rượu mạnh được chế biến từ sự chưng cất của rượu vang hoặc từ trái cây nghiền nát rồi ủ lâu trong thùng gỗ một thời gian (ít nhất là hai năm). Sau đó được làm giảm nồng độ rượu bằng cách pha thêm nước cất.', N'images (27).jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 40, 7, 1, 29)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (77, N'Gigondas.png', CAST(350000 AS Decimal(18, 0)), N'Shochu (燒酒, しょうちゅう) là một thứ rượu trắng của Nhật Bản, được lên men rồi chưng cất từ lúa mạch, khoai và gạo. Thứ rượu này lại có nhiều loại với độ cồn khác nhau.', N'Gigondas.png', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 65, 10, 3, 38)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (78, N'Icewine', CAST(200000 AS Decimal(18, 0)), N'Sake (phiên âm tiếng Việt sa kê) theo cách hiểu phổ biến trên thế giới là một thứ rượu nhẹ truyền thống nấu từ gạo qua nhiều công đoạn lên men mà người Nhật gọi là Nihonshu (日本酒 | Rượu Nhật Bản) hoặc Luật Thuế Rượu của Nhật Bản gọi là Seishu.', N'Icewine-Riesling.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 25, 3, 4, 35)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (79, N'dragon', CAST(550000 AS Decimal(18, 0)), N'Rượu Rum là một đồ uống có cồn được chưng cất từ mía với sản phẩm như mật đường, hoặc trực tiếp từ nước mía, một quá trình lên men và chưng cất. Chưng cất, một chất lỏng rõ ràng, thường là sau đó độ tuổi trong thùng gỗ sồi. Rum có thể được gọi tên theo các mô tả như "ron Viejo" ("rum cũ") và "ron añejo" ("rum có tuổi").', N'images (9).jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 60, 7, 4, 30)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (80, N'Koenig', CAST(700000 AS Decimal(18, 0)), N'Hoàng Tửu là rượu được làm ra từ Gạo ủ lên men sau đó ngâm với rượu nếp, được chứa trong chum sành và hạ thổ tối thiểu 3 tháng 10 ngày (Bách Nhật).', N'Koenig.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 40, 7, 3, 39)
INSERT [dbo].[RUOU] ([MaRuou], [TenRuou], [Giaban], [Mota], [AnhRuou], [NgayCapNhat], [SoLuongTon], [MaXXu], [MaNCC], [MaLoaiRuou]) VALUES (81, N'two fingers.', CAST(1000000 AS Decimal(18, 0)), N'Cũng như nhiều dân tộc khác ở vào vùng khí hậu lạnh, dân tộc Trung Hoa thường thích rượu. Khái niệm rượu đã được người xưa kết hợp với khái niệm lễ, không có rượu không thành lễ nghi (vô tửu bất thành lễ). Rượu là thức uống kích thích niềm sảng khoái, và cũng được dùng trong y dược Trung Hoa như một chất xúc tác', N'two-fingers.jpg', CAST(N'2018-05-01 00:00:00' AS SmallDateTime), 60, 7, 1, 40)
SET IDENTITY_INSERT [dbo].[RUOU] OFF
SET IDENTITY_INSERT [dbo].[XUATXU] ON 

INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (1, N'Việt Nam')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (2, N'Pháp')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (3, N'Nhật Bản')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (4, N'Ý ')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (5, N'Tây Ban Nha')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (6, N'Mỹ')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (7, N'Trung Quốc')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (8, N'Bỉ ')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (9, N'Đức')
INSERT [dbo].[XUATXU] ([MaXXu], [TenXXu]) VALUES (10, N'Hàn Quốc')
SET IDENTITY_INSERT [dbo].[XUATXU] OFF
ALTER TABLE [dbo].[CHITIETDONTHANG]  WITH CHECK ADD  CONSTRAINT [FK_CTDatHang] FOREIGN KEY([Maruou])
REFERENCES [dbo].[RUOU] ([MaRuou])
GO
ALTER TABLE [dbo].[CHITIETDONTHANG] CHECK CONSTRAINT [FK_CTDatHang]
GO
ALTER TABLE [dbo].[CHITIETDONTHANG]  WITH CHECK ADD  CONSTRAINT [FK_CTKhachhang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DONDATHANG] ([MaDH])
GO
ALTER TABLE [dbo].[CHITIETDONTHANG] CHECK CONSTRAINT [FK_CTKhachhang]
GO
ALTER TABLE [dbo].[DONDATHANG]  WITH CHECK ADD  CONSTRAINT [FK_Khachhang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KHACHHANG] ([MaKH])
GO
ALTER TABLE [dbo].[DONDATHANG] CHECK CONSTRAINT [FK_Khachhang]
GO
ALTER TABLE [dbo].[RUOU]  WITH CHECK ADD  CONSTRAINT [FK_RUOU_NHACUNGCAP] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NHACUNGCAP] ([MaNCC])
GO
ALTER TABLE [dbo].[RUOU] CHECK CONSTRAINT [FK_RUOU_NHACUNGCAP]
GO
ALTER TABLE [dbo].[RUOU]  WITH CHECK ADD  CONSTRAINT [FK_RUOU_PHANLOAI1] FOREIGN KEY([MaLoaiRuou])
REFERENCES [dbo].[PHANLOAI] ([MaLoaiRuou])
GO
ALTER TABLE [dbo].[RUOU] CHECK CONSTRAINT [FK_RUOU_PHANLOAI1]
GO
ALTER TABLE [dbo].[RUOU]  WITH CHECK ADD  CONSTRAINT [FK_RUOU_XUATXU] FOREIGN KEY([MaXXu])
REFERENCES [dbo].[XUATXU] ([MaXXu])
GO
ALTER TABLE [dbo].[RUOU] CHECK CONSTRAINT [FK_RUOU_XUATXU]
GO
ALTER TABLE [dbo].[CHITIETDONTHANG]  WITH CHECK ADD CHECK  (([Dongia]>=(0)))
GO
ALTER TABLE [dbo].[CHITIETDONTHANG]  WITH CHECK ADD CHECK  (([Soluong]>(0)))
GO
