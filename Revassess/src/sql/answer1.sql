select user_id,username,password,first_name,last_name,role_id from app_user join user_role on app_user.role_id=user_role.role_id where user_role.name='BASIC_USER';