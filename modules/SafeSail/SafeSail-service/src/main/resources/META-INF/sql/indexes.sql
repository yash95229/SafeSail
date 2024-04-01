create index IX_561942B4 on Safe_Sail_AadhaarVerification (aadhaarNumber[$COLUMN_LENGTH:75$]);

create index IX_E9D68356 on Safe_Sail_FieldConfiguration (fieldData[$COLUMN_LENGTH:75$]);
create index IX_FAE3D9F7 on Safe_Sail_FieldConfiguration (fieldName[$COLUMN_LENGTH:75$]);
create index IX_3CFE5E9 on Safe_Sail_FieldConfiguration (fieldShow);
create index IX_8D47A75E on Safe_Sail_FieldConfiguration (fieldSumAssured[$COLUMN_LENGTH:75$]);
create index IX_8C34CA9 on Safe_Sail_FieldConfiguration (fieldValue[$COLUMN_LENGTH:75$]);

create index IX_2D1562B1 on Safe_Sail_Form1 (userId);
create index IX_99B5745D on Safe_Sail_Form1 (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2A9B107A on Safe_Sail_LifeInsurance (aadharNumber[$COLUMN_LENGTH:75$]);
create index IX_EEDDB334 on Safe_Sail_LifeInsurance (emailAddress[$COLUMN_LENGTH:75$]);
create index IX_A7E194C2 on Safe_Sail_LifeInsurance (userId);
create index IX_F8823C2C on Safe_Sail_LifeInsurance (uuid_[$COLUMN_LENGTH:75$]);

create index IX_261CE964 on Safe_Sail_PanCardVerification (panNumber[$COLUMN_LENGTH:75$]);

create index IX_31CBB7E2 on Safe_Sail_Policies (uuid_[$COLUMN_LENGTH:75$]);

create index IX_F63DE7B5 on Safe_Sail_Policy (applicationNumber);
create index IX_E2C08CB3 on Safe_Sail_Policy (quoteId[$COLUMN_LENGTH:75$]);
create index IX_E9BF402E on Safe_Sail_Policy (userId);
create index IX_9FCB7340 on Safe_Sail_Policy (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6D047CC9 on Safe_Sail_ProductTable (productName[$COLUMN_LENGTH:75$]);
create index IX_45E383F3 on Safe_Sail_ProductTable (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6437A807 on Safe_Sail_UserTable (userId);
create index IX_512A2C47 on Safe_Sail_UserTable (uuid_[$COLUMN_LENGTH:75$]);

create index IX_82712B51 on Safe_Sail_visitorUser (uuid_[$COLUMN_LENGTH:75$]);