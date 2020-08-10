select* from app_user
join study_set on app_user.user_id=study_set.study_set_id
join study_set_card on study_set_card.study_set_id=study_set.study_set_id
where user_id=5;
