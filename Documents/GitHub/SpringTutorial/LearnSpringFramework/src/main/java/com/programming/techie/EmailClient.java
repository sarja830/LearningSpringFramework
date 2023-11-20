package com.programming.techie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class EmailClient {

    // avoid field injection instead use setter or constructor injection
    // for this the values will be injected
//    @Autowired
//    @Qualifier("advancedSpellChecker")
    private SpellChecker spellChecker;

//    @Autowired
//    for constructor injection
//    public EmailClient(SpellChecker spellChecker)
//    {
//        this.spellChecker = spellChecker;
//    }


    public SpellChecker getSpellChecker() {
        return this.spellChecker;
    }

//    @qualifier overrides @Primary
    @Autowired
    @Qualifier("advancedSpellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    void sendEmail(String emailMessage) {
        spellChecker.checkSpelling(emailMessage);
        // Logic to Send Email
    }
}
