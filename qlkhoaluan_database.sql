use qlkhoaluan;

-- bảng khoa
CREATE TABLE Faculty (
	faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    name_faculty VARCHAR(255) not null,
    description_faculty text
);

-- bảng user
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    faculty_id int,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role enum('admin', 'coordinator', 'student', 'teacher') not null,
    avatar VARCHAR(255),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
    -- FOREIGN KEY (role_id) REFERENCES role(role_id)
);

-- bảng hội đồng
CREATE TABLE committee (
    committee_id INT AUTO_INCREMENT PRIMARY KEY,
    name_commitee varchar(255),
    lock_committee BOOLEAN,
    description_commitee text
);

-- bảng cho biết các giảng viên thuộc hội đồng nào
CREATE TABLE committee_member (
    committee_member_id INT AUTO_INCREMENT PRIMARY KEY,
    committee_id INT,
    user_id INT,
    role ENUM('president', 'secretary', 'reviewer', 'member') NOT NULL,
    FOREIGN KEY (committee_id) REFERENCES committee(committee_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- bảng khoá luận
CREATE TABLE thesis (
    thesis_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year_thesis INT,
    adviser_1_id INT,
    adviser_2_id INT,
    student_1_id INT,
    student_2_id INT,
    status ENUM('new', 'defended', 'graded') NOT NULL,
    average_score FLOAT, -- điểm trung bình
    total_score FLOAT, -- điểm tổng
    committee_id INT, -- để liên kết với hội đồng
    FOREIGN KEY (adviser_1_id) REFERENCES Users(user_id),
    FOREIGN KEY (adviser_2_id) REFERENCES Users(user_id),
    FOREIGN KEY (student_1_id) REFERENCES Users(user_id),
    FOREIGN KEY (student_2_id) REFERENCES Users(user_id),
    FOREIGN KEY (committee_id) REFERENCES committee(committee_id)
);

-- bảng tiêu chí
CREATE TABLE criteria (
	criteria_id int AUTO_INCREMENT PRIMARY KEY,
    criteria_description VARCHAR(200) NOT NULL
);

-- bảng cho biết tiêu chí này thuộc khoá luận nào
create table thesis_criteria (
	thesis_criteria_id INT AUTO_INCREMENT PRIMARY KEY,
    thesis_id int not null,
    criteria_id int not null,
    description text,
	FOREIGN KEY (thesis_id) REFERENCES Thesis(thesis_id),
    FOREIGN KEY (criteria_id) REFERENCES criteria(criteria_id)
);

-- bảng chấm điểm theo tiêu chí của khoá luận và lưu từng thành viên trong hội đồng
create table score_thesis_criteria (
	score_thesis_criteria_id INT AUTO_INCREMENT PRIMARY KEY,
    score_by_committee_members int not null,
    score float not null,
    thesis_criteria_id int not null,
    description_score text,
    FOREIGN KEY (score_by_committee_members) REFERENCES committee_member(committee_member_id),
    FOREIGN KEY (thesis_criteria_id) REFERENCES thesis_criteria(thesis_criteria_id)
);
