create table post
(
    post_id  int auto_increment primary key,
    user_id int                                 not null,
    type    varchar(20)                         not null,
    topic   varchar(20)                         not null,
    content text                                not null,
    time    timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    constraint post_member_id_fk
        foreign key (user_id) references member(USER_ID)
);


insert into post (user_id, type, topic, content)
VALUES (1, '飲食', '掌握育嬰假與育嬰留職停薪津貼', '吃太多油'),
       (2, '運動', '慢跑', '每天跑步三十分鐘'),
       (3, '教育', '英文', '孩子的學習不能等'),
       (4, '飲食', '多吃青菜', '吃青菜有助消化'),
       (5, '運動', '跳繩', '跳一跳樓下就會抗議'),
       (3, '教育', '補習班', '很多老師教很爛'),
       (1, '飲食', '早餐', '荷包蛋漲五塊'),
       (4, '財務', '育嬰開銷', '養小孩跟買期貨一樣'),
       (5, '教育', '公立私立', '小孩要遠離8+9'),
       (1, '飲食', '早餐', '大冰奶加大'),
       (2, '財務', '尿布', '尿布好貴QQ'),
       (5, '教育', '才藝', '小學就去轉職班好嗎?'),
       (3, '教育', '補習班', '老師講話聽不懂'),
       (1, '飲食', '多吃青菜', '小孩子不喜歡吃菜'),
       (5, '運動', '健身', '小嬰兒可以吃乳清嗎?'),
       (4, '教育', '小孩長得很醜', '去學校會不會被霸凌'),
       (1, '飲食', '飲食開銷', '養小孩後，月底只能吃土'),
       (2, '財務', '育嬰開銷', '月薪3萬不小心懷孕了'),
       (2, '飲食', '小孩吃手指', '問他要不要加辣');

# 所有內文填充
update post set content ='Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.長用那其張傷作良落希地國天高？起們表皮。期間同院時發教你；食總寶賣教件哥商，研問臺世：稱布濟費天樹明大著、就管圖了通好務以麼己些在說花帶子德朋求中，化果一產內男致？出寫提們卻一！中照食。國華星後然，大同省，大應事事故明機麼好微熱有。一手也在……見在黃今國的老開首先趣夜、角似馬好電之的後生寫哥統生個著究任夫從不老外人條個試政寫，的音童外要最去。你答查；不我事不的起會經子面式小在民是商這見下，體人黨發的屋在造我的費創花種爸酒雲候星。心不賽的，社跑其和深存看兒局電公種深獨戰息行機裡型詩管關富黃時，我進加能向除投在數要更代花在個何面頭人千大新幾第！何在方一中意裡言生找仍這重行於教不人建些大能。的我設全神事、式體問般新民謝最須雄減生望看歡建他太上界兒展國布士。'
where 1 = 1 ;