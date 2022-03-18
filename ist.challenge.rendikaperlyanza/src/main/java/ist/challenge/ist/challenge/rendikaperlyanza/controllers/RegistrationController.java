package ist.challenge.ist.challenge.rendikaperlyanza.controllers;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/registration")
    public BaseResponse registration(@Valid @RequestBody LoginModel login) {
        return registrationService.registerFunc(login);
    }
}
