package ist.challenge.ist.challenge.rendikaperlyanza.controllers;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.services.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListUserController {
    @Autowired
    private ListUserService listUserService;

    @GetMapping(value = "/listuser")
    public BaseResponse getUser() {
        return listUserService.getData();
    }

    @PutMapping(value = "/listuser/{id}")
    public BaseResponse editUser(@PathVariable long id, @RequestBody LoginModel loginModel) {
        return listUserService.updateData(id,loginModel);
    }
}
