# WSDS schema

# --- !Ups

create schema dbo;

create table dbo.T_REF_DATA(
	id tinyint identity(1,1) NOT NULL,
	value char(6) NOT NULL,
	refDataType varchar(255) NOT NULL,
	hpamId tinyint,
	PRIMARY KEY (id)
);

create table dbo.T_CATEGORIES(
	id int identity(1,1) NOT NULL,
	category varchar (255)  NULL,
	type varchar (255)  NULL,
	PRIMARY KEY (id)
);

create table dbo.T_MODELS (
	id int identity(1,1) NOT NULL,
	brand nvarchar (255) NULL,
	name nvarchar(255) NULL,
	category nvarchar(255) NULL,
	barCode nvarchar(255) NULL,
	PRIMARY KEY (id)
);

create table dbo.T_FO (
    id int identity(1,1),
    account varchar(100),
    smPlatform varchar(100),
    cmdbPlatform varchar(100),
    PRIMARY KEY (id)
);

create table dbo.T_LOCATIONS (
	id int identity(1,1) NOT NULL,
	functionalOrg varchar(255),
	location int,
	name varchar(255),
	fullName varchar(255),
	locationStatus varchar (25),
	address1 varchar(255),
	address2 varchar(255),
	address3 varchar(255),
	address4 varchar(255),
	address5 varchar(255),
	city varchar(255),
	country varchar(255),
	state varchar(255),
	zip varchar(255),
	PRIMARY KEY (id)
);

create table dbo.T_COST_CENTRES (
	id int identity(1,1) NOT NULL,
	functionalOrg varchar(255),
	accountNo float,
	title varchar(255),
	PRIMARY KEY (id)
);

create table dbo.T_BUSINESS_UNITS (
	id int identity(1,1) NOT NULL,
	functionalOrg varchar(255),
	fullName varchar(255)	,
	name varchar(255),
	barCode varchar(255),
	PRIMARY KEY (id)
);

create table dbo.T_CONTACTS (
  	id int identity(1,1) NOT NULL,
  	functionalOrg varchar(255),
  	employeeNo varchar(255),
  	title varchar(10),
  	firstName varchar(50),
  	middleName varchar(50),
  	surname varchar(50),
  	phone varchar(20),
  	mobile varchar(20),
  	email varchar(100),
  	PRIMARY KEY (id)
  );

create table dbo.T_ASSETS (
	id int identity(1,1) NOT NULL,
	aoSDMLastTicketNumber varchar(255),--	Free Text?
	aoFOAoName int, -- Join on T_FO -> account
	locationFullName int, -- Join on T_LOCATIONS -> fullName
	-- userAoFOAoName int, --Can be derived from the contacts join - Join on T_FO -> account
	contact int, -- Join on T_CONTACTS -> functionalOrg
	assetSerialNo varchar(255), -- Free text?
	assetLabel varchar(255), -- Free text?
	assetAoCiName varchar(255), -- Free text?
	-- assetAoExtInvAccount int, -- Join on T_FO -> account
	assetAoPropertyType int, -- Join on T_PROPERTY_TYPES -> type
	assetStatus tinyint, -- Join on T_STATUS -> status
	assetSeverityName varchar(50), -- Fixed Value.
	assetAoServiceScope varchar(20), -- Fixed Value.
	brandName int,-- Join on T_BRANDS -> brand
	modelName int,-- Join on T_MODELS -> brand -> name
	-- modelParentFullName int,-- can be derived from the category join -  Join on T_MODELS -> category -> T_CATEGORIES -> category
	computerOperatingSystem int,-- Join on T_OS -> name
	computerTcpIpHostName varchar(255), -- Free text.
	aoATFExternalTool varchar(100),-- Fixed Value.
	aoDelete varchar(3),-- Fixed Value.
	seAssignment varchar(100),-- Fixed Value.
	objectAction int,-- Join on T_OBJECT_ACTIONS -> action
	objectType char(18),-- Fixed Value.
	aodAssignment date,--  SQL date now()
	dAssignment date, --  SQL date now()
	PRIMARY KEY (id)
);

# --- !Downs

drop schema dbo;

