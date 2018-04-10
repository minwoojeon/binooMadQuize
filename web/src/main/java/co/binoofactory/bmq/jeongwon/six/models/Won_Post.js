
const nameRegex = /^.{4,12}$/;
const usernameRegex = /^.{4,12}$/;
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$/;
const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/;

const nameRegexErrorMessage = "Should be 4-12 characters!";
const emailRegexErrorMessage = "Should be a vaild email address!";
const passwordRegexErrorMessage = "Should be minimum 8 characters of alphabet and number combination!";
const usernameRegexErrorMessage = "Should be 4-12 characters!";


exports.ValidationCheck_Users = (user_name, user_nickname, callback) => {
    var sql = `SELECT * FROM test_users WHERE id = '${user_id}'`

    connection.query(sql, function(err, rows){
        if (err)
            return callback(err); //에러처리
        if (rows.length) {
            return callback(null, false);//이미 아이디가 있음을 처리
        }else{ // 아이디 생성 로직은 passport 로직을 따왔음
          var newUserMysql = {
                        username: user_id,
                        password: bcrypt.hashSync(user_pwd, null, null),
                        nickname: user_nickname
                    };
                    //var insertQuery = `INSERT INTO test_users ( id, pw, nick ) values ('${newUserMysql.username}','${newUserMysql.password}', '${newUserMysql.nickname}')`;
                    //console.log(insertQuery);
                    var insertQuery = "INSERT INTO test_users ( id, pw, nick ) values (?,?,?)";

                    connection.query(insertQuery,[newUserMysql.username, newUserMysql.password, newUserMysql.nickname],function (err, rows) {
                      return callback(null, rows);
                    });

                    // connection.query(insertQuery,function(err, rows) {
                    //                         //console.log(rows);
                    //                         return callback(null, rows);
                    //                     });
        }
    });
}

userSchema.path("password").validate(function(v) {
  var user = this;

  // create user
  if(user.isNew){
    if(!user.passwordConfirmation){
      user.invalidate("passwordConfirmation", "Password Confirmation is required!");
    }
    if(!passwordRegex.test(user.password)){ // 2-3
      user.invalidate("password", passwordRegexErrorMessage); // 2-4
    } else if(user.password !== user.passwordConfirmation) {
      user.invalidate("passwordConfirmation", "Password Confirmation does not matched!");
    }
  }

  // update user
  if(!user.isNew){
    if(!user.currentPassword){
      user.invalidate("currentPassword", "Current Password is required!");
    }
    if(user.currentPassword && !bcrypt.compareSync(user.currentPassword, user.originalPassword)){
      user.invalidate("currentPassword", "Current Password is invalid!");
    }
    if(user.newPassword && !passwordRegex.test(user.newPassword)){ // 2-3
      user.invalidate("newPassword", passwordRegexErrorMessage); // 2-4
    } else if(user.newPassword !== user.passwordConfirmation) {
      user.invalidate("passwordConfirmation", "Password Confirmation does not matched!");
    }
  }
});
