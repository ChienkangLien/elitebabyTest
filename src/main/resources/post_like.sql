create table postlike
(
    like_id int auto_increment
        primary key,
    user_id int not null,
    post_id int not null,
    constraint postlike_pk
        unique (post_id, user_id),
    constraint postlike_member_USER_ID_fk
        foreign key (user_id) references tibameproject.member (USER_ID),
    constraint postlike_post_post_id_fk
        foreign key (post_id) references tibameproject.post (post_id)
);

insert into post_like(user_id,post_id) values (1,5),(1,4),(1,3),(1,2),(1,15),
                                             (2,5),(2,4),(2,3),(2,2),
                                             (3,5),(3,4),(3,3),
                                             (4,5),(4,4),
                                             (5,5);