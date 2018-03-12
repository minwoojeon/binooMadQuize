
//project setup
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const session = require('express-session');
const methodOverride = require("method-override");
const mongoose = require('mongoose');

const morgan = require('morgan');
const port     = process.env.PORT || 3000;

//DB settings
//require('./config/dbManager');
// DB setting
mongoose.connect(process.env.MONGO_DB, { useMongoClient: true }); // 1
var db = mongoose.connection; // 2
// 3﻿
db.once("open", function(){
 console.log("DB connected");
});
// 4
db.on("error", function(err){
 console.log("DB ERROR : ", err);
});

//Other settings

app.set('view engine', 'ejs'); // 뷰 엔진 ejs
app.use(express.static(__dirname+"/public"));

app.use(morgan('dev')) // 모든 요청 로그 콘솔에 정의
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.use(methodOverride("_method"));

app.use(session({
    secret: 'ambc@!vsmkv#!&*!#EDNAnsv#!$()_*#@',
    resave: false,
    saveUninitialized: true
}));


//라우터

app.use("/", require("./routers/home"))
app.use("/posts", require("./routers/posts"))

//require('./routers/home.js')(app);
//require('./routers/route.js')(app);


//시작
app.listen(port);
console.log('using port : ' + port);
