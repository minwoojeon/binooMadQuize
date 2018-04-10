
//project setup
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const session = require('express-session');
// const methodOverride = require("method-override");
const mongoose = require('mongoose');


const flash = require('connect-flash');

const morgan = require('morgan');
const port     = process.env.PORT || 3000;

// DB setting - Mysql 사용
require('./config/dbManager');


// DB setting - MongoDB 사용
// mongoose.connect(process.env.MONGO_DB, { useMongoClient: true }); // 1
// var db = mongoose.connection; // 2
// // 3﻿
// db.once("open", function(){
//  console.log("DB connected");
// });
// // 4
// db.on("error", function(err){
//  console.log("DB ERROR : ", err);
// });
//Mysql Validator 를 사용해봐야 할것

//Other settings

app.set('view engine', 'ejs'); // 뷰 엔진 ejs
app.use(express.static(__dirname+"/public"));

app.use(morgan('dev')) // 모든 요청 로그 콘솔에 정의
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
// app.use(methodOverride("_method"));

app.use(session({
    secret: 'ambc@!vsmkv#!&*!#EDNAnsv#!$()_*#@',
    resave: false,
    saveUninitialized: true
}));
app.use(flash());


//라우터

app.use("/", require("./routers/home"))
app.use("/posts", require("./routers/posts"))

//require('./routers/home.js')(app);
//require('./routers/route.js')(app);


//시작
app.listen(port);
console.log('using port : ' + port);
