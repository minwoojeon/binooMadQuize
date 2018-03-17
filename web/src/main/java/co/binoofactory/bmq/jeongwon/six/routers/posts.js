const express = require("express");
// const app = express();
const router = express.Router();
const { check, validationResult } = require('express-validator/check'); // 유효성 검사


//router.use(expressVaildator());
//const Post  = require("../models/Post");

// Index
router.get("/", function(req, res){
 // Post.find({})                  // 1
 // .sort("-createdAt")            // 1
 // .exec(function(err, posts){    // 1
 //  if(err) return res.json(err);
  // res.render("posts/index", {posts:posts});

  res.render("posts/index");
  // });
});

// New
router.get("/new", function(req, res){
 res.render("posts/new");
});

// create
router.post("/",[
  check('title')
  .isEmail().withMessage('is not match')
  .trim()
  .normalizeEmail()



], (req, res, next) => {
  const errors = validationResult(req);
  if(!errors.isEmpty()){
    return res.status(422).json({errors : errors.mapped()});
  }

  return res.redirect("/posts");
  //var check = req.body;
  //var title = check.title;

  // var error = expressVaildator('title').isEmail();
  //title.checkQuery('title','Invaild emil type').isEmail();
  //var error = req.validationErrors();

  // var check = req.body;



  // console.log(error);
  //console.log(check);

  // if(error){
  //   res.status(401).send("Title Check Error");
  // }else {
  //   res.status(200).send("Title Check OK");
  // }
 // Post.create(req.body, function(err, post){
 //  if(err) return res.json(err);
  //res.redirect("/posts");
 // });
});

// show
router.get("/:id", function(req, res){
 // Post.findOne({_id:req.params.id}, function(err, post){
 //  if(err) return res.json(err);
 //  res.render("posts/show", {post:post});
 // });
});

// edit
router.get("/:id/edit", function(req, res){
 // Post.findOne({_id:req.params.id}, function(err, post){
 //  if(err) return res.json(err);
 //  res.render("posts/edit", {post:post});
 // });
});

// update
router.put("/:id", function(req, res){
 // req.body.updatedAt = Date.now(); // 2
 // Post.findOneAndUpdate({_id:req.params.id}, req.body, function(err, post){
 //  if(err) return res.json(err);
 //  res.redirect("/posts/"+req.params.id);
 // });
});

// destroy
router.delete("/:id", function(req, res){
 // Post.remove({_id:req.params.id}, function(err){
 //  if(err) return res.json(err);
 //  res.redirect("/posts");
 // });
});

module.exports = router;
