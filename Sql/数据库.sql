USE [master]
GO
/****** Object:  Database [TiKu]    Script Date: 2016-12-25  16:48:41 ******/
CREATE DATABASE [TiKu]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TiKu', FILENAME = N'E:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\TiKu.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TiKu_log', FILENAME = N'E:\Program Files (x86)\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\TiKu_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TiKu] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TiKu].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TiKu] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TiKu] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TiKu] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TiKu] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TiKu] SET ARITHABORT OFF 
GO
ALTER DATABASE [TiKu] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TiKu] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [TiKu] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TiKu] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TiKu] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TiKu] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TiKu] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TiKu] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TiKu] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TiKu] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TiKu] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TiKu] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TiKu] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TiKu] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TiKu] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TiKu] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TiKu] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TiKu] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TiKu] SET RECOVERY FULL 
GO
ALTER DATABASE [TiKu] SET  MULTI_USER 
GO
ALTER DATABASE [TiKu] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TiKu] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TiKu] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TiKu] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [TiKu]
GO
/****** Object:  Table [dbo].[简答题]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[简答题](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](1000) NULL,
	[answer] [varchar](1000) NULL,
	[knowledge] [varchar](1000) NULL,
	[subject] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[判断题]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[判断题](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](1000) NULL,
	[answer] [varchar](1000) NULL,
	[knowledge] [varchar](1000) NULL,
	[subject] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[所有题型]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[所有题型](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[题型] [varchar](100) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[题型]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[题型](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[题型] [varchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[题型1]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[题型1](
	[题号] [int] IDENTITY(1,1) NOT NULL,
	[题型] [varchar](100) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[填空题]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[填空题](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](1000) NULL,
	[answer] [varchar](1000) NULL,
	[knowledge] [varchar](1000) NULL,
	[subject] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[选择题]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[选择题](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](1000) NULL,
	[choice] [varchar](1000) NULL,
	[answer] [varchar](1000) NULL,
	[knowledge] [varchar](1000) NULL,
	[subject] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[学科]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[学科](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[学科] [varchar](100) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[应用题]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[应用题](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](1000) NULL,
	[answer] [varchar](1000) NULL,
	[knowledge] [varchar](1000) NULL,
	[subject] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[知识点]    Script Date: 2016-12-25  16:48:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[知识点](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[知识点] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [TiKu] SET  READ_WRITE 
GO
