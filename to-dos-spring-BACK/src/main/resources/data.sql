insert into user(id, username, password)
values(1, 'user1', 'user1');
insert into user(id, username, password)
values(2, 'user2', 'user2');
insert into user(id, username, password)
values(3, 'user3', 'user3');


insert into to_do(id, description, target_date, is_done, user_id)
values(1, 'Learn JPA', sysdate(), false, 1);
insert into to_do(id, description, target_date, is_done, user_id)
values(2, 'Read book', sysdate(), false, 1);
insert into to_do(id, description, target_date, is_done, user_id)
values(3, 'aaaaaaaaaaaa', sysdate(), false, 1);
insert into to_do(id, description, target_date, is_done, user_id)
values(4, 'bbbbbbbbbbbb', sysdate(), false, 1);


insert into to_do(id, description, target_date, is_done, user_id)
values(5, 'ccccccccc', sysdate(), false,2);
insert into to_do(id, description, target_date, is_done, user_id)
values(6, 'dddd dd', sysdate(), false, 2);
insert into to_do(id, description, target_date, is_done, user_id)
values(7, 'eeeeeeee', sysdate(), false,2);
insert into to_do(id, description, target_date, is_done, user_id)
values(8, 'ffffffff', sysdate(), false, 2);