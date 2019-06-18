-- tạo bảng users và khoá chính cho bảng là trường user_id
CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);
-- sử dụng từ khoá PRIMARY ở cuối câu lệnh tạo khoá chính bảng roles
CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);
-- tạo khóa chính phức hợp
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);
-- tạo khóa chính khi thay đổi bảng hoặc bổ sung khóa chính sau khi đã tạo bảng contact
