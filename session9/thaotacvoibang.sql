-- tạo bảng contacts với các trường dữ liệu, khóa chính 
CREATE TABLE contacts(
contact_id INT(11) NOT NULL AUTO_INCREMENT,
last_name VARCHAR (30) NOT NULL,
first_name VARCHAR (26),
birthday DATE,
CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

-- tạo bảng suppliers sử dụng từ khóa DEFAULT 
CREATE TABLE suppliers(
suppliers_id INT(11) NOT NULL AUTO_INCREMENT,
suppliers_name VARCHAR(50) NOT NULL,
account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
CONSTRAINT suppliers_pk PRIMARY KEY(suppliers_id)	
);

-- xóa 2 bảng suppliers và contacts
DROP TABLE suppliers,contacts;

-- thêm cột mới cho bảng contacts
ALTER TABLE contacts
ADD full_name VARCHAR(40) NOT NULL
AFTER contact_id;

-- sửa cột trong bảng contact
ALTER TABLE contacts
ADD full_name VARCHAR(50) NOT NULL
AFTER contact_id;
-- đổi tên bảng contacts thành bảng people
ALTER TABLE contacts
RENAME TO people; 