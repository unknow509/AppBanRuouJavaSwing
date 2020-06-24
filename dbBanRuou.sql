Create database QLBANRUOU
go
USE [QLBANRUOU]
GO
/****** Object:  Table [dbo].[ADMIN]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[CHITIETDONTHANG]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[DONDATHANG]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[NHACUNGCAP]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[PHANLOAI]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[RUOU]    Script Date: 06/24/2020 7:00:24 PM ******/
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
/****** Object:  Table [dbo].[XUATXU]    Script Date: 06/24/2020 7:00:24 PM ******/
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
