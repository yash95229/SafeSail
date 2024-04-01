create table Safe_Sail_AadhaarVerification (
	aadhaarId LONG not null primary key,
	aadhaarUserName VARCHAR(75) null,
	aadhaarNumber VARCHAR(75) null
);

create table Safe_Sail_FieldConfiguration (
	configId LONG not null primary key,
	fieldName VARCHAR(75) null,
	fieldData VARCHAR(75) null,
	fieldValue VARCHAR(75) null,
	fieldSumAssured VARCHAR(75) null,
	selectImage VARCHAR(75) null,
	fieldShow BOOLEAN
);

create table Safe_Sail_Form1 (
	uuid_ VARCHAR(75) null,
	sailId LONG not null,
	quoteId VARCHAR(75) not null,
	fullname VARCHAR(75) null,
	dob DATE null,
	gender VARCHAR(75) null,
	phoneNo LONG,
	emailAddress VARCHAR(75) null,
	panNumber VARCHAR(75) null,
	annualIncome LONG,
	sumAssured LONG,
	policyTerm INTEGER,
	PPTerm INTEGER,
	paymentFrequency VARCHAR(75) null,
	PayoutOption VARCHAR(75) null,
	lifeSecure INTEGER,
	lifePlus INTEGER,
	CIPBenefit INTEGER,
	totalValues LONG,
	totalAddon LONG,
	agreement BOOLEAN,
	userId LONG,
	primary key (sailId, quoteId)
);

create table Safe_Sail_LifeInsurance (
	uuid_ VARCHAR(75) null,
	quoteId VARCHAR(75) not null primary key,
	fullname VARCHAR(75) null,
	dob DATE null,
	gender VARCHAR(75) null,
	phoneNo LONG,
	emailAddress VARCHAR(75) null,
	aadharNumber VARCHAR(75) null,
	panNumber VARCHAR(75) null,
	annualIncome VARCHAR(75) null,
	sumAssured LONG,
	policyTerm INTEGER,
	PPTerm INTEGER,
	paymentFrequency VARCHAR(75) null,
	PayoutOption VARCHAR(75) null,
	lifeSecure INTEGER,
	lifePlus INTEGER,
	CIPBenefit INTEGER,
	addOnBenefits VARCHAR(75) null,
	totalValues LONG,
	totalAddon LONG,
	agreement BOOLEAN,
	userId LONG
);

create table Safe_Sail_PanCardVerification (
	panId LONG not null primary key,
	panUserName VARCHAR(75) null,
	panNumber VARCHAR(75) null
);

create table Safe_Sail_Policies (
	uuid_ VARCHAR(75) null,
	quoteId VARCHAR(75) not null,
	bookingId LONG not null,
	applicationNumber LONG not null,
	fullName VARCHAR(75) null,
	planName VARCHAR(75) null,
	annualIncome LONG,
	bookingDate DATE null,
	sumAssured LONG,
	policyTerm INTEGER,
	maturityDate DATE null,
	paymentFrequency VARCHAR(75) null,
	totalPremium LONG,
	status INTEGER,
	primary key (quoteId, bookingId, applicationNumber)
);

create table Safe_Sail_Policy (
	uuid_ VARCHAR(75) null,
	bookingId LONG not null,
	applicationNumber LONG not null,
	userId LONG,
	fullName VARCHAR(75) null,
	planName VARCHAR(75) null,
	annualIncome VARCHAR(75) null,
	bookingDate DATE null,
	sumAssured LONG,
	policyTerm INTEGER,
	maturityDate DATE null,
	paymentFrequency VARCHAR(75) null,
	totalPremium LONG,
	totalAddon LONG,
	status INTEGER,
	quoteId VARCHAR(75) not null,
	primary key (bookingId, applicationNumber, quoteId)
);

create table Safe_Sail_ProductTable (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	productName VARCHAR(75) null,
	premiumDiscount INTEGER,
	totalDiscount INTEGER,
	yearPay LONG,
	monthPay LONG,
	totalPremium LONG
);

create table Safe_Sail_UserTable (
	uuid_ VARCHAR(75) null,
	quoteId VARCHAR(75) not null primary key,
	userId LONG,
	userType VARCHAR(75) null
);

create table Safe_Sail_addOnFieldData (
	addonId LONG not null primary key,
	addonName VARCHAR(75) null,
	addonValue VARCHAR(75) null
);

create table Safe_Sail_visitorUser (
	uuid_ VARCHAR(75) null,
	visitorUserId LONG not null primary key,
	fullname VARCHAR(75) null,
	dob DATE null,
	gender VARCHAR(75) null,
	phoneNo LONG,
	emailAddress VARCHAR(75) null,
	panNumber VARCHAR(75) null,
	annualIncome LONG,
	sumAssured LONG,
	policyTerm INTEGER,
	PPTerm INTEGER,
	paymentFrequency VARCHAR(75) null,
	PayoutOption VARCHAR(75) null,
	lifeSecure INTEGER,
	lifePlus INTEGER,
	CIPBenefit INTEGER,
	totalValues LONG,
	totalAddon LONG,
	agreement BOOLEAN
);