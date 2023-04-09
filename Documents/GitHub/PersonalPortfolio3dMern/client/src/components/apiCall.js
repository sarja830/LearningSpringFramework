import { API } from '../config';

export const sendMail = (mailData) => {
    return fetch(`${API}/email/send/`, {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(mailData)
    })
        .then(response => {
            return response.json();
        })
        .catch(err => {
            console.log(err);
        });
};
