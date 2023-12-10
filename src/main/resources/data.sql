CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    admin bit not null,
    created_at VARCHAR(50),
    email      VARCHAR(50) UNIQUE NOT NULL,
    first_name VARCHAR(20)  not null,
    password   VARCHAR(120),
    updated_at VARCHAR(6)
);

CREATE TABLE IF NOT EXISTS subjects
(
    id  INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(500),
    title       VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS subscriptions
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject_id bigint not null,
    user_id    bigint not null,
    primary key (id, user_id, subject_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

CREATE TABLE IF NOT EXISTS posts
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    created_at  VARCHAR(6),
    description VARCHAR(5000),
    title       VARCHAR(200) ,
    updated_at  VARCHAR(6),
    author_id   bigint not null,
    subject_id  bigint not null,
    FOREIGN KEY (author_id) REFERENCES users (id),
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
);

CREATE TABLE IF NOT EXISTS messages
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    created_at VARCHAR(20)  not null,
    message    VARCHAR(500),
    post_id    bigint    not   null,
    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (author_id) REFERENCES users (id)
);

INSERT INTO users (admin, created_at, email, first_name, password, updated_at)
VALUES (1, '2023-01-01', 'admin@example.com', 'Admin', 'hashed_password', '2023-01-02'),
       (0, '2023-01-03', 'user1@example.com', 'User1', 'hashed_password_1', '2023-01-04'),
       (0, '2023-01-05', 'user2@example.com', 'User2', 'hashed_password_2', '2023-01-06');

INSERT INTO subjects (description, title)
VALUES ('Science-related discussions', 'Science'),
       ('Technology-related discussions', 'Technology'),
       ('General discussions', 'General');

INSERT INTO subscriptions (subject_id, user_id)
VALUES (1, 2), -- User1 subscribes to Science
       (2, 3), -- User2 subscribes to Technology
       (3, 1); -- Admin subscribes to General


INSERT INTO posts (created_at, description, title, updated_at, author_id, subject_id)
VALUES ('2023-01-10', 'Discussing the latest scientific discoveries.', 'Science News', '2023-01-11', 2, 1),
       ('2023-01-12', 'New technologies shaping the future.', 'Tech Trends', '2023-01-13', 3, 2),
       ('2023-01-14', 'General discussion thread.', 'General Chat', '2023-01-15', 1, 3);


INSERT INTO messages (created_at, message, post_id, author_id)
VALUES ('2023-01-20', 'Exciting news!', 1, 2),
       ('2023-01-22', 'I agree with that.', 1, 3),
       ('2023-01-25', 'Looking forward to it!', 2, 1);


