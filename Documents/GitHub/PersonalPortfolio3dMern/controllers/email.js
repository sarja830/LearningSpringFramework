const nodemailer = require('nodemailer');
const { NODE_MAILER_EMAIL,EMAIL, PASSWORD } = require('../config /keys');

exports.sendEmail = async(req,res)=> {
    // create reusable transporter object using the default SMTP transport
    let transporter = nodemailer.createTransport({
        service:'gmail',
        auth:{
            user: NODE_MAILER_EMAIL,
            pass: PASSWORD
        }
    })
    // {
    //     from_name: form.name,
    //         from_email: form.email,
    //     message: form.message,
    // };
    const emailData2 = {
        to: EMAIL,
        from: NODE_MAILER_EMAIL,
        subject: `Someone contacted you through you portfolio website`,
        html: `
            <p>Hey Sarthak, The contact details is as follows: 
               Name: ${req.body.from_name}
               Email: ${req.body.from_email}
               Message: ${req.body.message}
            </p>
        `
    };

    // send mail with defined transport object
    try
    {
        let info = await transporter.sendMail(emailData2, function (err, data) {
            if (err) {
                console.log(err)
            } else {
                console.log("email sent succesfuly to user")
            }
        });
        return res.json({
            message: `Email has been sent succesfuly`
        });
    }
    catch(err) {
        return res.json({
            err
        });
    }
}



