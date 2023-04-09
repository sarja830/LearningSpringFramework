const express = require("express");
const router = express.Router();

const {
   sendEmail
} = require("../controllers/email");


router.post('/email/send', sendEmail);
module.exports = router;